package com.hxrainbow.rule.operating.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Repository;

import com.hxrainbow.rule.model.TActionMeta;
import com.hxrainbow.rule.model.TActionMetaVariable;
import com.hxrainbow.rule.operating.dao.ActionMetaDao;
import com.hxrainbow.rule.util.BasehibernateDaoSupport;

@Repository("actionMetaDao")
public class ActionMetaDaoImpl extends BasehibernateDaoSupport implements ActionMetaDao{
	
	private static Logger log = LoggerFactory.getLogger(ActionMetaDaoImpl.class);
    /**
     * 保存动作类型
     */
	@Override
	public Integer saveActionMeta(TActionMeta actionMeta) {
		getHibernateTemplate().save(actionMeta);
		return actionMeta.getId();
	}
    /**
     * 根据id查询动作类型
     */
	@Override
	public TActionMeta getActionMetaById(Integer id) {
		String hql = "from TActionMeta where  id = ?";
		return (TActionMeta)getHibernateTemplate().find(hql,id).get(0);
	}
    
	@Override
	public void updateActionMeta(TActionMeta actionMeta) {
		getHibernateTemplate().update(actionMeta);		
	}
    /**
     * 根据id查询动作类型
     */
	@Override
	public void deleteActionMeta(final Integer id) {
		final String hql = "delete TActionMeta where id = ?";
		getHibernateTemplate().execute(new HibernateCallback<Integer>() {
			@Override
			public Integer doInHibernate(Session session) throws HibernateException, SQLException {
				Query query = session.createQuery(hql);
				query.setInteger(0, id);
				return query.executeUpdate();
			}
		});
	}
	/**
	 * 删除动作类型变量
	 * 
	 * @param id
	 * @author guolei
	 * @version 1.0
	 * @created 2013-4-23
	 */
	public void deleteActionMetaVariable(final Integer id){
		final String hql = "delete TActionMetaVariable where actionMetaId = ?";
		getHibernateTemplate().execute(new HibernateCallback<Integer>() {
			@Override
			public Integer doInHibernate(Session session) throws HibernateException, SQLException {
				Query query = session.createQuery(hql);
				query.setInteger(0, id);
				return query.executeUpdate();
			}
		});
	}
	/**
	 * 根据actionid查询动作以及动作元对象
	 * 
	 * @param actionId
	 * @return
	 * @author guolei
	 * @version 1.0
	 * @created 2013-4-18
	 */
	@SuppressWarnings("unchecked")
	public Object[] getActionAndMetaById(Integer actionId){
		
		String hql = "select action,meta from TAction action,TActionMeta meta where action.typeId = meta.id and action.id = ?";
		List<Object[]> list = getHibernateTemplate().find(hql,actionId);
		if(list == null || list.size() == 0){
			log.error("解析条件出错，根据动作id无法查询动作信息,动作id：{}",actionId);
			throw new RuntimeException("解析条件出错，根据动作id无法查询动作信息");
		}
		return list.get(0);
	}
	
	/**
	 * 添加动作类型变量
	 * 
	 * @param name
	 * @param identify
	 * @author guolei
	 * @version 1.0
	 * @created 2013-4-23
	 */
	public void saveActionMetaVariable(TActionMetaVariable variable){
		getHibernateTemplate().save(variable);
	}
	/**
	 * 查看动作类型变量
	 * 
	 * @param id
	 * @return
	 * @author guolei
	 * @version 1.0
	 * @created 2013-4-23
	 */
	@SuppressWarnings("unchecked")
	public List<TActionMetaVariable> getActionMetaVariableById(Integer id){
		String hql = "from TActionMetaVariable where actionMetaId = ?";
		return getHibernateTemplate().find(hql,id);
	}
}
  

