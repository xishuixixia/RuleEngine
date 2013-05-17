package com.hxrainbow.rule.operating.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.hxrainbow.rule.model.Menu;
import com.hxrainbow.rule.model.TEntity;
import com.hxrainbow.rule.model.TScene;
import com.hxrainbow.rule.model.TSceneEntity;
import com.hxrainbow.rule.operating.service.MenuService;
import com.hxrainbow.rule.operating.service.SceneService;
import com.hxrainbow.rule.util.BasePage;
import com.hxrainbow.rule.util.DroolsUtil;
import com.hxrainbow.rule.util.JsonUtil;
import com.hxrainbow.rule.util.Result;

/**
 * @author guolei
 *
 */
@Controller
@Scope("prototype")
public class SceneAction  extends BaseAction{

	private static final long serialVersionUID = 1L;
	@Resource
	private SceneService sceneService;
	@Resource
	private MenuService menuService;
	private String sceneName;//场景名称
	private String entityName;	
	private TScene scene;//场景对象
	private TSceneEntity sceneEntity; 	
	private Integer sceneId;	
	private Integer entityId;
	private List<TEntity> listEntity;
	private List<TEntity> listEntityScene;		
	private List<Map<String,Object>> entityList;
	
	private int entityIds[];
	
	
	
	public int[] getEntityIds() {
		return entityIds;
	}
	public void setEntityIds(int[] entityIds) {
		this.entityIds = entityIds;
	}
	public List<Map<String, Object>> getEntityList() {
		return entityList;
	}
	/**
	 * 
	 * 展示场景
	 * @return
	 * @throws Exception
	 * @author liuyaxin
	 * @version 1.0
	 * @created 2013-4-9
	 */
	public String listScene()  throws Exception{
		basePage = sceneService.getPageScene(basePage,sceneName);
		return "list_scene";
	}		
    /**
     * 查看场景实体
     * 
     * @return
     * @throws Exception
     * @author liuyaxin
     * @version 1.0
     * @created 2013-4-16
     */
	public String listEntityOfScene()  throws Exception{
		entityList=sceneService.getSceneEntityList(sceneId);
		//listEntity=sceneService.getEntityOfScene(sceneId);			
		return "list_entity_scene";
	}
	/**
	 * 
	 * 添加场景
	 * @return
	 * @throws Exception
	 * @author liuyaxin
	 * @version 1.0
	 * @created 2013-4-9
	 */
	public String addScene()  throws Exception{
		 String ids=sceneEntity.getEntityIdArr();
		 List<Integer> entityIdList = new ArrayList<Integer>();
		 String[] ss=ids.split(",");
		 for(String s:ss){     
			 entityIdList.add(Integer.parseInt(s));	
		 }		 		
		 if(sceneService.getSceneByIdentify(scene.getIdentify())){
			Result result = new Result();
			result.setStatusCode("300");
			result.setMessage("标识名已存在");
			result.setCallbackType("");
			JsonUtil.toJson(result);
			return null;
		}	
		List<Menu> list=menuService.getMenuChildren();	
		String sceneName=scene.getName(); 
		sceneService.saveScene(scene,entityIdList,sceneName,list);				
		Result result = new Result();
		result.setMessage("添加成功");
		result.setStatusCode("200");
		result.setNavTabId(rel);
		JsonUtil.toJson(result);
		return null;
	}
	/**
	 * 
	 * 添加场景对应的实体
	 * @return
	 * @throws Exception
	 * @author liuyaxin
	 * @version 1.0
	 * @created 2013-4-18
	 */
	public String addEntityScene()  throws Exception{
		 String ids=sceneEntity.getEntityIdArr();		 
		 List<Integer> entityIdList = new ArrayList<Integer>();
		 String[] ss=ids.split(",");
		 for(String s:ss){     
			 entityIdList.add(Integer.parseInt(s));	
		 }	
	    Integer sceneId=sceneEntity.getSceneId();			  
		sceneService.saveEntityScene(sceneId,entityIdList);	
		DroolsUtil.removeRuleMap();
		Result result = new Result();
		result.setMessage("添加成功");		
		JsonUtil.toJson(result);
		return null;
	}
	/**
	 * 根据场景id查询场景
	 * 
	 * @return
	 * @throws Exception
	 * @author liuyaxin
	 * @version 1.0
	 * @created 2013-4-9
	 */
	public String showScene() throws Exception{	
		scene = sceneService.getSceneById(sceneId);
		return "show";
	}
	/**
	 * 展示对场景添加实体的页面
	 * 
	 * @return
	 * @throws Exception
	 * @author liuyaxin
	 * @version 1.0
	 * @created 2013-4-18
	 */
    public String showAddEntityScene() throws Exception{   	
    	return "showAddEntityScene";
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
	public String updateScene()  throws Exception{
		
		sceneService.updateScene(scene);
		DroolsUtil.removeRuleMap();
		Result result = new Result();
		result.setMessage("修改成功");
		result.setNavTabId(rel);
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
		TScene scene=sceneService.getSceneById(sceneId);		
		sceneService.deleteScene(sceneId,scene.getName());	
		DroolsUtil.removeRuleMap(scene.getIdentify());
		Result result = new Result();
		result.setCallbackType("");
		result.setMessage("删除成功");
		result.setNavTabId(rel);
		JsonUtil.toJson(result);
		return null;
	}
	/**
	 * 
	 * 删除场景实体
	 * @return
	 * @throws Exception
	 * @author liuyaxin
	 * @version 1.0
	 * @created 2013-4-17
	 */
	public String deleteEntiyScene() throws Exception{
		sceneService.deleteEntityScene(sceneId,entityId);
		DroolsUtil.removeRuleMap();
		Result result = new Result();
		result.setCallbackType("");
		result.setMessage("删除成功");
		JsonUtil.toJson(result);
		return null;
	}
	
	/**
	 * 
	 * @return
	 * @author guolei
	 * @version 1.0
	 * @throws Exception 
	 * @created 2013-4-19
	 */
	public String saveEntityList() throws Exception{
		Result r=new Result();
		int i=sceneService.saveSceneEntity(entityIds, sceneId.intValue());
		DroolsUtil.removeRuleMap();
		if(i>=0){
			r.setMessage("关联实体成功！");
			r.setStatusCode("200");
			r.setCallbackType("");
		}
		return json(r);
	}
	
	/**
	 * 
	 * 在场景中查询实体列表
	 * @return
	 * @author liuyaxin
	 * @version 1.0
	 * @created 2013-4-17
	 */
	public String listEntityScene(){
		listEntityScene = sceneService.getEntity();
		return "list_entity";
	}
	
	public BasePage getBasePage() {
		return basePage;
	}

	public void setBasePage(BasePage basePage) {
		this.basePage = basePage;
	}

	public String getSceneName() {
		return sceneName;
	}

	public void setSceneName(String sceneName) {
		this.sceneName = sceneName;
	}

	public TScene getScene() {
		return scene;
	}

	public void setScene(TScene scene) {
		this.scene = scene;
	}

	public Integer getSceneId() {
		return sceneId;
	}

	public void setSceneId(Integer sceneId) {
		this.sceneId = sceneId;
	}
	public String getEntityName() {
		return entityName;
	}

	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}
	public List<TEntity> getListEntity() {
		return listEntity;
	}

	public void setListEntity(List<TEntity> listEntity) {
		this.listEntity = listEntity;
	}

	public TSceneEntity getSceneEntity() {
		return sceneEntity;
	}
	public void setSceneEntity(TSceneEntity sceneEntity) {
		this.sceneEntity = sceneEntity;
	}
	public List<TEntity> getListEntityScene() {
		return listEntityScene;
	}
	public void setListEntityScene(List<TEntity> listEntityScene) {
		this.listEntityScene = listEntityScene;
	}
	public Integer getEntityId() {
		return entityId;
	}
	public void setEntityId(Integer entityId) {
		this.entityId = entityId;
	}
	
}
