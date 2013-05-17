package com.hxrainbow.rule.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hxrainbow.Member;
import com.hxrainbow.rule.model.TestUser;
import com.hxrainbow.rule.operating.dao.TestUserDao;
import com.hxrainbow.rule.operating.service.IAction;

@Service("pointAction")
public class PointActionImpl implements IAction {
	@Resource
	private TestUserDao testUserDao;	
	private TestUser user;
	
	@Override
	public void execute(Map<String, Object> map,List<Map<String,Object>> resultList) {
		//System.out.println("赠送积分个数：" + map.get("point"));
		Member member = (Member)map.get("member");
	
		if(map.get("id") == null){
			testUserDao.update(Integer.parseInt(map.get("point").toString()), member.getId());		
		}else{
			testUserDao.update(Integer.parseInt(map.get("point").toString()), (Integer)map.get("id"));	
		}
		HashMap<String, Object> result = new HashMap<String, Object>();
		result.put("point", Integer.parseInt(map.get("point").toString()));
		result.put("description", map.get("ruleName"));
		resultList.add(result);
	}
	
	public TestUser getUser() {
		return user;
	}
	public void setUser(TestUser user) {
		this.user = user;
	}
}
