package com.hxrainbow.rule.operating.dao.impl;

import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Repository;

import com.hxrainbow.rule.model.TAction;
import com.hxrainbow.rule.model.TActionMeta;
import com.hxrainbow.rule.model.TActionVariable;
import com.hxrainbow.rule.model.TEntity;
import com.hxrainbow.rule.model.TRule;
import com.hxrainbow.rule.model.TScene;
import com.hxrainbow.rule.operating.dao.RuleDao;
import com.hxrainbow.rule.util.BasehibernateDaoSupport;

@Repository("ruleDao")
public class RuleDaoImpl extends BasehibernateDaoSupport implements RuleDao {

	private static Logger log = LoggerFactory.getLogger(RuleDaoImpl.class);
	
	/**
	 * 保存动作
	 * 
	 * @param rule
	 * @author guolei
	 * @version 1.0
	 * @created 2013-4-16
	 */
	@Override
	public Integer saveRule(TRule rule){
		
		rule.setDateEntered(new Date());
		rule.setDateModified(new Date());
		getHibernateTemplate().save(rule);
		return rule.getId();
	}
	/**
	 * 保存动作对象
	 * 
	 * @param actionObj 动作对象
	 * @return
	 * @author guolei
	 * @version 1.0
	 * @created 2013-4-16
	 */
	@Override
	public Integer saveAction(TAction actionObj){
		actionObj.setDateEntered(new Date());
		actionObj.setDateModified(new Date());
		getHibernateTemplate().save(actionObj);
		return actionObj.getId();
	}
	/**
	 * 根据itemId查询item信息
	 * 
	 * @param itemId
	 * @author guolei
	 * @version 1.0
	 * @created 2013-4-16
	 */
	@SuppressWarnings("unchecked")
	@Override
	public HashMap<String, String> getItemInfoById(Integer itemId){
		String hql = "select new map(entity.name as entityName,item.name as itemName) from TEntity entity,TEntityItem item where item.typeId = entity.id and item.id = ?";
		List<HashMap<String,String>> list = getHibernateTemplate().find(hql,itemId);
		if(list == null || list.size() == 0){
			log.error("根据实体属性id无法查询对应实体和实体属性，属性id为{}",itemId);
			return null;
		}else{
			return list.get(0);
		}
	}
	/**
	 * 根据actionId查询action信息
	 * 
	 * @param actionId
	 * @author guolei
	 * @version 1.0
	 * @created 2013-4-16
	 */
	@Override
	public TAction getActionById(Integer actionId){
		return getHibernateTemplate().get(TAction.class, actionId);
	}
	/**
	 * 根据actiontypeId查询action类型信息
	 * 
	 * @param actionId
	 * @author guolei
	 * @version 1.0
	 * @created 2013-4-16
	 */
	@Override
	public TActionMeta getActionMetaById(Integer typeId){
		return getHibernateTemplate().get(TActionMeta.class, typeId);
	}
	
	/**
	 * 根据规则id得到规则对象
	 * 
	 * @param ruleId
	 * @return
	 * @author guolei
	 * @version 1.0
	 * @created 2013-4-16
	 */
	@Override
	public TRule getRuleById(Integer ruleId){
		return getHibernateTemplate().get(TRule.class, ruleId);
	}
	
	/**
	 * 删除规则
	 * 
	 * @param id
	 * @author guolei
	 * @version 1.0
	 * @created 2013-4-17
	 */
	public void deleteRule(TRule rule){
		getHibernateTemplate().delete(rule);
	}
	
	/**
	 * 根据规则主键更新规则enabled状态
	 * 
	 * @param id
	 * @param enabled
	 * @author guolei
	 * @version 1.0
	 * @created 2013-4-18
	 */
	public void updateEnabledRule(final Integer id,final  Integer enabled){
		final String hql = "update TRule set enabled = ? where id = ?";
		getHibernateTemplate().execute(new HibernateCallback<Integer>() {
			@Override
			public Integer doInHibernate(Session session) throws HibernateException, SQLException {
				Query query = session.createQuery(hql);
				query.setInteger(0, enabled);
				query.setInteger(1, id);
				return query.executeUpdate();
			}
		});
	}
	
	/**
	 * 根据动作id删除动作
	 * 
	 * @param actionId
	 * @author guolei
	 * @version 1.0
	 * @created 2013-4-19
	 */
	public void deleteActionByActionId(int actionId){
		TAction action = new TAction();
		action.setId(actionId);
		getHibernateTemplate().delete(action);
	}
	/**
	 * 根据规则id删除规则
	 * 
	 * @param id
	 * @author guolei
	 * @version 1.0
	 * @created 2013-4-17
	 */
	public void deleteRuleById(Integer id){
		TRule rule  = new TRule();
		rule.setId(id);
		getHibernateTemplate().delete(rule);
	}
	/**
	 * 保存动作与变量表的中间关联
	 * 
	 * @param variable
	 * @author guolei
	 * @version 1.0
	 * @created 2013-4-24
	 */
	public void saveActionVariable(TActionVariable variable){
		getHibernateTemplate().save(variable);
	}
	
	/**
	 * 根据meta主键查找TActionMetaVariable中符合的item
	 * 
	 * @param metaId
	 * @return
	 * @author guolei
	 * @version 1.0
	 * @created 2013-4-24
	 */
	@SuppressWarnings("unchecked")
	public List<Object[]> getActionVariableList(Integer metaId,Integer actionId){
		String hql = "from TActionMetaVariable variable,TActionVariable middle where middle.actionId = ? and middle.variableId = variable.id and variable.actionMetaId = ?";
		return getHibernateTemplate().find(hql,new Object[]{actionId,metaId});
	}
	/**
	 * 根据actionid查询对应的条件类型
	 * 
	 * @param actionId
	 * @return
	 * @author guolei
	 * @version 1.0
	 * @created 2013-4-24
	 */
	public TActionMeta getActionMetaByActionId(Integer actionId){
		String hql = "select meta from TActionMeta meta,TAction action where action.typeId = meta.id and action.id = ?";
		return (TActionMeta)getHibernateTemplate().find(hql,new Object[]{actionId}).get(0);
	}
	/**
	 * 根据场景id得到场景对应的实体信息
	 * 
	 * @param sceneId
	 * @author guolei
	 * @version 1.0
	 * @created 2013-5-8
	 */
	@SuppressWarnings("unchecked")
	public List<TEntity> getEntityOfSceneById(Integer sceneId){
		String hql = "select distinct entity from TScene scene,TSceneEntity middle,TEntity entity where scene.id = middle.sceneId and entity.id = middle.entityId and scene.id = ?";
		return getHibernateTemplate().find(hql,sceneId);
	}
	/**
	 * 根据场景id得到场景信息
	 * 
	 * @param sceneId
	 * @author guolei
	 * @version 1.0
	 * @created 2013-5-8
	 */
	@Override
	public TScene getSceneById(Integer sceneId) {
		return 	getHibernateTemplate().get(TScene.class, sceneId);
	}
}
