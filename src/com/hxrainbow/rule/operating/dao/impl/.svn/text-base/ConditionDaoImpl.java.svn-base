package com.hxrainbow.rule.operating.dao.impl;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Repository;

import com.hxrainbow.rule.model.TCondition;
import com.hxrainbow.rule.model.TEntity;
import com.hxrainbow.rule.model.TEntityItem;
import com.hxrainbow.rule.model.TScene;
import com.hxrainbow.rule.operating.dao.ConditionDao;
import com.hxrainbow.rule.util.BasehibernateDaoSupport;

/**
 * 场景dao实现类
 * 
 * @author guolei
 * @version 1.0
 * @created 2013-4-9
 */
@Repository("conditionDao")
public class ConditionDaoImpl extends BasehibernateDaoSupport implements ConditionDao {

	private static Logger log = LoggerFactory.getLogger(ConditionDaoImpl.class);
	
	/**
	 * 保存实体
	 * 
	 * @param scene 场景类
	 * @return
	 * @author guolei
	 * @version 1.0
	 * @created 2013-4-9
	 */
	@Override
	public Integer saveCondition(TCondition condition){
		condition.setDateEntered(new Date());
		condition.setDateModified(new Date());
		getHibernateTemplate().save(condition);
		return condition.getId();
	}
	/**
	 * 根据实体id查询实体
	 * 
	 * @param id
	 * @return
	 * @author guolei
	 * @version 1.0
	 * @created 2013-4-9
	 */
	@Override
	public TEntity getEntityById(Integer id){
		return getHibernateTemplate().get(TEntity.class, id);
	}
	/**
	 * 根据标识查询场景
	 * 
	 * @param identify
	 * @author guolei
	 * @version 1.0
	 * @created 2013-4-9
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<TEntity> getSceneByIdentify(String identify){
		String hql = "from TScene where identify = ?";
		return getHibernateTemplate().find(hql,identify);
	}
	/**
	 * 更新实体
	 * 
	 * @param entity
	 * @author guolei
	 * @version 1.0
	 * @created 2013-4-9
	 */
	public void updateEntity(TEntity entity){
		getHibernateTemplate().update(entity);
	}
	/**
	 * 删除场景
	 * 
	 * @param id
	 * @author guolei
	 * @version 1.0
	 * @created 2013-4-9
	 */
	@Override
	public void deleteScene(Integer id){
		
		TScene scene = new TScene();
		scene.setId(id);
		getHibernateTemplate().delete(scene);
	}
	/**
	 * 删除实体场景
	 * @param sceneId
	 */
	@Override
	public void deleteSceneEntity(final Integer sceneId){
		final String hql = "delete TSceneEntity where sceneId = ?";
		int count = getHibernateTemplate().execute(new HibernateCallback<Integer>() {
			@Override
			public Integer doInHibernate(Session session) throws HibernateException, SQLException {
				Query query = session.createQuery(hql);
				query.setInteger(0, sceneId);
				return query.executeUpdate();
			}
		});
		if(count == 0){
			throw new RuntimeException("未删除记录");
		}
	}
	/**
	 * 得到实体列表
	 * 
	 * @return
	 * @author guolei
	 * @version 1.0
	 * @created 2013-4-11
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<TEntity> getEntityList(){
		String hql = "from TEntity";
		return getHibernateTemplate().find(hql);
	}

	/**
	 * 根据itemName和typeId得到属性id
	 * 
	 * @param typeId
	 * @param itemName
	 * @return
	 * @author guolei
	 * @version 1.0
	 * @created 2013-4-15
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Integer getCondition(Integer typeId, String itemName){
		String hql = "from TEntityItem where typeId = ? and name = ?";
		List<TEntityItem> list = getHibernateTemplate().find(hql,new Object[]{typeId,itemName});
		if(list == null || list.size() == 0){
			return null;
		}else{
			return list.get(0).getId();
		}
	}
	/**
	 * 根据实体名称和实体属性
	 * 
	 * @param entityName
	 * @param itmeName
	 * @author guolei
	 * @version 1.0
	 * @created 2013-4-16
	 */
	@SuppressWarnings("unchecked")
	@Override
	public TEntityItem getItemByEntityAndItem(String entityName, String itemName){
		String hql = "select item from TEntity entity,TEntityItem item where item.typeId = entity.id and item.name = ? and entity.name = ?";
		List<TEntityItem> list = (List<TEntityItem>)getHibernateTemplate().find(hql,itemName,entityName);
		if(list == null || list.size() == 0){
			return null;
		}else {
			return list.get(0);
		}
	}
	
	/**
	 * 根据条件id查询条件
	 * 
	 * @param conditionId
	 * @return
	 * @author guolei
	 * @version 1.0
	 * @created 2013-4-16
	 */
	@Override
	public TCondition getConditionById(Integer conditionId){
		return getHibernateTemplate().get(TCondition.class, conditionId);
	}
	/**
	 * 根据实体条目id得到实体以及实体属性
	 * 
	 * @param entityItemId
	 * @return
	 * @author guolei
	 * @version 1.0
	 * @created 2013-4-18
	 */
	@SuppressWarnings("unchecked")
	public Object[] getItemAndEntityByItemId(Integer entityItemId){
		String hql = "select entity,item from TEntity entity,TEntityItem item where item.typeId = entity.id and item.id=?";
		List<Object[]> list = getHibernateTemplate().find(hql,entityItemId);
		if(list == null || list.size() == 0){
			log.error("解析条件时出错，无法根据实体属性找到相应的记录，实体属性id:{}",entityItemId);
			throw new RuntimeException("解析条件时出错，无法根据实体属性找到相应的记录");
		}
		return list.get(0);
	}
	
	/**
	 * 根据条件id删除条件
	 * 
	 * @param parseInt
	 * @author guolei
	 * @version 1.0
	 * @created 2013-4-19
	 */
	public void deleteCondition(int conditionId){
		TCondition condition = new TCondition();
		condition.setId(conditionId);
		getHibernateTemplate().delete(condition);
	}
}
