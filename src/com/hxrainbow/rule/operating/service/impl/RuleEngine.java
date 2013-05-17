package com.hxrainbow.rule.operating.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.drools.runtime.StatefulKnowledgeSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hxrainbow.rule.model.TActionMeta;
import com.hxrainbow.rule.model.TActionMetaVariable;
import com.hxrainbow.rule.model.TActionVariable;
import com.hxrainbow.rule.model.TEntity;
import com.hxrainbow.rule.model.TEntityItem;
import com.hxrainbow.rule.model.TRule;
import com.hxrainbow.rule.operating.dao.ActionMetaDao;
import com.hxrainbow.rule.operating.dao.ConditionDao;
import com.hxrainbow.rule.operating.dao.RuleDao;
import com.hxrainbow.rule.operating.service.IAction;
import com.hxrainbow.rule.operating.service.IRuleEngine;
import com.hxrainbow.rule.operating.service.SceneService;
import com.hxrainbow.rule.util.DroolsUtil;
import com.hxrainbow.rule.util.RuleEngineException;
import com.hxrainbow.rule.util.SpringContextHolder;
import com.hxrainbow.rule.util.StringKit;

/**
 * 规则引擎核心
 * 
 * @author guolei
 * @version 1.0
 * @created 2013-4-18
 */
@Service("ruleEngine")
@Transactional(propagation=Propagation.NOT_SUPPORTED,readOnly=true)
public class RuleEngine implements IRuleEngine {

	private static Logger log = LoggerFactory.getLogger(RuleEngine.class);
	
	
	@Resource
	private SceneService sceneService;
	@Resource
	private ConditionDao conditionDao;
	@Resource
	private ActionMetaDao actionMetaDao;
	@Resource
	private RuleDao ruleDao;
	
	//规则fact对象的两个缓存map
	private Map<String, Set<String>> factActionMap = new HashMap<String, Set<String>>();//key:scene
	private Map<String,List<TEntity>> entityMap = new HashMap<String, List<TEntity>>();//key:scene
	
	static{
		System.setProperty("drools.dateformat", "yyyy-MM-dd");
	}
	
	@Override
	@Transactional(propagation=Propagation.NOT_SUPPORTED,readOnly=true)
	public List<Map<String,Object>> executeRuleEngine(Map<String,Object> factMap,String scene) throws RuleEngineException{
		
		StatefulKnowledgeSession ksession = DroolsUtil.getInstance().getDrlSessionInCache(scene);
		if(ksession != null){
			List<TEntity> entityList = entityMap.get(scene);
			return handleDroolsSession(ksession, factMap, null, entityList, scene);
		}else{
			return handleInEngine(factMap, scene);
		}
	}
	
	/**
	 * 没有缓存时重新拼装规则串，然后
	 * 
	 * @param factMap
	 * @param scene
	 * @return
	 * @throws RuleEngineException
	 * @author guolei
	 * @version 1.0
	 * @created 2013-5-2
	 */
	public List<Map<String,Object>> handleInEngine(Map<String,Object> factMap,String scene) throws RuleEngineException{
		
		
		
		StringBuffer droolRuleStr = new StringBuffer("package com.hxrainbow.rule").append(";").append("\n");
		droolRuleStr.append("global java.util.List $result;").append("\n");
		log.info("------------重新拼装规则串------------");
		//1.先根据场景标示查询场景信息，得到场景对应的实体以及实体标识对应的实体
		List<TEntity> entityList = sceneService.getEntityOfSceneByIdentity(scene);
		entityMap.put(scene, entityList);
		log.info("场景对应的实体个数为:{}",entityList.size());
		//2.根据场景标识加载可用的规则
		List<TRule> ruleList = sceneService.getEnabledRuleBySceneIdentity(scene);
		log.info("场景可用规则个数为:{}",ruleList.size());
		//3.根据实体信息先组合除drools的import语句
		droolRuleStr = insertImportInfor(droolRuleStr,ruleList,entityList);
		//4.遍历并拼出每个规则的执行drools串
		for(TRule rule : ruleList){
			StringBuffer temp = null;
			temp = getDroolsInfo(rule);
			droolRuleStr.append(temp);
		}
		log.info("\n" + "-----------------------规则串--------------------------------" + "\n" + droolRuleStr.toString());
		//5.根据第一步中得到的实体，初始化drools，将实体对象扔进引擎
		List<Map<String,Object>> resultList = handleInDrools(droolRuleStr,factMap,ruleList,entityList,scene);
		//6.记录
		return resultList;
	}
	
