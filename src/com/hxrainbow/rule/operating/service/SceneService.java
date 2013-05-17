package com.hxrainbow.rule.operating.service;

import java.util.List;
import java.util.Map;

import com.hxrainbow.rule.model.Menu;
import com.hxrainbow.rule.model.TEntity;
import com.hxrainbow.rule.model.TRule;
import com.hxrainbow.rule.model.TScene;
import com.hxrainbow.rule.model.TSceneEntity;

import com.hxrainbow.rule.util.BasePage;

public interface SceneService {

	/**
	 * 
	 * 根据页数列出系统中的实体
	 * @param basePage
	 * @param entityName 实体显示名称
	 * @return
	 * @author guolei
	 * @version 1.0
	 * @created 2013-4-9
	 */
	public BasePage getPageScene(BasePage basePage,String sceneName);
	
	
	/**
	 * 保存场景
	 * 
	 * @param entity
	 * @return
	 * @author guolei
	 * @version 1.0
	 * @created 2013-4-9
	 */
	public void saveScene(TScene scene,List<Integer> idList,String sceneName,List<Menu> children);
	/**
	 * 添加菜单
	 * 
	 * @param sceneId
	 * @param menu
	 * @author guolei
	 * @version 1.0
	 * @created 2013-4-18
	 */	
	
	/**
	 * 对单个场景添加一个或多个实体
	 * 
	 * @param sceneId
	 * @param idList
	 * @author guolei
	 * @version 1.0
	 * @created 2013-4-18
	 */
	public void saveEntityScene(Integer sceneId,List<Integer> idList);

	/**
	 * 根据实体id查询实体
	 * 
	 * @param id
	 * @return
	 * @author guolei
	 * @version 1.0
	 * @created 2013-4-9
	 */
	public TScene getSceneById(Integer id);

	/**
	 * 根据标识名查询场景
	 * 
	 * @param identify
	 * @return
	 * @author guolei
	 * @version 1.0
	 * @created 2013-4-9
	 */
	public boolean getSceneByIdentify(String identify);

	/**
	 * 更新实体
	 * 
	 * @param entity
	 * @author guolei
	 * @version 1.0
	 * @created 2013-4-9
	 */
	public void updateScene(TScene scene);

	/**
	 * 删除场景
	 * 
	 * @param id
	 * @author guolei
	 * @version 1.0
	 * @created 2013-4-9
	 */
	public void deleteScene(Integer id,String sceneName);

	/**
	 * 得到场景对应的实体
	 * 
	 * @param sceneId
	 * @return
	 * @author guolei
	 * @version 1.0
	 * @created 2013-4-15
	 */
	public List<TEntity> getEntityOfScene(Integer sceneId);
	/**
	 * 
	 * 查询实体
	 * @return
	 * @author liuyaxin
	 * @version 1.0
	 * @created 2013-4-17
	 */
	public List<TEntity> getEntity();
	/**
	 * 删除场景实体
	 * 
	 * @param id
	 * @author guolei
	 * @version 1.0
	 * @created 2013-4-17
	 */
	public void deleteEntityScene(Integer sceneId,Integer entityId);
	
	
	/**
	 * 
	 * @param sceneId
	 * @author guolei
	 * @version 1.0
	 * @created 2013-4-19
	 */
	void deleteEntityScene(Integer sceneId);

	int saveSceneEntity(int[] entityIds,int sceneId);
	/**
	 * 根据场景标识查询实体信息
	 * 
	 * @param scene
	 * @return
	 * @author guolei
	 * @version 1.0
	 * @created 2013-4-18
	 */
	public List<TEntity> getEntityOfSceneByIdentity(String sceneIdentity);

	/**
	 * 根据场景标识获取可用的规则信息
	 * 
	 * @param scene
	 * @return
	 * @author guolei
	 * @version 1.0
	 * @created 2013-4-18
	 */
	public List<TRule> getEnabledRuleBySceneIdentity(String scene);
	/**
	 * 查找场景关系表中重复的关系列表根据sceneId，entityId
	 * 
	 * @param sceneId
	 * @param entityId
	 * @return
	 * @author guolei
	 * @version 1.0
	 * @created 2013-4-19
	 */
	public List<TSceneEntity> listEntityScene(Integer sceneId,Integer entityId);
	
	List<Map<String,Object>> getSceneEntityList(int sid);

}