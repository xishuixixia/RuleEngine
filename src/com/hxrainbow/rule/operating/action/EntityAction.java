package com.hxrainbow.rule.operating.action;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.hxrainbow.rule.model.TEntity;
import com.hxrainbow.rule.operating.service.EntityItemService;
import com.hxrainbow.rule.operating.service.EntityService;
import com.hxrainbow.rule.util.BasePage;
import com.hxrainbow.rule.util.JsonUtil;
import com.hxrainbow.rule.util.Result;

@Controller
@Scope("prototype")
public class EntityAction  extends BaseAction{
	
	private static final long serialVersionUID = 1L;

	@Resource
	private EntityService entityService;
	@Resource
	private EntityItemService entityItemService;
	private String entityName;//实体名称
	private TEntity entity;//实体对象
	
	public EntityItemService getEntityItemService() {
		return entityItemService;
	}

	public void setEntityItemService(EntityItemService entityItemService) {
		this.entityItemService = entityItemService;
	}

	/**
	 * 
	 * 展示实体
	 * @return
	 * @throws Exception
	 * @author guolei
	 * @version 1.0
	 * @created 2013-4-9
	 */
	public String listEntity()  throws Exception{
		basePage = entityService.getPageEntity(basePage,entityName);
		return "list_entity";
	}

	/**
	 * 
	 * 添加实体
	 * @return
	 * @throws Exception
	 * @author guolei
	 * @version 1.0
	 * @created 2013-4-9
	 */
	public String addEntity()  throws Exception{
		
		if(entityService.getEntityByIdentify(entity.getIdentify())){
			Result result = new Result();
			result.setStatusCode("300");
			result.setMessage("标识名已存在");
			result.setCallbackType("");
			JsonUtil.toJson(result);
			return null;
		}
		
		entityService.saveEntity(entity);
		Result result = new Result();
		//result.setCallbackType("closeCurrent");
		result.setMessage("添加成功");
		result.setStatusCode("200");
		result.setNavTabId(rel);
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
		entity = entityService.getEntityById(entity.getId());
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
		entityService.updateEntity(entity);
		Result result = new Result();

		result.setMessage("更新成功");
		//result.setCallbackType("closeCurrent");
		result.setNavTabId(rel);
		JsonUtil.toJson(result);
		return null;
	}
	
	/**
	 * 
	 * 删除实体
	 * @return
	 * @throws Exception
	 * @author guolei
	 * @version 1.0
	 * @created 2013-4-9
	 */
	public String deleteEntity()  throws Exception{
		long count=entityItemService.getEntityItemCount(entity.getId());
		Result result = new Result();
		if(count>0){
			result.setCallbackType("");
			result.setStatusCode("300");
			result.setMessage("请先删除相关属性！");
			result.setNavTabId(rel);
			JsonUtil.toJson(result);
			return null;
		}
		entityService.deleteEntity(entity.getId());
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

	public String getEntityName() {
		return entityName;
	}

	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}

	public TEntity getEntity() {
		return entity;
	}

	public void setEntity(TEntity entity) {
		this.entity = entity;
	}
	
}
