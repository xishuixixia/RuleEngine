package com.hxrainbow.rule.operating.dao;

import java.util.List;

import com.hxrainbow.rule.model.TActionMeta;
import com.hxrainbow.rule.model.TActionMetaVariable;

public interface ActionMetaDao {
	/**
	 * 根据指定的hql语句去查询对应的营销活动，并返回list
	 * @param hql
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public List findDataByHql(String hql);
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
	 * 保存动作类型
	 * @param actionMeta
	 * @return
	 */
	public Integer saveActionMeta(TActionMeta actionMeta);
	/**
	 * 根据id查动作类型
	 * @param id
	 * @return
	 */
	public TActionMeta getActionMetaById(Integer id);
	
	/**
	 * 更新东西类型
	 * @param actionMeta
	 */
	public void updateActionMeta(TActionMeta actionMeta);
	/**
	 * 删除动作类型
	 * @param id
	 */
	public void deleteActionMeta(Integer id);
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
	 * 根据actionid查询动作以及动作元对象
	 * 
	 * @param actionId
	 * @return
	 * @author guolei
	 * @version 1.0
	 * @created 2013-4-18
	 */
	public Object[] getActionAndMetaById(Integer actionId);
	/**
	 * 添加动作类型变量
	 * 
	 * @param name
	 * @param identify
	 * @author guolei
	 * @version 1.0
	 * @created 2013-4-23
	 */
	public void saveActionMetaVariable(TActionMetaVariable variable);
	/**
	 * 查看动作类型变量
	 * 
	 * @param id
	 * @return
	 * @author guolei
	 * @version 1.0
	 * @created 2013-4-23
	 */
	public List<TActionMetaVariable> getActionMetaVariableById(Integer id);
	/**
	 * 删除动作类型变量
	 * 
	 * @param id
	 * @author guolei
	 * @version 1.0
	 * @created 2013-4-23
	 */
	public void deleteActionMetaVariable(Integer id);
}
