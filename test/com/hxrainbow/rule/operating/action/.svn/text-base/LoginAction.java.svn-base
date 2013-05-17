package com.hxrainbow.rule.operating.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.caucho.hessian.client.HessianProxyFactory;
import com.hxrainbow.Member;
import com.hxrainbow.rule.model.TestLog;
import com.hxrainbow.rule.model.TestUser;
import com.hxrainbow.rule.operating.service.IRuleEngine;
import com.hxrainbow.rule.operating.service.TestUserService;


@Controller
@Scope("prototype")
public class LoginAction extends BaseAction{
	
	private static final long serialVersionUID = 1L;
	@Resource
	private TestUserService testUserService;
	
	private String userName;
	private Integer num;
	private TestUser user;
	private Member member;	
	
	private String yaoqingName;
	
	private List<TestLog> list ;	
	/**
	 * 登录场景
	 * 
	 * @return
	 * @throws Exception
	 * @author guolei
	 * @version 1.0
	 * @created 2013-4-25
	 */
	public String loginTest() throws Exception{			
		
		user = testUserService.getPointByUser(userName);				
		HessianProxyFactory factory = new HessianProxyFactory();
		String url = "http://127.0.0.1:8080/RuleEngine/remoting/iRuleEngine.hessian";	
		IRuleEngine  iRuleEngine = (IRuleEngine) factory.create(IRuleEngine.class, url);
		//iRuleEngine.executeRuleEngine(factMap, scene);
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		member = new Member();
		member.setId(user.getId());
		member.setUsername(userName);
		member.setLoginNum(num);
		map.put("member", member);		
		List<Map<String,Object>> resultList = iRuleEngine.executeRuleEngine(map, "login");	
		
		for(Map<String,Object> result :resultList){
			TestLog log = new TestLog();
			log.setPoint(Integer.parseInt(result.get("point").toString()));
			log.setReason("连续登录"+member.getLoginNum()+"次，调用规则："+result.get("description").toString());
			log.setUserId(user.getId());
			testUserService.logRulePoint(log);
		}
		
		return "user";
	}
	/**
	 * 登录场景页面
	 * 
	 * @return
	 * @throws Exception
	 * @author guolei
	 * @version 1.0
	 * @created 2013-4-24
	 */
	public String testIndex() throws Exception{				
		user = testUserService.getPointByUser(userName);		
		list = testUserService.getLogList(user.getId());
		return "index";
	}
	/**
	 *
	 * 
	 * @return
	 * @throws Exception
	 * @author guolei
	 * @version 1.0
	 * @created 2013-4-25
	 */
	public String testUser() throws Exception{
		user = testUserService.getPointByUser(userName);
		list = testUserService.getLogList(user.getId());
		return "user";
	}
	/**
	 * 答题场景页面
	 * 
	 * @return
	 * @throws Exception
	 * @author guolei
	 * @version 1.0
	 * @created 2013-4-24
	 */
	public String testAnswer() throws Exception{
		user =testUserService.getPointByUser(userName);
		return "answer";
	}
	public String userTest() throws Exception{
		user =testUserService.getPointByUser(userName);
		return "user";
	}
	/**
	 * 答对题目的aciton
	 * 
	 * @return
	 * @throws Exception
	 * @author guolei
	 * @version 1.0
	 * @created 2013-4-24
	 */
	public String rightTest() throws Exception{		
		
		user = testUserService.getPointByUser(member.getUsername());
		if(user != null){
			HessianProxyFactory factory = new HessianProxyFactory();
			String url = "http://127.0.0.1:8080/RuleEngine/remoting/iRuleEngine.hessian";	
			IRuleEngine  iRuleEngine = (IRuleEngine) factory.create(IRuleEngine.class, url);
			
			HashMap<String, Object> map = new HashMap<String, Object>();
			member.setId(user.getId());
			map.put("member", member);		
			List<Map<String,Object>> resultList = iRuleEngine.executeRuleEngine(map, "question");
			
			for(Map<String,Object> result :resultList){
				TestLog log = new TestLog();
				log.setPoint(Integer.parseInt(result.get("point").toString()));
				log.setReason("答题数量:"+member.getQuestion()+",答对:"+member.getAnswerRight()+"，调用规则："+result.get("description").toString());
				log.setUserId(user.getId());
				testUserService.logRulePoint(log);
			}
		}		
		userName = member.getUsername();
		
		
		
		
		return "user";		
	}
	
