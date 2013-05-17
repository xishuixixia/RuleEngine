package com.hxrainbow.rule.operating.service;

import java.util.HashMap;
import java.util.List;

import com.hxrainbow.rule.model.TEntityItem;
import com.hxrainbow.rule.util.BasePage;

public interface EntityItemService {
    /**
     * 根据页数显示系统中的实体属性
     * @param basePage
     * @param entityItemName
     * @return
     */
	public BasePage getPageEntityItem(BasePage basePage,String entityItemName,Integer typeId);
	/**
	 * 保存实体属性
	 * @param entityItem
	 */
	public void saveEntityItem(TEntityItem entityItem);
	/**
	 * 根据id查询实体属性
	 * @param id
	 * @return
	 */
	public TEntityItem getEntityItemById(Integer id);
	/**
	 * 根据实体id查询实体属性
	 * @param typeId
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public List getEntityByTypeId(Integer typeId);
    /**
     * 更新实体属性
     * @param entityItem
     */
	public void updateEntityItem(TEntityItem entityItem);
	/**
	 * 删除实体属性
	 * @param id
	 */
	public void deleteEntityItem(Integer id);
	
	public Long getEntityItemCount(Integer typeId);
	
	/**
	 * 
	 * 根据实体类型查找实体属性或者根据实体类型和实体名称查找实体
	 * @param entityItemName
	 * @param typeId
	 * @return
	 * @author guolei
	 * @version 1.0
	 * @created 2013-4-15
	 */
	public List<HashMap<String,String>> listEntityItem(String entityItemName, Integer typeId,Integer sceneId);
	
}
