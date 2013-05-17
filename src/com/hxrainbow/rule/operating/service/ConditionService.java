package com.hxrainbow.rule.operating.service;

import java.util.List;

import com.hxrainbow.rule.model.TCondition;
import com.hxrainbow.rule.model.TEntity;
import com.hxrainbow.rule.util.BasePage;

public interface ConditionService {

	/**
	 * 
	 * 根据页数列出系统中的条件
	 * @param basePage
	 * @param entityName 实体显示名称
	 * @return
	 * @author guolei
	 * @version 1.0
	 * @created 2013-4-9
	 */
	public BasePage getPageCondition(BasePage basePage,String conditionName);

	/**
	 * 
	 * 保存条件
	 * @param condition 条件对象
	 * @param item 属性id列表
	 * @param staticC 静态变量id列表
	 * @param dynamic 动态变量id列表
	 * @author guolei
	 * @version 1.0
	 * @created 2013-4-15
	 */
	public int saveCondition(TCondition condition,String item,String staticC,String dynamic);

	/**
	 * 根据实体id查询实体
	 * 
	 * @param id
	 * @return
	 * @author guolei
	 * @version 1.0
	 * @created 2013-4-9
	 */
	public TEntity getEntityById(Integer id);

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
	public void updateEntity(TEntity entity);

	/**
	 * 删除场景
	 * 
	 * @param id
	 * @author guolei
	 * @version 1.0
	 * @created 2013-4-9
	 */
	public void deleteScene(Integer id);

	/**
	 * 得到实体列表
	 * 
	 * @return
	 * @author guolei
	 * @version 1.0
	 * @created 2013-4-11
	 */
	public List<TEntity> getEntityList();
}