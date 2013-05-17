package com.hxrainbow.rule.operating.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.drools.compiler.DroolsParserException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hxrainbow.rule.model.TAction;
import com.hxrainbow.rule.model.TActionMeta;
import com.hxrainbow.rule.model.TActionMetaVariable;
import com.hxrainbow.rule.model.TActionVariable;
import com.hxrainbow.rule.model.TCondition;
import com.hxrainbow.rule.model.TEntity;
import com.hxrainbow.rule.model.TEntityItem;
import com.hxrainbow.rule.model.TRule;
import com.hxrainbow.rule.model.TScene;
import com.hxrainbow.rule.model.TVariable;
import com.hxrainbow.rule.operating.dao.ConditionDao;
import com.hxrainbow.rule.operating.dao.RuleDao;
import com.hxrainbow.rule.operating.service.RuleService;
import com.hxrainbow.rule.util.BasePage;
import com.hxrainbow.rule.util.DroolsUtil;
import com.hxrainbow.rule.util.RuleEngineException;
import com.hxrainbow.rule.util.StringKit;


@Service("ruleService")
@Transactional
public class RuleServiceImpl implements RuleService {

	@Resource
	private RuleDao ruleDao;
	@Resource
	private ConditionDao conditionDao;
	
	private static Logger log = LoggerFactory.getLogger(RuleServiceImpl.class);

