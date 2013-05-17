package com.hxrainbow.rule.operating.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.hxrainbow.rule.model.TCondition;
import com.hxrainbow.rule.model.TEntity;
import com.hxrainbow.rule.operating.service.ConditionService;
import com.hxrainbow.rule.util.BasePage;
import com.hxrainbow.rule.util.JsonUtil;
import com.hxrainbow.rule.util.Result;

/**
 * 条件action
 * 
 * @author guolei
 * @version 1.0
 * @created 2013-4-11
 */
@Controller
@Scope("prototype")
public class ConditionAction  extends BaseAction{

	private static final long serialVersionUID = 1L;

	@Resource
	private ConditionService conditionService;
	private BasePage basePage = new BasePage();
	private String conditionName;//条件名称
	private TCondition condition;//条件对象
	private List<TEntity> entityList;//实体列表，用于条件条件部分展示
	private String item;//前端item的id信息
	private String staticC;//前端静态变量id信息
	private String dynamic;//前端动态变量id信息
	
	/**
	 * 
	 * 展示条件
	 * @return
	 * @throws Exception
	 * @author guolei
	 * @version 1.0
	 * @created 2013-4-9
	 */
	public String listCondition()  throws Exception{
		basePage = conditionService.getPageCondition(basePage,conditionName);
		return "list_condition";
	}

	/**
	 * 展示条件添加页面
	 * 
	 * @return
	 * @throws Exception
	 * @author guolei
	 * @version 1.0
	 * @created 2013-4-11
	 */
	public String showAddCondition() throws Exception{
		entityList = conditionService.getEntityList();
		return "add_condition";
	}
	/**
	 * 
	 * 添加条件
	 * @return
	 * @throws Exception
	 * @author guolei
	 * @version 1.0
	 * @created 2013-4-9
	 */
	public String addCondition()  throws Exception{
		
		conditionService.saveCondition(condition,item,staticC,dynamic);
		Result result = new Result();
		result.setMessage("添加成功");
		result.setNavTabId("entityList");
		JsonUtil.toJson(result);
		return null;
	}
	/**
	 * 展示实体
	 * 
	 * @return
	 * @throws Exception
	 * @author guolei
	 * @version 1.0
	 * @created 2013-4-9
	 */
	public String showEntity() throws Exception{
		//entity = sceneService.getEntityById(entity.getId());
		return "show";
	}

	/**
	 * 
	 * 更新实体
	 * @return
	 * @throws Exception
	 * @author guolei
	 * @version 1.0
	 * @created 2013-4-9
	 */
	public String updateEntity()  throws Exception{
		
		//sceneService.updateEntity(entity);
		Result result = new Result();
		result.setMessage("添加成功");
		result.setNavTabId("entityList");
		JsonUtil.toJson(result);
		return null;
	}
	
	/**
	 * 
	 * 删除场景
	 * @return
	 * @throws Exception
	 * @author guolei
	 * @version 1.0
	 * @created 2013-4-9
	 */
	public String deleteScene()  throws Exception{
		
		conditionService.deleteScene(condition.getId());
		Result result = new Result();
		result.setCallbackType("");
		result.setMessage("删除成功");
		result.setNavTabId("sceneList");
		JsonUtil.toJson(result);
		return null;
	}
	
	public BasePage getBasePage() {
		return basePage;
	}
	public void setBasePage(BasePage basePage) {
		this.basePage = basePage;
	}

	public String getConditionName() {
		return conditionName;
	}

	public void setConditionName(String conditionName) {
		this.conditionName = conditionName;
	}

	public TCondition getCondition() {
		return condition;
	}

	public void setCondition(TCondition condition) {
		this.condition = condition;
	}

	public List<TEntity> getEntityList() {
		return entityList;
	}

	public void setEntityList(List<TEntity> entityList) {
		this.entityList = entityList;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public String getStaticC() {
		return staticC;
	}

	public void setStaticC(String staticC) {
		this.staticC = staticC;
	}

	public String getDynamic() {
		return dynamic;
	}

	public void setDynamic(String dynamic) {
		this.dynamic = dynamic;
	}

}
