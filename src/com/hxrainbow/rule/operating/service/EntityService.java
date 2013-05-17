package com.hxrainbow.rule.operating.service;

import com.hxrainbow.rule.model.TEntity;
import com.hxrainbow.rule.util.BasePage;

public interface EntityService {

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
	public BasePage getPageEntity(BasePage basePage,String entityName);

	/**
	 * 保存实体
	 * 
	 * @param entity
	 * @return
	 * @author guolei
	 * @version 1.0
	 * @created 2013-4-9
	 */
	public void saveEntity(TEntity entity);

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
	 * 根据标识名查询实体
	 * 
	 * @param identify
	 * @return
	 * @author guolei
	 * @version 1.0
	 * @created 2013-4-9
	 */
	public boolean getEntityByIdentify(String identify);

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
	 * 删除实体
	 * 
	 * @param id
	 * @author guolei
	 * @version 1.0
	 * @created 2013-4-9
	 */
	public void deleteEntity(Integer id);
}