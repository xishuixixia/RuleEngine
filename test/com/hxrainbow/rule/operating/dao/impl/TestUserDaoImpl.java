package com.hxrainbow.rule.operating.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Repository;

import com.hxrainbow.rule.model.TestLog;
import com.hxrainbow.rule.model.TestUser;
import com.hxrainbow.rule.operating.dao.TestUserDao;
import com.hxrainbow.rule.util.BasehibernateDaoSupport;
@Repository("testUserDao")
public class TestUserDaoImpl extends BasehibernateDaoSupport implements TestUserDao{

	
	@SuppressWarnings("unchecked")
	@Override
	public List<TestUser> User() {
		String hql = "from TestUser";	
		return getHibernateTemplate().find(hql);
	}
	
	@Override
	public Integer saveUser(TestUser user){
		getHibernateTemplate().save(user);
		return user.getId();
	}
	@Override
	public List getUserByUsername(String username){
		String hql = "from TestUser where name = ?";
		return getHibernateTemplate().find(hql,username);
	}
	@SuppressWarnings("unchecked")
	public List<TestUser> getPointByUser(String userName){
		String hql = "from TestUser where name = ?";
		return getHibernateTemplate().find(hql,userName);
	}

	@Override
	public void update(final Integer point,final Integer id)  {			
		final String hql= " update TestUser t set t.point =t.point + ? where t.id =?";		
		getHibernateTemplate().execute(new HibernateCallback<Integer>() {
			@Override
			public Integer doInHibernate(Session session) throws HibernateException, SQLException {
				Query query = session.createQuery(hql);	
				query.setInteger(0, point);
				query.setInteger(1,id);
				return query.executeUpdate();
			}
		});
	}
	
	public void savePointLog(TestLog log){
		getHibernateTemplate().save(log);
	}

	@Override
	public List<TestLog> getLogList(final Integer userId) {
		final String hql = "from TestLog where userId = ? order by createDate desc";
		List list=getHibernateTemplate().executeFind(new HibernateCallback() {
			@Override
			public Object doInHibernate(Session session) throws HibernateException,
					SQLException {
				Query query=session.createQuery(hql);
				query.setInteger(0, userId);
				query.setFirstResult(0);
				query.setMaxResults(10);
				return query.list();
			}
		});
		return list;
	}
}
