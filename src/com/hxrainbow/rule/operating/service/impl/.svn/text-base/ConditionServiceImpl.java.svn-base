package com.hxrainbow.rule.operating.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hxrainbow.rule.model.TCondition;
import com.hxrainbow.rule.model.TEntity;
import com.hxrainbow.rule.operating.dao.ConditionDao;
import com.hxrainbow.rule.operating.service.ConditionService;
import com.hxrainbow.rule.util.BasePage;
import com.hxrainbow.rule.util.StringKit;


@Service("conditionService")
@Transactional
public class ConditionServiceImpl implements ConditionService {

	@Resource
	private ConditionDao conditionDao;
	
	/**
	 * 条件查询以及列表
	 */
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	@Override
	public BasePage getPageCondition(BasePage basePage,String conditionName){
		  
		  StringBuffer hql = new StringBuffer("from TCondition where 1=1");
		  if(StringKit.isNotEmpty(conditionName)){
			  hql.append(" and name like '" + conditionName + "'");
		  }
		  basePage.setList(conditionDao.findPageDataByHql(basePage.getPage(), basePage.getPageSize(), hql.toString()));
		  basePage.setRecordNum(conditionDao.findTotalCount(hql.insert(0, "select count(*) ").toString()).intValue());
		  return basePage;
	  }
	/**
	 * 保存条件
	 * 
	 * @param condition 条件实体
	 * @return 0表示实体属性有问题，一般都是未找到
	 * @author guolei
	 * @version 1.0
	 * @created 2013-4-9
	 */
	@Override
	public int saveCondition(TCondition condition,String item,String staticC,String dynamic){
		//做一些逻辑工作，比如前端传来的实体信息
		String desc = condition.getDescription();
		
		//实体属性处理
		List<String> itemList = StringKit.getParamId(desc);
		for(String itemName : itemList){
			Integer itemId = conditionDao.getCondition(condition.getTypeId(),itemName);
			if(itemId == null){
				return 0;
			}else{
				desc.replace(itemName, itemId.toString());
			}
		}
		
		
		conditionDao.saveCondition(condition);
		return 2;
	}
	/**
	 * 根据实体id查询实体
	 * 
	 * @param id
	 * @return
	 * @author guolei
	 * @version 1.0
	 * @created 2013-4-9
	 */
	public TEntity getEntityById(Integer id){
		return conditionDao.getEntityById(id);
	}
	/**
	 * 根据标识名查询实体
	 * 
	 * @param identify
	 * @return
	 * @author guolei
	 * @version 1.0
	 * @created 2013-4-9
	 */
	@Override
	public boolean getSceneByIdentify(String identify){
		
		List<TEntity> list = conditionDao.getSceneByIdentify(identify);
		if(list == null || list.size() == 0){
			return false;
		}else{
			return true;
		}
	}
	/**
	 * 更新实体
	 * 
	 * @param entity
	 * @author guolei
	 * @version 1.0
	 * @created 2013-4-9
	 */
	public void updateEntity(TEntity entity){
		conditionDao.updateEntity(entity);
	}
	
	/**
	 * 删除实体
	 * 
	 * @param id
	 * @author guolei
	 * @version 1.0
	 * @created 2013-4-9
	 */
	@Override
	public void deleteScene(Integer id){
		conditionDao.deleteScene(id);
		conditionDao.deleteSceneEntity(id);
	}
	/**
	 * 得到实体列表
	 * 
	 * @return
	 * @author guolei
	 * @version 1.0
	 * @created 2013-4-11
	 */
	@Override
	public List<TEntity> getEntityList(){
		return conditionDao.getEntityList();
	}
}