	/**
	 * 插入规则表达式的import部分
	 * 
	 * @param droolRuleStr
	 * @param entityList
	 * @return
	 * @author guolei
	 * @version 1.0
	 * @created 2013-4-18
	 */
	public  StringBuffer insertImportInfor(StringBuffer droolRuleStr,List<TRule> ruleList,List<TEntity> entityList){
		//导入场景对应的实体类
		for(TEntity entity : entityList){
			droolRuleStr.append("import").append("  ").append(entity.getPackageC()).append(";").append("\n");
		}
		//导入基本类
		droolRuleStr.append("import").append("  ").append("java.lang.String").append(";").append("\n");
		droolRuleStr.append("import").append("  ").append("java.util.Map").append(";").append("\n");
		droolRuleStr.append("import").append("  ").append("java.util.List").append(";").append("\n");
		//导入动作类
		Set<String> set = getAllActionClass(ruleList);
		for(Iterator<String> it=set.iterator();it.hasNext();){
		   droolRuleStr.append("import").append("  ").append(it.next()).append(";").append("\n");
		  }
		droolRuleStr.append("import").append("  ").append("com.hxrainbow.rule.operating.service.IAction").append(";").append("\n");
		return droolRuleStr;
	}
	/**
	 * 插入规则的名称
	 * 
	 * @param droolRuleStr
	 * @param rule
	 * @return
	 * @author guolei
	 * @version 1.0
	 * @created 2013-4-18
	 */
	public StringBuffer insertRuleName(StringBuffer droolRuleStr,TRule rule){
		droolRuleStr.append("rule").append(" ").append("rule_").append(rule.getId()).append("\n");
		return droolRuleStr;
	}
	/**
	 * 插入规则的有效期信息
	 * 
	 * @param sb
	 * @param rule
	 * @return
	 * @author guolei
	 * @version 1.0
	 * @created 2013-5-2
	 */
	private StringBuffer insertExpiryDate(StringBuffer sb, TRule rule) {
		if(rule.getBegin() != null){
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String begin = sdf.format(rule.getBegin());
			sb.append("date-effective \"" + begin +"\"").append("\n");
		}
		if(rule.getEnd() != null){
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String end = sdf.format(rule.getEnd());
			sb.append("date-expires \"" + end +"\"").append("\n");
		}
		return sb;
	}
	/**
	 * 插入规则条件,实体要定义时默认加$
	 * 
	 * 参考 http://docs.jboss.org/drools/release/5.5.0.Final/drools-expert-docs/html/ch04.html
	 * @param droolRuleStr
	 * @param rule
	 * @return
	 * @author guolei
	 * @version 1.0
	 * @created 2013-4-18
	 */
	public StringBuffer insertRuleCondition(StringBuffer droolRuleStr,TRule rule){
		droolRuleStr.append("when").append("\n");
		droolRuleStr.append("$map:Map()").append("\n");
		//0.拼接规则动作定义
		String[] actionIdArr = getActionIdOfRule(rule);
		for(String actionId : actionIdArr){
			droolRuleStr.append("$action").append(actionId).append(":").append("IAction()").append("\n");
		}
		//1.拿到规则的条件
		if(StringKit.isEmpty(rule.getCondition())){
			droolRuleStr.append("eval( true )").append("\n");
		}else{
			String condition = conditionDao.getConditionById(Integer.parseInt(rule.getCondition())).getCondition();
			String conditionTmp = condition;
			conditionTmp = conditionTmp.replaceAll("\\|\\|", "&&");
			conditionTmp = conditionTmp.replaceAll("\\)", "");
			conditionTmp = conditionTmp.replaceAll("\\(", "");
			
			HashMap<Integer,Integer> map = new HashMap<Integer,Integer>(20);//存放条件中是否已经写入变量如$card:Card中的$card
			String[] arr = conditionTmp.split("&&");
			//2.拿到每一个小的条件,这个版本中暂不对条件部分的动态变量做处理
			for(String item : arr){
				//先处理==、>=、<=、>、<、！=后面的变量，只处理静态变量，本版本不关注动态变量
				String conditionVariable = StringKit.getConditionOfVariable(item);
				String itemVariable = item;//存放处理变量后的item,主要是加引号
				if(!StringKit.checkContainOfOperator(conditionVariable)){
					if(!StringKit.checkStyleOfString(conditionVariable)){
						itemVariable = item.replace(conditionVariable, "'" + conditionVariable + "'");
					}
				}
				
				List<String> list = StringKit.getParamId(itemVariable);
				StringBuffer itemDrool = new StringBuffer();
				
				for(int i = 0;i < list.size();i++){//对每一个小的条件中的$d$部分做处理
					
					if(i == 0){
						String entityItemId = list.get(i);
						Object[] obj = conditionDao.getItemAndEntityByItemId(Integer.parseInt(entityItemId));
						TEntity entity = (TEntity)obj[0];
						TEntityItem entityItem = (TEntityItem)obj[1];
						
						String clazz = entity.getEntityClazz();
						
						if(map.get(entity.getId()) == null){
							map.put(entity.getId(), 1);
							itemDrool.append("$");
							itemDrool.append(entity.getIdentify());
							itemDrool.append(":");
						}
						itemDrool.append(clazz);
						itemDrool.append("(");
						itemDrool.append(entityItem.getField());
					}else{
						log.info("动态条件变量.............");
					}
				}
				String itemReplace = itemVariable.replace("$" + list.get(0) + "$", itemDrool.toString());
				itemReplace = itemReplace + ")";
				condition = condition.replace(item, itemReplace);	
			}
			droolRuleStr.append(condition).append("\n");
		}
		
		return droolRuleStr;
	}
	