	/**
	 * 注册action
	 * 
	 * @return
	 * @throws Exception
	 * @author guolei
	 * @version 1.0
	 * @created 2013-4-23
	 */
	public String registerTest() throws Exception{	
		TestUser user = new TestUser();
		if(!testUserService.getUserByUsername(member.getUsername())){
			System.out.println("已存在该用户");
			return "index";
		}
		user.setName(member.getUsername());
		user.setPoint(0);
		Integer id = testUserService.saveUser(user);
		member.setId(id);
		
		HessianProxyFactory factory = new HessianProxyFactory();
		String url = "http://127.0.0.1:8080/RuleEngine/remoting/iRuleEngine.hessian";	
		IRuleEngine  iRuleEngine = (IRuleEngine) factory.create(IRuleEngine.class, url);
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		Integer yaoqingId = 0;
		if(member.getIsInvite() == 1){//是邀请注册
			yaoqingId = testUserService.getPointByUser(yaoqingName).getId();
			map.put("id",yaoqingId);
		}
		map.put("member", member);
		List<Map<String,Object>> resultList = iRuleEngine.executeRuleEngine(map, "register");
		
		
		
		if(member.getIsInvite() == 1){//是邀请注册
			for(Map<String,Object> result :resultList){
				TestLog log = new TestLog();
				log.setPoint(Integer.parseInt(result.get("point").toString()));
				log.setReason("邀请用户注册送积分");
				log.setUserId(yaoqingId);
				testUserService.logRulePoint(log);
			}
		}
		
		for(Map<String,Object> result :resultList){
			TestLog log = new TestLog();
			log.setPoint(Integer.parseInt(result.get("point").toString()));
			log.setReason("注册送分");
			log.setUserId(id);
			testUserService.logRulePoint(log);
		}
		
		
		return "index";
	}
	/**
	 * 上传头像
	 * 
	 * @return
	 * @throws Exception
	 * @author guolei
	 * @version 1.0
	 * @created 2013-4-25
	 */
	public String upLoadPicTest() throws Exception{
		user = testUserService.getPointByUser(member.getUsername());
		if(user!=null){
			HessianProxyFactory factory = new HessianProxyFactory();
			String url = "http://127.0.0.1:8080/RuleEngine/remoting/iRuleEngine.hessian";	
			IRuleEngine  iRuleEngine = (IRuleEngine) factory.create(IRuleEngine.class, url);
			
			HashMap<String, Object> map = new HashMap<String, Object>();
			member.setId(user.getId());
			member.setAvatar(1);
			map.put("member", member);		
			List<Map<String,Object>> resultList = iRuleEngine.executeRuleEngine(map, "perfect");
			
			for(Map<String,Object> result :resultList){
				TestLog log = new TestLog();
				log.setPoint(Integer.parseInt(result.get("point").toString()));
				log.setReason("上传头像送积分，调用规则："+result.get("description").toString());
				log.setUserId(user.getId());
				testUserService.logRulePoint(log);
			}
			
		}		
		return "usera";
	}
	/**
	 * 修改昵称
	 * 
	 * @return
	 * @throws Exception
	 * @author guolei
	 * @version 1.0
	 * @created 2013-4-25
	 */
	public String updateNameTest() throws Exception{
		user = testUserService.getPointByUser(member.getUsername());
		if(user!=null){
			HessianProxyFactory factory = new HessianProxyFactory();
			String url = "http://127.0.0.1:8080/RuleEngine/remoting/iRuleEngine.hessian";	
			IRuleEngine  iRuleEngine = (IRuleEngine) factory.create(IRuleEngine.class, url);
			
			HashMap<String, Object> map = new HashMap<String, Object>();
			member.setId(user.getId());
			member.setNickname(1);
			map.put("member", member);		
			List<Map<String,Object>> resultList = iRuleEngine.executeRuleEngine(map, "perfect");
			
			for(Map<String,Object> result :resultList){
				TestLog log = new TestLog();
				log.setPoint(Integer.parseInt(result.get("point").toString()));
				log.setReason("修改昵称送积分，调用规则："+result.get("description").toString());
				log.setUserId(user.getId());
				testUserService.logRulePoint(log);	
			}
		}
		return "usera";	
	}
	/**
	 * 个人信息必填字段
	 * 
	 * @return
	 * @throws Exception
	 * @author guolei
	 * @version 1.0
	 * @created 2013-4-25
	 */
	public String messageFieldTest() throws Exception{
		
		user = testUserService.getPointByUser(member.getUsername());
		if(user!=null){
			HessianProxyFactory factory = new HessianProxyFactory();
			String url = "http://127.0.0.1:8080/RuleEngine/remoting/iRuleEngine.hessian";	
			IRuleEngine  iRuleEngine = (IRuleEngine) factory.create(IRuleEngine.class, url);
			
			HashMap<String, Object> map = new HashMap<String, Object>();
			member.setId(user.getId());
			member.setRequiredInfo(1);
			map.put("member", member);		
			List<Map<String,Object>> resultList = iRuleEngine.executeRuleEngine(map, "perfect");
			
			for(Map<String,Object> result :resultList){
				TestLog log = new TestLog();
				log.setPoint(Integer.parseInt(result.get("point").toString()));
				log.setReason("完成必填字段送积分，调用规则："+result.get("description").toString());
				log.setUserId(user.getId());
				testUserService.logRulePoint(log);	
			}
		}
		return "usera";	
	}
	/**
	 * 资料完整度
	 * 
	 * 
	 * @return
	 * @throws Exception
	 * @author guolei
	 * @version 1.0
	 * @created 2013-4-25
	 */
	public String integrityTest() throws Exception{
		user = testUserService.getPointByUser(member.getUsername());
		if(user!=null){
			HessianProxyFactory factory = new HessianProxyFactory();
			String url = "http://127.0.0.1:8080/RuleEngine/remoting/iRuleEngine.hessian";	
			IRuleEngine  iRuleEngine = (IRuleEngine) factory.create(IRuleEngine.class, url);
			
			HashMap<String, Object> map = new HashMap<String, Object>();
			member.setId(user.getId());
			map.put("member", member);		
			List<Map<String,Object>> resultList = iRuleEngine.executeRuleEngine(map, "perfect");
			for(Map<String,Object> result :resultList){
				TestLog log = new TestLog();
				log.setPoint(Integer.parseInt(result.get("point").toString()));
				log.setReason("完成非必填字段送积分，调用规则："+result.get("description").toString());
				log.setUserId(user.getId());
				testUserService.logRulePoint(log);	
			}
		}
		return "usera";	
	}
	
	public String inviteRegisterTest() throws Exception{		
		return null;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}
	public TestUser getUser() {
		return user;
	}
	public void setUser(TestUser user) {
		this.user = user;
	}
	public String getYaoqingName() {
		return yaoqingName;
	}
	public void setYaoqingName(String yaoqingName) {
		this.yaoqingName = yaoqingName;
	}
	public List<TestLog> getList() {
		return list;
	}
	public void setList(List<TestLog> list) {
		this.list = list;
	}
}
