package com.hxrainbow.rule.operating.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Repository;

import com.hxrainbow.rule.model.TEntity;
import com.hxrainbow.rule.model.TRule;
import com.hxrainbow.rule.model.TScene;
import com.hxrainbow.rule.model.TSceneEntity;
import com.hxrainbow.rule.operating.dao.SceneDao;
import com.hxrainbow.rule.util.BasehibernateDaoSupport;

/**
 * 场景dao实现类
 * 
 * @author guolei
 * @version 1.0
 * @created 2013-4-9
 */
@Repository("sceneDao")
public class SceneDaoImpl extends BasehibernateDaoSupport implements SceneDao {

	/**
	 * 保存场景信息
	 * 
	 * @param entity
	 * @return
	 * @author guolei
	 * @version 1.0
	 * @created 2013-4-9
	 */
	@Override
	public Integer saveScene(TScene scene){
		getHibernateTemplate().save(scene);
		return scene.getId();
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
	public TScene getSceneById(Integer id){
		return getHibernateTemplate().get(TScene.class, id);
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
	public void updateScene(TScene scene){
		getHibernateTemplate().update(scene);
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
	public void deleteScene(final Integer id){
		final String hql = "delete TScene where id = ?";
		int count = getHibernateTemplate().execute(new HibernateCallback<Integer>() {
			@Override
			public Integer doInHibernate(Session session) throws HibernateException, SQLException {
				Query query = session.createQuery(hql);
				query.setInteger(0, id);
				return query.executeUpdate();
			}
		});
		if(count == 0){
			throw new RuntimeException("未删除记录");
		}
	}
	/**
	 * 删除实体场景
	 * @param sceneId
	 */
	@Override
	public void deleteSceneEntity(final Integer sceneId,final Integer entityId){
		final String hql = "delete TSceneEntity where sceneId = ? and entityId = ?";
		int count = getHibernateTemplate().execute(new HibernateCallback<Integer>() {
			@Override
			public Integer doInHibernate(Session session) throws HibernateException, SQLException {
				Query query = session.createQuery(hql);
				query.setInteger(0, sceneId);
				query.setInteger(1, entityId);
				return query.executeUpdate();
			}
		});
		if(count == 0){
			throw new RuntimeException("未删除记录");
		}
	}
	
	/**
	 * 根据场景id删除场景的中间表信息
	 * 
	 * @param sceneId
	 * @author guolei
	 * @version 1.0
	 * @created 2013-4-19
	 */
	public void deleteSceneEntity(final Integer sceneId){
		final String hql = "delete TSceneEntity where sceneId = ?";
		getHibernateTemplate().execute(new HibernateCallback<Integer>() {
			@Override
			public Integer doInHibernate(Session session) throws HibernateException, SQLException {
				Query query = session.createQuery(hql);
				query.setInteger(0, sceneId);
				return query.executeUpdate();
			}
		});
	}
	/**
	 * 得到场景对应的实体
	 * 
	 * @param sceneId
	 * @return
	 * @author guolei
	 * @version 1.0
	 * @created 2013-4-15
	 */
	@SuppressWarnings("unchecked")
	public List<TEntity> getEntityOfScene(Integer sceneId){
		String hql = "select entity from TSceneEntity middle,TEntity entity where middle.entityId = entity.id and middle.sceneId = ?";	
		return getHibernateTemplate().find(hql,sceneId);
	}
	/**
	 * 保存场景实体
	 */
	@Override
	public void saveSceneEntity(Integer sceneId, Integer entityId) {
		TSceneEntity middle = new TSceneEntity();
		middle.setEntityId(entityId);
		middle.setSceneId(sceneId);
		getHibernateTemplate().save(middle);
		
	}
	/**
	 * 查询全部实体
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<TEntity> getEntity() {
		String hql = "from TEntity";	
		return getHibernateTemplate().find(hql);
	}
	/**
	 * 根据场景标识查询实体信息
	 * 
	 * @param scene
	 * @return
	 * @author guolei
	 * @version 1.0
	 * @created 2013-4-18
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<TEntity> getEntityOfSceneByIdentity(String sceneIdentity){
		String hql = "select distinct entity from TScene scene,TSceneEntity middle,TEntity entity where scene.id = middle.sceneId and entity.id = middle.entityId and scene.identify = ?";
		return getHibernateTemplate().find(hql,sceneIdentity);
	}
	
	/**
	 * 根据场景标识获取可用的规则信息
	 * 
	 * @param scene
	 * @return
	 * @author guolei
	 * @version 1.0
	 * @created 2013-4-18
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<TRule> getEnabledRuleBySceneIdentity(String sceneIdentity){
		//String hql = "select rule from TScene scene,TRule rule where rule.sceneId = scene.id and rule.enabled =1 and IFNULL(rule.begin,curdate())<=DATE_FORMAT(curdate(), '%Y-%m-%d') and IFNULL(rule.end,curdate())>=DATE_FORMAT(curdate(), '%Y-%m-%d') and scene.identify = ?";
		String hql = "select rule from TScene scene,TRule rule where rule.sceneId = scene.id and rule.enabled =1 and scene.identify = ?";
		return getHibernateTemplate().find(hql,sceneIdentity);
	}
	/**
	 * 查询场景实体中间表中的 个数根据sceneId，entityId
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<TSceneEntity> listEntityScene(Integer sceneId,Integer entityId){
		String hql = "select TS.id from TSceneEntity TS where TS.sceneId = ? and TS.entityId = ?";	
		return getHibernateTemplate().find(hql,sceneId,entityId);
	}
	
}