	/**
	 * 规则动作部分组装处理
	 * 
	 * @param droolRuleStr
	 * @param rule
	 * @return
	 * @author guolei
	 * @version 1.0
	 * @created 2013-4-19
	 */
	public StringBuffer insertRuleAction(StringBuffer droolRuleStr,TRule rule){
		
		droolRuleStr.append("then").append("\n");
		String [] arr = getActionIdOfRule(rule);
		if(arr == null){
			droolRuleStr.append("end");
			droolRuleStr.append("\n");
			return droolRuleStr;
		}else{
			for(String actionIdStr :arr){
				Integer actionId = Integer.parseInt(actionIdStr);
				TActionMeta actionMeta = ruleDao.getActionMetaByActionId(actionId);
				List<Object[]> variableList = ruleDao.getActionVariableList(actionMeta.getId(),actionId);
				
				for(Object[] tempObj : variableList){
					TActionMetaVariable variable = (TActionMetaVariable)tempObj[0];
					TActionVariable middle = (TActionVariable)tempObj[1];
					
					droolRuleStr.append("$map.put(\"" + variable.getIdentify()  + "\",");//map.put(value,
					String value = middle.getVariableValue();
					List<String> tempList = StringKit.getParamId(value);
					if(tempList.size() > 0){//动态变量处理
						StringBuffer dynamicAction = new StringBuffer();
						for(String temp : tempList){
							Object[] itemArr = conditionDao.getItemAndEntityByItemId(Integer.parseInt(temp));
							TEntity entity = (TEntity)itemArr[0];
							TEntityItem entityItem = (TEntityItem)itemArr[1];
							dynamicAction.append("$").append(entity.getIdentify()).append(".").append(getMethodByProperty(entityItem.getField())).append("()");
							value = value.replace("$" + temp + "$", dynamicAction.toString());
						}
					}
					droolRuleStr.append(value);
					
					droolRuleStr.append(")");
					droolRuleStr.append(";");
					droolRuleStr.append("\n");
				}
				
				//set 规则 名称
				droolRuleStr.append("$map.put(\"ruleName\",\"");
				droolRuleStr.append(rule.getName());
				droolRuleStr.append("\")");
				droolRuleStr.append(";");
				droolRuleStr.append("\n");
				
				droolRuleStr.append("$action");
				droolRuleStr.append(actionIdStr);
				droolRuleStr.append(".");
				droolRuleStr.append("execute");
				droolRuleStr.append("($map,$result)");
				droolRuleStr.append(";");
				droolRuleStr.append("\n");
			}
			droolRuleStr.append("end");
			droolRuleStr.append("\n");
		}
		return droolRuleStr;
	}
	/**
	 * 根据规则查询其设计的actionMeta
	 * 
	 * @param rule
	 * @return
	 * @author guolei
	 * @version 1.0
	 * @created 2013-4-19
	 */
	public List<TActionMeta> getActionMetaOfRule(TRule rule){
		List<TActionMeta> list = new ArrayList<TActionMeta>();
		String actionStr = rule.getAction();
		String [] arr = actionStr.split("&&");
		if(arr == null || arr.length == 0 || StringKit.isEmpty(arr[0])){
			return new ArrayList<TActionMeta>();
		}else{
			for(String actionIdStr :arr){
				Integer actionId = Integer.parseInt(actionIdStr);
				Object[] obj = actionMetaDao.getActionAndMetaById(actionId);
				TActionMeta meta = (TActionMeta)obj[1];
				list.add(meta);
			}
		}
		return list;
	}
	/**
	 * 拿到规则对应的动作id
	 * 
	 * @param rule
	 * @return
	 * @author guolei
	 * @version 1.0
	 * @created 2013-4-19
	 */
	public String[] getActionIdOfRule(TRule rule){
		String actionStr = rule.getAction();
		String [] arr = actionStr.split("&&");
		if(arr == null || arr.length == 0 || StringKit.isEmpty(arr[0])){
			return new String[]{};
		}else{
			return arr;
		}
	}
	
