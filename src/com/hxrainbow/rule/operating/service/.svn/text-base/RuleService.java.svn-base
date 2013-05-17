package com.hxrainbow.rule.operating.service;

import java.util.HashMap;
import java.util.List;

import com.hxrainbow.rule.model.TRule;
import com.hxrainbow.rule.model.TVariable;
import com.hxrainbow.rule.util.BasePage;
import com.hxrainbow.rule.util.RuleEngineException;

/**
 * 变量操作接口类
 * 
 * @author guolei
 * @version 1.0
 * @created 2013-4-15
 */
public interface RuleService {

	/**
	 * 根据变量类型和变量名称查询变量列表
	 * 
	 * @param variableName
	 * @param type
	 * @return
	 * @author guolei
	 * @version 1.0
	 * @created 2013-4-15
	 */
	List<TVariable> listVariable(String variableName, Integer type);

	/**
	 * 添加规则接口，包括初始化条件和动作
	 * 
	 * @param rule
	 * @param actionList 动作列表
	 * @author guolei
	 * @version 1.0
	 * @created 2013-4-16
	 */
	public int addRule(TRule rule,List<String> actionList);

	/**
	 * 根据场景id、场景名称、是否启用查询规则
	 * 
	 * @param sceneId
	 * @param name
	 * @param enabled
	 * @return
	 * @author guolei
	 * @version 1.0
	 * @created 2013-4-16
	 */
	public BasePage listPageRule(BasePage basePage,Integer sceneId, String name, Integer enabled);

	/**
	 * 根据规则id查找规则信息
	 * 
	 * @param id
	 * @return
	 * @author guolei
	 * @version 1.0
	 * @created 2013-4-16
	 */
	public TRule getRuleById(Integer ruleId);

	/**
	 * 根据规则中的action描述信息，组合出一个可用的map，来在前端显示规则
	 * 
	 * @param action
	 * @return
	 * @author guolei
	 * @version 1.0
	 * @created 2013-4-16
	 */
	public HashMap<String, String> getActionInfo(String action);

	/**
	 * 修改规则
	 * 
	 * @param rule
	 * @author guolei
	 * @version 1.0
	 * @created 2013-4-17
	 */
	public Integer updateRule(TRule rule,List<String> actionList);

	/**
	 * 根据规则id删除规则
	 * 
	 * @param ruleId
	 * @author guolei
	 * @version 1.0
	 * @created 2013-4-17
	 */
	public void deleteRule(Integer ruleId);

	/**
	 * 更新规则状态
	 * 
	 * @param rule
	 * @author guolei
	 * @version 1.0
	 * @created 2013-4-18
	 */
	public void updateEnabledRule(TRule rule);

}
