package com.hxrainbow.rule.operating.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.hxrainbow.rule.model.TEntityItem;
import com.hxrainbow.rule.operating.service.EntityItemService;
import com.hxrainbow.rule.util.BasePage;
import com.hxrainbow.rule.util.DroolsUtil;
import com.hxrainbow.rule.util.JsonUtil;
import com.hxrainbow.rule.util.Result;
@Controller
@Scope("prototype")
public class EntityItemAction extends BaseAction{
	
	private static final long serialVersionUID = 1L;
 
	@Resource
	private EntityItemService entityItemService;
	private BasePage basePage = new BasePage();
	private String entityItemName;//实体属性名称
	private TEntityItem entityItem;//实体对象
	private Integer typeId;
	
	private List<HashMap<String, String>> itemList;
	
	/**
	 * 展示实体属性
	 * @return
	 * @throws Exception
	 */
	public String listEntityItem()  throws Exception{
	
		basePage = entityItemService.getPageEntityItem(basePage,entityItemName,typeId);		
		return "list_item";
	}
	/**
	 * 添加实体属性
	 * @return
	 * @throws Exception
	 */
	public String addEntityItem()  throws Exception{			
		entityItemService.saveEntityItem(entityItem);
		DroolsUtil.removeRuleMap();
		Result result = new Result();
		result.setMessage("添加成功");
		result.setCallbackType("closeCurrent");
		result.setForwardUrl("entity/listEntityItem");
		result.setNavTabId(rel);
		JsonUtil.toJson(result);
		return null;
	}	
	/**
	 * 展示实体属性界面
	 * @return
	 * @throws Exception
	 */
	public String showItem() throws Exception{		
		return "showAdd";
	}
	/**
	 * 修改实体属性界面
	 * @return
	 * @throws Exception
	 */
	public String showEntityItem() throws Exception{
		entityItem = entityItemService.getEntityItemById(entityItem.getId());
		return "showEntityItem";
	}
	/**
	 * 修改实体属性
	 * @return
	 * @throws Exception
	 */
    public String updateEntityItem()  throws Exception{
		
		entityItemService.updateEntityItem(entityItem);
		DroolsUtil.removeRuleMap();
		Result result = new Result();
		result.setMessage("更新成功");
		result.setForwardUrl("entity/listEntityItem");
		result.setNavTabId(rel);
		JsonUtil.toJson(result);
		return null;
	}
    /**
     * 删除实体属性
     * @return
     * @throws Exception
     */
	public String deleteEntityItem()  throws Exception{
		Integer id=entityItem.getId();	
		entityItemService.deleteEntityItem(id);
		DroolsUtil.removeRuleMap();
		Result result = new Result();
		result.setCallbackType("");
		result.setMessage("删除成功");
		result.setForwardUrl("entity/listEntityItem");
		result.setNavTabId(rel);
		Map<String, String> r=new HashMap<String, String>();
		r.put("message", "删除成功");
		r.put("statusCode", "200");
		//r.put("navTabId", rel);
		r.put("callbackType", "forward");
		r.put("forwardUrl", "entity/listEntityItem");
		JsonUtil.toJson(r);
		return null;
	}

//	/**
//	 * 
//	 * 列出实体属性，用于条件添加部分，此部分不需要分页
//	 * @return
//	 * @throws Exception
//	 * @author guolei
//	 * @version 1.0
//	 * @created 2013-4-15
//	 */
//	public String listItem()  throws Exception{
//		itemList = entityItemService.listEntityItem(entityItemName,typeId);		
//		return "entity_item";
//	}
	
	
	public BasePage getBasePage() {
		return basePage;
	}
	public void setBasePage(BasePage basePage) {
		this.basePage = basePage;
	}
	public String getEntityItemName() {
		return entityItemName;
	}
	public void setEntityItemName(String entityItemName) {
		this.entityItemName = entityItemName;
	}
	public TEntityItem getEntityItem() {
		return entityItem;
	}
	public void setEntityItem(TEntityItem entityItem) {
		this.entityItem = entityItem;
	}
	public Integer getTypeId() {
		return typeId;
	}
	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}
	public List<HashMap<String, String>> getItemList() {
		return itemList;
	}
	public void setItemList(List<HashMap<String, String>> itemList) {
		this.itemList = itemList;
	}
	
}
