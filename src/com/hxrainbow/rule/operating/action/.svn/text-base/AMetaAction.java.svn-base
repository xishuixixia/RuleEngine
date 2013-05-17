package com.hxrainbow.rule.operating.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.hxrainbow.rule.model.TActionMeta;
import com.hxrainbow.rule.model.TActionMetaVariable;
import com.hxrainbow.rule.operating.service.ActionMetaService;
import com.hxrainbow.rule.util.BasePage;
import com.hxrainbow.rule.util.DroolsUtil;
import com.hxrainbow.rule.util.JsonUtil;
import com.hxrainbow.rule.util.Result;

@Controller
@Scope("prototype")
public class AMetaAction extends BaseAction{
   
	private static final long serialVersionUID = 1L;
	
	@Resource
	private ActionMetaService actionMetaService;
	private String actionMetaName;//实体名称	
	private TActionMeta actionMeta;//实体对象
	
	private List<TActionMeta> list;//用于添加规则部分的动作类型展示
	
	private Integer flag = 0;//标示条件添加部分是否有附加值，默认没有
	
	private String sceneId;
	
	private Integer is_update;
	
	private List<String> variable;
	
	private List<TActionMetaVariable> variableList;
	
	/**
	 * 获取动作类型列表
	 * @return
	 * @throws Exception
	 */
	public String listActionMeta()  throws Exception{
		basePage = actionMetaService.getPageActionMeta(basePage,actionMetaName);
		return "list_meta";
	}
	/**
	 * 在条件部分添加动作时展示所有的动作类型
	 * 
	 * @return
	 * @throws Exception
	 * @author guolei
	 * @version 1.0
	 * @created 2013-4-16
	 */
	public String ruleActionMeta() throws Exception{
		
		list = actionMetaService.getActionMetaList();
		return "rule_meta";
	}
	
	/**
	 * 展示添加动作页面
	 * 
	 * @return
	 * @throws Exception
	 * @author guolei
	 * @version 1.0
	 * @created 2013-4-16
	 */
	public String showAddAction() throws Exception{
		actionMeta = actionMetaService.getActionMetaById(actionMeta.getId());
		variableList = actionMetaService.getActionMetaVariableById(actionMeta.getId());
		return "add_action";
	}
	/**
	 * 添加动作类型
	 * 
	 * @return
	 * @throws Exception	
	 * @version 1.0
	 * @created 2013-4-16
	 */
	public String addActionMeta()  throws Exception{
						
	    actionMetaService.saveActionMeta(actionMeta,variable);
	    
		Result result = new Result();
		result.setMessage("添加成功");
		result.setNavTabId(rel);
		JsonUtil.toJson(result);
		return null;
	}
	/**
	 * 展示动作类型，用于修改
	 * @return
	 * @throws Exception	
	 * @version 1.0
	 * @created 2013-4-16
	 */
	public String showActionMeta() throws Exception{
		actionMeta = actionMetaService.getActionMetaById(actionMeta.getId());
		variableList = actionMetaService.getActionMetaVariableById(actionMeta.getId());
		return "showMeta";
	}	
	/**
	 * 展示动作类型
	 * @return
	 * @throws Exception	
	 * @version 1.0
	 * @created 2013-4-16
	 */
	public String viewActionMeta() throws Exception{
		actionMeta = actionMetaService.getActionMetaById(actionMeta.getId());
		variableList = actionMetaService.getActionMetaVariableById(actionMeta.getId());
		return "view";
	}	
	/**
	 * 修改动作类型
	 * @return
	 * @throws Exception	
	 * @version 1.0
	 * @created 2013-4-16
	 */
	public String updateActionMeta()  throws Exception{
			
	    actionMetaService.updateActionMeta(actionMeta,variable);
	    DroolsUtil.removeRuleMap();
		Result result = new Result();
		result.setMessage("修改成功");
		result.setNavTabId(rel);
		JsonUtil.toJson(result);
		return null;
	}	
	/**
	 * 删除动作类型根据id
	 * 
	 * @return
	 * @throws Exception
	 * @author guolei
	 * @version 1.0
	 * @created 2013-4-16
	 */
	public String deleteActionMeta()  throws Exception{
			
		actionMetaService.deleteActionMeta(actionMeta.getId());
		Result result = new Result();
		result.setCallbackType("");
		result.setMessage("删除成功");
		result.setNavTabId(rel);
		JsonUtil.toJson(result);
		return null;
	}
	
	public BasePage getBasePage() {
		return basePage;
	}
	public void setBasePage(BasePage basePage) {
		this.basePage = basePage;
	}
	public String getActionMetaName() {
		return actionMetaName;
	}
	public void setActionMetaName(String actionMetaName) {
		this.actionMetaName = actionMetaName;
	}
	public TActionMeta getActionMeta() {
		return actionMeta;
	}
	public void setActionMeta(TActionMeta actionMeta) {
		this.actionMeta = actionMeta;
	}
	public List<TActionMeta> getList() {
		return list;
	}
	public void setList(List<TActionMeta> list) {
		this.list = list;
	}
	public Integer getFlag() {
		return flag;
	}
	public void setFlag(Integer flag) {
		this.flag = flag;
	}
	public String getSceneId() {
		return sceneId;
	}
	public void setSceneId(String sceneId) {
		this.sceneId = sceneId;
	}
	public Integer getIs_update() {
		return is_update;
	}
	public void setIs_update(Integer is_update) {
		this.is_update = is_update;
	}
	public List<String> getVariable() {
		return variable;
	}
	public void setVariable(List<String> variable) {
		this.variable = variable;
	}
	public List<TActionMetaVariable> getVariableList() {
		return variableList;
	}
	public void setVariableList(List<TActionMetaVariable> variableList) {
		this.variableList = variableList;
	}
	
}
