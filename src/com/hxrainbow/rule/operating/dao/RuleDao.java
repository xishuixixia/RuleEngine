package com.hxrainbow.rule.operating.dao;

import java.util.HashMap;
import java.util.List;

import com.hxrainbow.rule.model.TAction;
import com.hxrainbow.rule.model.TActionMeta;
import com.hxrainbow.rule.model.TActionVariable;
import com.hxrainbow.rule.model.TEntity;
import com.hxrainbow.rule.model.TRule;
import com.hxrainbow.rule.model.TScene;
/**
 * 实体dao接口层
 * @author guolei
 *
 */
public interface RuleDao {
	/**
	 * 根据指定的hql语句去查询对应的营销活动，并返回list
	 * @param hql
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public List findDataByHql(String hql);

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
	public List findPageDataByHql(final int page,final int pageSize, final String hql);
	/**
	 * 保存动作
	 * 
	 * @param rule
	 * @author guolei
	 * @version 1.0
	 * @created 2013-4-16
	 */
	public Integer saveRule(TRule rule);

	/**
	 * 保存动作对象
	 * 
	 * @param actionObj 动作对象
	 * @return
	 * @author guolei
	 * @version 1.0
	 * @created 2013-4-16
	 */
	public Integer saveAction(TAction actionObj);

	/**
	 * 根据itemId查询item信息
	 * 
	 * @param itemId
	 * @author guolei
	 * @version 1.0
	 * @created 2013-4-16
	 */
	public HashMap<String, String> getItemInfoById(Integer itemId);

	/**
	 * 根据actionId查询action信息
	 * 
	 * @param actionId
	 * @author guolei
	 * @version 1.0
	 * @created 2013-4-16
	 */
	public TAction getActionById(Integer actionId);

	/**
	 * 根据actiontypeId查询action类型信息
	 * 
	 * @param actionId
	 * @author guolei
	 * @version 1.0
	 * @created 2013-4-16
	 */
	public TActionMeta getActionMetaById(Integer typeId);

	/**
	 * 根据规则id得到规则对象
	 * 
	 * @param ruleId
	 * @return
	 * @author guolei
	 * @version 1.0
	 * @created 2013-4-16
	 */
	public TRule getRuleById(Integer ruleId);

	/**
	 * 删除规则
	 * 
	 * @param id
	 * @author guolei
	 * @version 1.0
	 * @created 2013-4-17
	 */
	public void deleteRule(TRule rule);
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
	 * 根据规则主键更新规则enabled状态
	 * 
	 * @param id
	 * @param enabled
	 * @author guolei
	 * @version 1.0
	 * @created 2013-4-18
	 */
	public void updateEnabledRule(Integer id, Integer enabled);

	/**
	 * 根据动作id删除动作
	 * 
	 * @param actionId
	 * @author guolei
	 * @version 1.0
	 * @created 2013-4-19
	 */
	public void deleteActionByActionId(int actionId);
	/**
	 * 根据规则id删除规则
	 * 
	 * @param id
	 * @author guolei
	 * @version 1.0
	 * @created 2013-4-17
	 */
	public void deleteRuleById(Integer id);

	/**
	 * 保存动作与变量表的中间关联
	 * 
	 * @param variable
	 * @author guolei
	 * @version 1.0
	 * @created 2013-4-24
	 */
	public void saveActionVariable(TActionVariable variable);

	/**
	 * 根据meta主键查找TActionMetaVariable中符合的item
	 * 
	 * @param metaId
	 * @return
	 * @author guolei
	 * @version 1.0
	 * @created 2013-4-24
	 */
	public List<Object[]> getActionVariableList(Integer metaId,Integer actionId);

	/**
	 * 根据actionid查询对应的条件类型
	 * 
	 * @param actionId
	 * @return
	 * @author guolei
	 * @version 1.0
	 * @created 2013-4-24
	 */
	public TActionMeta getActionMetaByActionId(Integer actionId);

	/**
	 * 根据场景id得到场景对应的实体信息
	 * 
	 * @param sceneId
	 * @author guolei
	 * @version 1.0
	 * @created 2013-5-8
	 */
	public List<TEntity> getEntityOfSceneById(Integer sceneId);

	/**
	 * 根据场景id得到场景信息
	 * 
	 * @param sceneId
	 * @author guolei
	 * @version 1.0
	 * @created 2013-5-8
	 */
	public TScene getSceneById(Integer sceneId);
}
