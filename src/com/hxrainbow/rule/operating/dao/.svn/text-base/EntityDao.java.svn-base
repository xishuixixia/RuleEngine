package com.hxrainbow.rule.operating.dao;

import java.util.List;

import com.hxrainbow.rule.model.TEntity;

/**
 * 实体dao接口层
 * 
 * @author guolei
 * @version 1.0
 * @created 2013-4-9
 */
public interface EntityDao {
	/**
	 * 根据指定的hql语句去查询对应的营销活动，并返回list
	 *
	 * @param hql
	 * @return
	 *
	 */
	@SuppressWarnings("rawtypes")
	public List findDataByHql(String hql);
	
	
	/**
	 * 根据hql查询记录数，用于分页
	 * 
	 * @param hql
	 * @return
	 * @author guolei
	 * @version 1.0
	 * @created 2013-4-17
	 */
	public Long findTotalCount(final String hql);
	/**
	 * 根据给定的条件去查询对应的页数上的数据
	 *
	 * @param page
	 * @param pageSize
	 * @param hql
	 * @return
	 *
	 */
	@SuppressWarnings("rawtypes")
	public List findPageDataByHql(final int page,final int pageSize, final String hql) ;
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
	 * 根据标识查询实体
	 * 
	 * @param identify
	 * @author guolei
	 * @version 1.0
	 * @created 2013-4-9
	 */
	public List<TEntity> getEntityByIdentify(String identify);
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
