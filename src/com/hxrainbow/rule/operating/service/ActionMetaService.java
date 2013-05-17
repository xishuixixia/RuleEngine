package com.hxrainbow.rule.operating.service;

import java.util.List;

import com.hxrainbow.rule.model.TActionMeta;
import com.hxrainbow.rule.model.TActionMetaVariable;

import com.hxrainbow.rule.util.BasePage;

public interface ActionMetaService {
	/**
	 * 根据页数列出系统中的实体
	 * @param basePage
	 * @param actionMetaName
	 * @return
	 */
	public BasePage getPageActionMeta(BasePage basePage,String actionMetaName);
	/**
	 * 保存动作类型
	 * @param actionMeta
	 */
	public void saveActionMeta(TActionMeta actionMeta,List<String> variable);
	/**
	 * 根据id查询动作类型
	 * @param id
	 * @return
	 */
	public TActionMeta getActionMetaById(Integer id);
	/**
	 * 更新动作类型
	 * @param actionMeta
	 */
	public void updateActionMeta(TActionMeta actionMeta,List<String> variable);
	/**
	 * 根据id删除动作类型
	 * @param id
	 */
	public void deleteActionMeta(Integer id);

	/**
	 * 在条件部分添加动作时展示所有的动作类型
	 * 
	 * @return
	 * @author guolei
	 * @version 1.0
	 * @created 2013-4-16
	 */
	public List<TActionMeta> getActionMetaList();
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
	
}