	@Override
	public List<TVariable> listVariable(String variableName, Integer type) {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * 添加规则接口，包括初始化条件和动作
	 * 
	 * @param rule
	 * @author guolei
	 * @version 1.0
	 * @throws RuleEngineException 
	 * @created 2013-4-16
	 */
	@Override
	public int addRule(TRule rule,List<String> actionList){
		
		String conditionInfo = rule.getCondition();
		if(StringKit.isNotEmpty(conditionInfo)){
			TCondition condition = new TCondition();
			condition.setDescription(rule.getCondition());
			//实体属性处理
			conditionInfo = replaceParam(conditionInfo);
			//动态参数处理 -- 暂不做处理
			condition.setCondition(conditionInfo);//设置实体条件信息
			Integer conditionId = conditionDao.saveCondition(condition);
			rule.setCondition(conditionId.toString());
		}
		
		//动作处理
		StringBuffer actionIds = new StringBuffer("");
		if(actionList == null){actionList = new ArrayList<String>();}
		for(String action : actionList){
			String[] arr = action.split("##");
			TAction actionObj = new TAction();
			actionObj.setTypeId(Integer.parseInt(arr[0]));//动作类型id
			Integer actionId = ruleDao.saveAction(actionObj);//保存动作
			
			for(int i = 1;i < arr.length; i++){
				String[] middleItem = arr[i].split(",");
				TActionVariable variable = new TActionVariable();
				variable.setActionId(actionId);
				variable.setVariableId(Integer.parseInt(middleItem[0]));
				
				if(middleItem[1].contains("$") && middleItem[1].contains("的")){
					variable.setVariableValue(replaceParam(middleItem[1]));
				}else{
					variable.setVariableValue(replaceParam(middleItem[1]));
				}
				
				ruleDao.saveActionVariable(variable);
			}
			
			if(!actionIds.toString().equals("")){
				actionIds.append("&&" + actionId);
			}else{
				actionIds.append(actionId);
			}
		}
		rule.setAction(actionIds.toString());
		ruleDao.saveRule(rule);
		int status =  testRuleCondition(rule);
		if(status != 2){
			throw new RuntimeException("添加规则失败，规则条件表达式部正确。");
		}
		//清除缓存
		clearCache(rule.getSceneId());
		return status;
	}
	
	private void clearCache(Integer sceneId) {

		TScene scene = ruleDao.getSceneById(sceneId);
		DroolsUtil.removeRuleMap(scene.getIdentify());
	}

	/**
	 * 根据场景id、场景名称、是否启用查询规则
	 * 
	 * @param sceneId
	 * @param name
	 * @param enabled
	 * @return
	 * @author guolei
	 * @version 1.0
	 * @created 2013-4-16
	 */
	@SuppressWarnings("unchecked")
	@Transactional(propagation=Propagation.NOT_SUPPORTED,readOnly=true)
	public BasePage listPageRule(BasePage basePage,Integer sceneId, String name, Integer enabled){
		
		StringBuffer hql = new StringBuffer("from TRule where sceneId = " + sceneId);
		if(StringKit.isNotEmpty(name)){
			hql.append(" and name like '%" + name +"%'");
		}
		if(enabled != null && enabled != 0){
			hql.append(" and enabled = " + enabled);
		}
		List<TRule> ruleList = ruleDao.findPageDataByHql(basePage.getPage(), basePage.getPageSize(), hql.toString());
		
		basePage.setList(ruleList);
		basePage.setRecordNum(ruleDao.findTotalCount(hql.insert(0, "select count(*) ").toString()).intValue());
		
		for(TRule rule : ruleList){
			String conditionId = rule.getCondition();
			
			//有条件
			if(StringKit.isNotEmpty(conditionId)){
				TCondition conditionObj = conditionDao.getConditionById(Integer.parseInt(conditionId));
				String condition = conditionObj.getCondition();
				condition = replaceParamToShow(condition);
				rule.setCondition(condition);
			}else{
				rule.setCondition("");
			}
			
			String action = rule.getAction();
			String[] arr = action.split("&&");
			StringBuffer actionShow = new StringBuffer();
			if(arr.length == 1 && StringKit.isEmpty(arr[0])){
				rule.setAction("");
				continue;
			}
			for(String actionId : arr){
				TAction actionObj = ruleDao.getActionById(Integer.parseInt(actionId));
				TActionMeta actionMeta = ruleDao.getActionMetaById(actionObj.getTypeId());
				actionShow.append(actionMeta.getName());
				
				List<Object[]> variableList = ruleDao.getActionVariableList(actionMeta.getId(),Integer.parseInt(actionId));
				for(Object[] temp : variableList){
					TActionMetaVariable variable = (TActionMetaVariable)temp[0];
					TActionVariable middle = (TActionVariable)temp[1];
					
					actionShow.append("[");
					actionShow.append(variable.getName());
					actionShow.append(":");
					if(middle.getVariableValue().contains("$")){
						actionShow.append(replaceParamToShow(middle.getVariableValue()));
					}else{
						actionShow.append(middle.getVariableValue());
					}
					
					actionShow.append("]");
				}
				actionShow.append("<br/>");
			}
			rule.setAction(actionShow.toString());
		}
		return basePage;
	}
	
	/**
	 * 根据规则id查找规则信息
	 * 
	 * @param id
	 * @return
	 * @author guolei
	 * @version 1.0
	 * @created 2013-4-16
	 */
	@Transactional(propagation=Propagation.NOT_SUPPORTED,readOnly=true)
	public TRule getRuleById(Integer ruleId){
		TRule rule = ruleDao.getRuleById(ruleId);
		String conditionId = rule.getCondition();
		if(StringKit.isNotEmpty(conditionId)){
			TCondition conditionObj = conditionDao.getConditionById(Integer.parseInt(conditionId));
			String condition = conditionObj.getCondition();
			condition = replaceParamToShow(condition);
			rule.setCondition(condition);
		}
		
		return rule;
	}
	
	/**
	 * 根据规则中的action描述信息，组合出一个可用的map，来在前端显示规则
	 * 
	 * @param action
	 * @return
	 * @author guolei
	 * @version 1.0
	 * @created 2013-4-16
	 */
	@Transactional(propagation=Propagation.NOT_SUPPORTED,readOnly=true)
	public HashMap<String, String> getActionInfo(String action){
		
		String[] arr = action.split("&&");
		HashMap<String, String> map = new HashMap<String, String>();
		if(arr.length == 1 && StringKit.isEmpty(arr[0])){
			return map;
		}
		for(String actionId : arr){
			TAction actionObj = ruleDao.getActionById(Integer.parseInt(actionId));
			TActionMeta actionMeta = ruleDao.getActionMetaById(actionObj.getTypeId());
			StringBuffer actionShow = new StringBuffer();
			StringBuffer actionHidden = new StringBuffer();
			
			actionShow.append(actionMeta.getName());
			actionHidden.append(actionMeta.getId());
			
			List<Object[]> variableList = ruleDao.getActionVariableList(actionMeta.getId(),Integer.parseInt(actionId));
			for(Object[] temp : variableList){
				TActionMetaVariable variable = (TActionMetaVariable)temp[0];
				TActionVariable middle = (TActionVariable)temp[1];
				
				actionShow.append("[");
				actionShow.append(variable.getName());
				actionShow.append(":");
				
				actionHidden.append("##");
				actionHidden.append(variable.getId());
				actionHidden.append(",");
				
				if(middle.getVariableValue().contains("$")){
					actionHidden.append(replaceParamToShow(middle.getVariableValue()));
					actionShow.append(replaceParamToShow(middle.getVariableValue()));
				}else{
					actionShow.append(middle.getVariableValue());
					actionHidden.append(middle.getVariableValue());
				}
				
				actionShow.append("]");
			}
			map.put(actionShow.toString(), actionHidden.toString());
		}
		return map;
	}
	
	/**
	 * 替换条件或者动作中的"会员的名称"为相应id
	 * 
	 * @param conditionInfo
	 * @return
	 * @author guolei
	 * @version 1.0
	 * @created 2013-4-17
	 */
	public String replaceParam(String conditionInfo){
		List<String> itemList = StringKit.getParamId(conditionInfo);
		for(String item : itemList){
			String itemTemp = item.replaceFirst("的", "=");
			String[] arr = itemTemp.split("=");
			if(arr.length != 2){
				log.error("分拆条件时出错,具体出错方位为：解析实体属性{}",item);
				return null;
			}
			TEntityItem itemObj = conditionDao.getItemByEntityAndItem(arr[0],arr[1]);
			conditionInfo = conditionInfo.replace(item,itemObj.getId()+"");
		}
		return conditionInfo;
	}
	
	/**
	 * 根据变量替换条件，比如将$11123fda$替换为 会员的名称
	 * 
	 * @param condition
	 * @return
	 * @author guolei
	 * @version 1.0
	 * @created 2013-4-17
	 */
	public String replaceParamToShow(String condition){
		List<String> itemList = StringKit.getParamId(condition);
		for(String itemId : itemList){
			HashMap<String, String> map = ruleDao.getItemInfoById(Integer.parseInt(itemId));
			String entityName = map.get("entityName");
			String itemName = map.get("itemName");
			condition = condition.replace(itemId, entityName + "的" + itemName);
		}
		return condition;
	}
	
	/**
	 * 修改规则
	 * 
	 * @param rule
	 * @author guolei
	 * @version 1.0
	 * @created 2013-4-17
	 */
	public Integer updateRule(TRule rule,List<String> actionList){
		ruleDao.deleteRuleById(rule.getId());
		
		String conditionInfo = rule.getCondition();
		TCondition condition = new TCondition();
		condition.setDescription(rule.getCondition());
		//实体属性处理
		conditionInfo = replaceParam(conditionInfo);
		//动态参数处理 -- 暂不做处理
		condition.setCondition(conditionInfo);//设置实体条件信息
		Integer conditionId = conditionDao.saveCondition(condition);
		rule.setCondition(conditionId.toString());
		
		if(actionList == null || actionList.size() == 0 || StringKit.isEmpty(actionList.get(0))){
			rule.setAction("");
		}else{
			//动作处理
			StringBuffer actionIds = new StringBuffer("");
			for(String action : actionList){
				String[] arr = action.split("##");
				TAction actionObj = new TAction();
				actionObj.setTypeId(Integer.parseInt(arr[0]));//动作类型id
				Integer actionId = ruleDao.saveAction(actionObj);//保存动作
				
				for(int i = 1;i < arr.length; i++){
					String[] middleItem = arr[i].split(",");
					TActionVariable variable = new TActionVariable();
					variable.setActionId(actionId);
					variable.setVariableId(Integer.parseInt(middleItem[0]));
					
					if(middleItem[1].contains("$") && middleItem[1].contains("的")){
						variable.setVariableValue(replaceParam(middleItem[1]));
					}else{
						variable.setVariableValue(replaceParam(middleItem[1]));
					}
					
					ruleDao.saveActionVariable(variable);
				}
				
				if(!actionIds.toString().equals("")){
					actionIds.append("&&" + actionId);
				}else{
					actionIds.append(actionId);
				}
			}
			rule.setAction(actionIds.toString());
		}
		
		rule.setDateModified(new Date());
		Integer id = ruleDao.saveRule(rule);
		
		//清除缓存
		clearCache(rule.getSceneId());
		return id;
	}
	
	/**
	 * 根据规则id删除规则
	 * 
	 * @param ruleId
	 * @author guolei
	 * @version 1.0
	 * @created 2013-4-17
	 */
	@Override
	public void deleteRule(Integer ruleId){
		TRule rule = ruleDao.getRuleById(ruleId);
		//删除条件
		String conditionIdStr = rule.getCondition();
		conditionDao.deleteCondition(Integer.parseInt(conditionIdStr));
		//删除动作
		String actionIdStr = rule.getAction();
		if(StringKit.isNotEmpty(actionIdStr)){
			String[] arr = actionIdStr.split("&&");
			for(String actionId : arr){
				if(StringKit.isNotEmpty(actionId)){
					ruleDao.deleteActionByActionId(Integer.parseInt(actionId));
				}
			}
		}
		ruleDao.deleteRule(rule);
		
		//清除缓存
		clearCache(rule.getSceneId());
	}
	
	/**
	 * 更新规则状态
	 * 
	 * @param rule
	 * @author guolei
	 * @version 1.0
	 * @created 2013-4-18
	 */
	@Override
	public void updateEnabledRule(TRule rule){
		ruleDao.updateEnabledRule(rule.getId(),rule.getEnabled());
	}
	/**
	 * 测试规则条件
	 * 
	 * @param droolRuleStr
	 * @param rule
	 * @return
	 * @author guolei
	 * @version 1.0
	 * @created 2013-5-8
	 */
	public Integer testRuleCondition(TRule rule){
		
		StringBuffer droolRuleStr = new StringBuffer();
		droolRuleStr.append("package com.hxrainbow.ruleEngine.test;").append("\n");
		List<TEntity> entityList = ruleDao.getEntityOfSceneById(rule.getSceneId());
		for(TEntity entity : entityList){
			droolRuleStr.append("import").append("  ").append(entity.getPackageC()).append(";").append("\n");
		}
		//导入基本类
		droolRuleStr.append("import").append("  ").append("java.lang.String").append(";").append("\n");
		droolRuleStr.append("rule test").append("\n");
		droolRuleStr.append("when").append("\n");
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
				if(conditionVariable.equals("")){
					return 0;
				}
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
		droolRuleStr.append("then").append("\n");
		droolRuleStr.append("end");
		System.out.println(droolRuleStr);
		int result = 2;
		try {
			result =  DroolsUtil.getInstance().compileRule(droolRuleStr.toString());
		} catch (DroolsParserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
}
