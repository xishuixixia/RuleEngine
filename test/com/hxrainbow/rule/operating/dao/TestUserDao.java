package com.hxrainbow.rule.operating.dao;

import java.util.List;

import com.hxrainbow.rule.model.TestLog;
import com.hxrainbow.rule.model.TestUser;

public interface TestUserDao {
	public List<TestUser> User();
	public Integer saveUser(TestUser user);
	public List getUserByUsername(String username); 
	public List<TestUser> getPointByUser(String userName);
	public void update(Integer point,Integer userName);
	public void savePointLog(TestLog log);
	public List<TestLog> getLogList(Integer userId);
}
