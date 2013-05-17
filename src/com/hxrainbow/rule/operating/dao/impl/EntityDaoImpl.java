package com.hxrainbow.rule.operating.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Repository;

import com.hxrainbow.rule.model.TEntity;
import com.hxrainbow.rule.operating.dao.EntityDao;
import com.hxrainbow.rule.util.BasehibernateDaoSupport;

/**
 * 实体dao实现类
 * 
 * @author guolei
 * @version 1.0
 * @created 2013-4-9
 */
@Repository("entityDao")
public class EntityDaoImpl extends BasehibernateDaoSupport implements EntityDao {

	/**
	 * 保存实体
	 * 
	 * @param entity
	 * @return
	 * @author guolei
	 * @version 1.0
	 * @created 2013-4-9
	 */
	@Override
	public void saveEntity(TEntity entity){
		getHibernateTemplate().save(entity);
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
	public TEntity getEntityById(Integer id){
		return getHibernateTemplate().get(TEntity.class, id);
	}
	/**
	 * 根据标识查询实体
	 * 
	 * @param identify
	 * @author guolei
	 * @version 1.0
	 * @created 2013-4-9
	 */
	@SuppressWarnings("unchecked")
	public List<TEntity> getEntityByIdentify(String identify){
		String hql = "from TEntity where identify = ?";
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
	 * 删除实体
	 * 
	 * @param id
	 * @author guolei
	 * @version 1.0
	 * @created 2013-4-9
	 */
	@Override
	public void deleteEntity(final Integer id){
		final String hql = "delete TEntity where id = ?";
		getHibernateTemplate().execute(new HibernateCallback<Integer>() {
			@Override
			public Integer doInHibernate(Session session) throws HibernateException, SQLException {
				Query query = session.createQuery(hql);
				query.setInteger(0, id);
				return query.executeUpdate();
			}
		});
	}
	
}
