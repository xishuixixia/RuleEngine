package com.hxrainbow.rule.operating.action;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.hxrainbow.rule.model.TEntity;
import com.hxrainbow.rule.model.TRule;
import com.hxrainbow.rule.operating.service.EntityItemService;
import com.hxrainbow.rule.operating.service.RuleService;
import com.hxrainbow.rule.operating.service.SceneService;
import com.hxrainbow.rule.util.BasePage;
import com.hxrainbow.rule.util.JsonUtil;
import com.hxrainbow.rule.util.Result;

/**
 * 变量类action
 * 
 * @author guolei
 * @version 1.0
 * @created 2013-4-15
 */
@Controller
@Scope("prototype")
public class RuleAction extends BaseAction {

	private static final long serialVersionUID = 1L;
	
	@Resource
	private RuleService ruleService;
	@Resource
	private SceneService sceneService;
	@Resource
	private EntityItemService  entityItemService;
	
	private Integer sceneId;//场景id
	
	private List<TEntity> entityList;
	
	private Integer entityId;//实体id
	private String itemName;//搜索时的item名字
	
	private List<HashMap<String, String>> itemList;
	
	private List<String> actionList;
	
	private TRule rule;
	
	private HashMap<String, String> actionMap;
	
	private int flag;
	
	private String itemInput;//应该往哪个input填入值
	
	private Integer variableId;
	
	/**
	 * 
	 * 跳转到规则添加页面
	 * @return
	 * @throws Exception
	 * @author guolei
	 * @version 1.0
	 * @created 2013-4-15
	 */
	public String showAddRule()  throws Exception{
		return "add_rule";
	}
	
	/**
	 * 跳转到实体属性列表页面
	 * 
	 * @return
	 * @throws Exception
	 * @author guolei
	 * @version 1.0
	 * @created 2013-4-16
	 */
	public String showItemRule() throws Exception{
		entityList = sceneService.getEntityOfScene(sceneId);
		itemList = entityItemService.listEntityItem(itemName,entityId,sceneId);	
		
		return "rule_item";
	}

	/**
	 * 添加规则
	 * 
	 * @return
	 * @throws Exception
	 * @author guolei
	 * @version 1.0
	 * @created 2013-4-16
	 */
	public String addRule() throws Exception{
		
		
		if(rule.getBegin() != null && rule.getEnd() != null && rule.getBegin().getTime() > rule.getEnd().getTime()){
			Result result = new Result();
			result.setStatusCode("300");
			result.setMessage("开始日期应该小于结束日期");
			JsonUtil.toJson(result);
			return null;	
		}
		try{
			ruleService.addRule(rule,actionList);
		}catch(Exception e){
			Result result = new Result();
			result.setStatusCode("300");
			result.setMessage("添加失败，请检查规则条件");
			result.setNavTabId(rel);
			JsonUtil.toJson(result);
			return null;
		}
		Result result = new Result();
		result.setMessage("添加成功");
		result.setNavTabId(rel);
		JsonUtil.toJson(result);
		return null;
	}
	/**
	 * 查看规则详情
	 * 
	 * @return
	 * @throws Exception
	 * @author guolei
	 * @version 1.0
	 * @created 2013-4-17
	 */
	public String showRule() throws Exception{
		rule = ruleService.getRuleById(rule.getId());//得到规则的信息，包括条件信息，用于修改页面展示
		actionMap = ruleService.getActionInfo(rule.getAction());
		return "show_rule";
	}
	/**
	 * 查看规则
	 * 
	 * @return
	 * @throws Exception
	 * @author guolei
	 * @version 1.0
	 * @created 2013-4-16
	 */
	public String listRule() throws Exception{
		
		if(rule == null ){
			rule = new TRule();
		}
		basePage = ruleService.listPageRule(basePage,sceneId,rule.getName(),rule.getEnabled());
		
		return "rule_list";
	}
	
	/**
	 * 查看规则更新
	 * 
	 * @return
	 * @throws Exception
	 * @author guolei
	 * @version 1.0
	 * @created 2013-4-16
	 */
	public String showUpdateRule() throws Exception{
		rule = ruleService.getRuleById(rule.getId());//得到规则的信息，包括条件信息，用于修改页面展示
		actionMap = ruleService.getActionInfo(rule.getAction());
		return "show_update";
	}
	
	/**
	 * 规则更新
	 * 
	 * @return
	 * @throws Exception
	 * @author guolei
	 * @version 1.0
	 * @created 2013-4-16
	 */
	public String updateRule() throws Exception{
		ruleService.updateRule(rule,actionList);
		Result result = new Result();
		result.setNavTabId(rel);
		result.setMessage("修改成功");
		JsonUtil.toJson(result);
		return null;
	}
	
	/**
	 * 删除规则
	 * 
	 * @return
	 * @throws Exception
	 * @author guolei
	 * @version 1.0
	 * @created 2013-4-16
	 */
	public String deleteRule() throws Exception{
		ruleService.deleteRule(rule.getId());
		Result result = new Result();
		result.setCallbackType("");
		result.setReload("1");
		result.setMessage("删除成功");
		//result.setForwardUrl("rule/listRule");
		//result.setNavTabId(rel);
		JsonUtil.toJson(result);
		return null;
	}
	
	/**
	 * 修改规则的启用状态
	 * 
	 * @return
	 * @throws Exception
	 * @author guolei
	 * @version 1.0
	 * @created 2013-5-8
	 */
	public String updateEnabledRule() throws Exception{
		ruleService.updateEnabledRule(rule);
		Result result = new Result();
		result.setCallbackType("");
		result.setReload("1");
		result.setMessage("修改成功");
		JsonUtil.toJson(result);
		return null;
	}
	
	public Integer getSceneId() {
		return sceneId;
	}

	public void setSceneId(Integer sceneId) {
		this.sceneId = sceneId;
	}

	public List<TEntity> getEntityList() {
		return entityList;
	}

	public void setEntityList(List<TEntity> entityList) {
		this.entityList = entityList;
	}

	public Integer getEntityId() {
		return entityId;
	}

	public void setEntityId(Integer entityId) {
		this.entityId = entityId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public List<HashMap<String, String>> getItemList() {
		return itemList;
	}

	public void setItemList(List<HashMap<String, String>> itemList) {
		this.itemList = itemList;
	}

	public TRule getRule() {
		return rule;
	}

	public void setRule(TRule rule) {
		this.rule = rule;
	}

	public List<String> getActionList() {
		return actionList;
	}

	public void setActionList(List<String> actionList) {
		this.actionList = actionList;
	}

	public BasePage getBasePage() {
		return basePage;
	}

	public void setBasePage(BasePage basePage) {
		this.basePage = basePage;
	}

	public HashMap<String, String> getActionMap() {
		return actionMap;
	}

	public void setActionMap(HashMap<String, String> actionMap) {
		this.actionMap = actionMap;
	}

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

	public String getItemInput() {
		return itemInput;
	}

	public void setItemInput(String itemInput) {
		this.itemInput = itemInput;
	}

	public Integer getVariableId() {
		return variableId;
	}

	public void setVariableId(Integer variableId) {
		this.variableId = variableId;
	}
	
}
