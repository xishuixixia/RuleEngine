package com.hxrainbow.rule.operating.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Repository;

import com.hxrainbow.rule.model.TEntityItem;
import com.hxrainbow.rule.operating.dao.EntityItemDao;
import com.hxrainbow.rule.util.BasehibernateDaoSupport;

@Repository("entityItemDao")
public class EntityItemDaoImpl extends BasehibernateDaoSupport implements EntityItemDao {
	/**
	 * 保存实体属性
	 */
	@Override
	public void saveEntityItem(TEntityItem entityItem) {
		getHibernateTemplate().save(entityItem);
	}

	/**
	 * 根据id查询实体属性
	 */
	@Override
	public TEntityItem getEntityItemById(Integer id) {
		return getHibernateTemplate().get(TEntityItem.class, id);
	}

	/**
	 * 根据实体id查询实体属性
	 */
	@SuppressWarnings("unchecked")
	public List<TEntityItem> getEntityItemByTypeId(Integer typeId) {
		String hql = "select i from TEntityItem i join i.entity t where t.id = ?";
		return getHibernateTemplate().find(hql, typeId);
	}

	/**
	 * 更新实体属性
	 */
	@Override
	public void updateEntityItem(TEntityItem entityItem) {
		getHibernateTemplate().update(entityItem);

	}

	@Override
	public void deleteEntityItem(final Integer id) {
		// TODO Auto-generated method stub
		final String hql = "delete TEntityItem where id = ?";
		getHibernateTemplate().execute(new HibernateCallback<Integer>() {
			@Override
			public Integer doInHibernate(Session session) throws HibernateException, SQLException {
				Query query = session.createQuery(hql);
				query.setInteger(0, id);
				return query.executeUpdate();
			}
		});
	}

	@Override
	public Long getEntityItemCount(final Integer typeId) {
		final String sql="select count(i) from TEntityItem i join i.entity e where e.id=?";
		long count=getHibernateTemplate().execute(new HibernateCallback<Long>() {
			@Override
			public Long doInHibernate(Session session) throws HibernateException, SQLException {
				Query query = session.createQuery(sql);
				query.setInteger(0, typeId);
				return (Long)query.iterate().next();
			}
		});
		return count;
	}

}
