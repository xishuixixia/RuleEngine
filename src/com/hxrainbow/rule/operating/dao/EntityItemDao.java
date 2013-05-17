package com.hxrainbow.rule.operating.dao;

import java.util.List;

import com.hxrainbow.rule.model.TEntityItem;
/**
 * 实体dao接口层
 * @author test-2
 *
 */
public interface EntityItemDao {
	/**
	 * 根据指定的hql语句去查询对应的营销活动，并返回list
	 * @param hql
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public List findDataByHql(String hql);
	
	
	Long getEntityItemCount(Integer typeId);
	/**
	 * 根据给定的条件去查询对应的页数上的数据
	 * @param page
	 * @param pageSize
	 * @param hql
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public List findPageDataByHql(final int page,final int pageSize, final String hql) ;
	
	/**
	 * 保存实体属性
	 * @param entityItem
	 */
	public void saveEntityItem(TEntityItem entityItem);
	
	/**
	 * 根据实体属性id查询实体属性
	 * @param id
	 * @return
	 */
	public TEntityItem getEntityItemById(Integer id);
	
	/**
	 * 根据实体id查询实体属性
	 * @param tyleId
	 * @return
	 */
	public List<TEntityItem> getEntityItemByTypeId(Integer typeId);
	
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
}