	/**
	 * 添加场景对应的实体
	 * 
	 * @param ruleList
	 * @return
	 * @author guolei
	 * @version 1.0
	 * @created 2013-4-19
	 */
	public Set<String> getAllActionClass(List<TRule> ruleList){
		Set<String> set = new HashSet<String>();
		for(TRule rule : ruleList){
			List<TActionMeta> list = getActionMetaOfRule(rule);
			for(TActionMeta meta : list){
				set.add(meta.getMethodC());
			}
		}
		return set;
	}
	
	/**
	 * drools规则处理部分
	 * 
	 * @param droolRuleStr
	 * @param factMap
	 * @param ruleList
	 * @param entityList
	 * @throws RuleEngineException
	 * @author guolei
	 * @version 1.0
	 * @created 2013-4-22
	 */
	public List<Map<String,Object>> handleInDrools(StringBuffer droolRuleStr,Map<String,Object> factMap,List<TRule> ruleList,List<TEntity> entityList,String scene) throws RuleEngineException{
		StatefulKnowledgeSession session = null;
		try{
			session = DroolsUtil.getInstance().getDrlSession(droolRuleStr.toString(),scene);
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuleEngineException("Drools初始化失败，请检查Drools语句！");
		}
		//1.将fact中传入的对象inset到session
		for(TEntity entity : entityList){
			Object fact = factMap.get(entity.getIdentify());
			if(fact != null){
				session.insert(fact);
			}
		}
		return handleDroolsSession(session,factMap,ruleList,entityList,scene);
	}
	
	/**
	 * 将fact扔进session中处理，并返回结果
	 * 
	 * @param session
	 * @param factMap
	 * @param ruleList
	 * @param entityList
	 * @return
	 * @throws RuleEngineException
	 * @author guolei
	 * @version 1.0
	 * @created 2013-5-2
	 */
	public List<Map<String,Object>> handleDroolsSession(StatefulKnowledgeSession session,Map<String,Object> factMap,List<TRule> ruleList,List<TEntity> entityList,String scene) throws RuleEngineException {
		// 1.将fact中传入的对象inset到session
		for (TEntity entity : entityList) {
			Object fact = factMap.get(entity.getIdentify());
			if (fact != null) {
				session.insert(fact);
			}
		}
		// 2.将fact的map也插入到规则中
		session.insert(factMap);
		// 3.将返回结果的list也插入到规则中，用于结果返回
		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		session.setGlobal("$result", result);
		// 4.将规则涉及的所有动作实现类插入到规则中
		Set<String> set = null;
		if(ruleList == null){//表示从缓存中取
			set = factActionMap.get(scene);
		}else{
			set = getAllActionClass(ruleList);
			factActionMap.put(scene, set);
		}
		
		String clazzinfo = null;

		for (Iterator<String> it = set.iterator(); it.hasNext();) {
			try {
				clazzinfo = it.next();
				String springName = getSpringNameOfClazz(clazzinfo);
				IAction action = SpringContextHolder.getBean(springName);
				session.insert(action);
			} catch (Exception e) {
				log.error("解析规则动作对象时出错，请查看{}", clazzinfo);
				e.printStackTrace();
				throw new RuleEngineException("构造规则动作对象时出错，请检查！");
			}
		}
		// 5.触发
		session.fireAllRules();
		// 6.关闭
		session.dispose();
		return result;
	}
	/**
	 * 根据配置的class信息得到其在spring中的名字，如com.hxrainbow.ShowActionImpl会返回showAction。当然这些是采用约定优于配置
	 * 的原则，如果包含impl，则去掉impl，并将首字母小写，如果不包含Impl，直接将首字母小写
	 * 
	 * @param clazzName
	 * @return
	 * @author guolei
	 * @version 1.0
	 * @created 2013-4-22
	 */
	public String getSpringNameOfClazz(String clazzName){
		int index =  clazzName.lastIndexOf(".");
		String name =  clazzName.substring(index+1);
		if(name.endsWith("Impl")){
			name = name.replace("Impl", "");
			name =name.substring(0,1).toLowerCase() + name.substring(1);
			return name;
		}else{
			return clazzName.substring(0,1).toLowerCase() + clazzName.substring(1);
		}
	}
	/**
	 * 根据属性得到其get方法名
	 * 
	 * @param property
	 * @return
	 * @author guolei
	 * @version 1.0
	 * @created 2013-4-19
	 */
	public String getMethodByProperty(String property){
		if(StringKit.isNotEmpty(property)){
			property = property.substring(0,1).toUpperCase()+property.substring(1);
			return "get" + property;
		}
		return null;
	}
	
	public StringBuffer getDroolsInfo(TRule rule){
		StringBuffer sb = new StringBuffer();
		sb = insertRuleName(sb,rule);//插入名称
		sb = insertExpiryDate(sb,rule);//插入有效期信息
		sb = insertRuleCondition(sb, rule);//插入lhs
		sb = insertRuleAction(sb, rule);//插入rhs
		return sb;
	}
	
}
