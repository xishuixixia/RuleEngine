package com.hxrainbow.rule.operating.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hxrainbow.rule.model.TActionMeta;
import com.hxrainbow.rule.model.TActionMetaVariable;
import com.hxrainbow.rule.operating.dao.ActionMetaDao;

import com.hxrainbow.rule.operating.service.ActionMetaService;
import com.hxrainbow.rule.util.BasePage;
import com.hxrainbow.rule.util.StringKit;
@Service("actionMetaService")
@Transactional
public class ActionMetaServiceImpl implements ActionMetaService{
    
	@Resource
	private ActionMetaDao actionMetaDao;
	
	
	@Transactional(propagation=Propagation.NOT_SUPPORTED,readOnly=true)
	@Override
	public BasePage getPageActionMeta(BasePage basePage, String actionMetaName) {
		StringBuffer hql = new StringBuffer("from TActionMeta where 1=1");
		  if(StringKit.isNotEmpty(actionMetaName)){
			  hql.append(" and name like '" + actionMetaName + "'");
		  }
		  basePage.setList(actionMetaDao.findPageDataByHql(basePage.getPage(), basePage.getPageSize(), hql.toString()));
		  basePage.setRecordNum(actionMetaDao.findTotalCount(hql.insert(0, "select count(*) ").toString()).intValue());
		  return basePage;
	}
    /**
     * 保存动作类型
     */
	@Override
	public void saveActionMeta(TActionMeta actionMeta,List<String> variableList) {
		Integer id =  actionMetaDao.saveActionMeta(actionMeta);
		for(String ids : variableList){
			String[] idArr = ids.split(",");
			TActionMetaVariable variable = new TActionMetaVariable();
			variable.setName(idArr[0]);
			variable.setIdentify(idArr[1]);
			variable.setActionMetaId(id);
			actionMetaDao.saveActionMetaVariable(variable);
		}
	}
    /**
     * 根据id查询动作类型
     */
	@Transactional(propagation=Propagation.NOT_SUPPORTED,readOnly=true)
	@Override
	public TActionMeta getActionMetaById(Integer id) {
		return actionMetaDao.getActionMetaById(id);
	}
    /**
     * 更新动作类型
     */
	@Override
	public void updateActionMeta(TActionMeta actionMeta,List<String> variableList) {
		actionMetaDao.updateActionMeta(actionMeta);	
		Integer id = actionMeta.getId();
		actionMetaDao.deleteActionMetaVariable(id);
		for(String ids : variableList){
			String[] idArr = ids.split(",");
			TActionMetaVariable variable = new TActionMetaVariable();
			variable.setName(idArr[0]);
			variable.setIdentify(idArr[1]);
			variable.setActionMetaId(id);
			actionMetaDao.saveActionMetaVariable(variable);
		}
		
	}
    /**
     * 根据id删除动作类型
     */
	@Override
	public void deleteActionMeta(Integer id) {
		actionMetaDao.deleteActionMeta(id);
	}
	/**
	 * 在条件部分添加动作时展示所有的动作类型
	 * 
	 * @return
	 * @author guolei
	 * @version 1.0
	 * @created 2013-4-16
	 */
	@SuppressWarnings("unchecked")
	@Transactional(propagation=Propagation.NOT_SUPPORTED,readOnly=true)
	@Override
	public List<TActionMeta> getActionMetaList(){
		String hql = "from TActionMeta";
		return actionMetaDao.findDataByHql(hql);
	}
	/**
	 * 查看动作类型变量
	 * 
	 * @param id
	 * @return
	 * @author guolei
	 * @version 1.0
	 * @created 2013-4-23
	 */
	@Transactional(propagation=Propagation.NOT_SUPPORTED,readOnly=true)
	@Override
	public List<TActionMetaVariable> getActionMetaVariableById(Integer id){
		return actionMetaDao.getActionMetaVariableById(id);
	}
}
