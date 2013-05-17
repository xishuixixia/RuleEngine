package com.hxrainbow.rule.operating.service.impl;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hxrainbow.rule.model.TEntityItem;
import com.hxrainbow.rule.operating.dao.EntityItemDao;
import com.hxrainbow.rule.operating.service.EntityItemService;
import com.hxrainbow.rule.util.BasePage;
import com.hxrainbow.rule.util.StringKit;
@Service("entityItemService")
@Transactional
public class EntityItemServiceImpl implements EntityItemService{
	@Resource
	private EntityItemDao entityItemDao;
	
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	@Override
	public BasePage getPageEntityItem(BasePage basePage, String entityItemName,Integer typeId) {
		StringBuilder hql=new StringBuilder("from TEntityItem where typeId = " + typeId );
		StringBuilder countSql = new StringBuilder(
				"select count(t) from TEntityItem t where typeId = " + typeId);
		if(StringKit.isNotEmpty(entityItemName)){
			  hql.append(" and name like '" + entityItemName + "'");
			  countSql.append(" and name like '" + entityItemName + "'");
		  }
		basePage.setList(entityItemDao.findPageDataByHql(basePage.getPage(), basePage.getPageSize(), hql.toString()));
		basePage.setRecordNum(entityItemDao.findTotalCount(hql.insert(0, "select count(*) ").toString()).intValue());	
		
		return basePage;
	}
    /**
     * 保存实体
     */
	@Override
	public void saveEntityItem(TEntityItem entityItem) {
		entityItemDao.saveEntityItem(entityItem);
	}
    /**
     * 根据id查询实体属性
     */
	@Override
	public TEntityItem getEntityItemById(Integer id) {
		return entityItemDao.getEntityItemById(id);
	}
	/**
	 * 根据实体id查询实体属性
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public List getEntityByTypeId(Integer typeId) {
		List<TEntityItem> list = entityItemDao.getEntityItemByTypeId(typeId);
		return list;
		
	}
    /**
     * 更新实体属性
     */
	@Override
	public void updateEntityItem(TEntityItem entityItem) {
		entityItemDao.updateEntityItem(entityItem);
		
	}
    /**
     * 删除实体属性
     */
	@Override
	public void deleteEntityItem(Integer id) {
		entityItemDao.deleteEntityItem(id);
	}
	/**
	 * 
	 * 根据实体类型查找实体属性或者根据实体类型和实体名称查找实体
	 * @param entityItemName
	 * @param typeId
	 * @return
	 * @author guolei
	 * @version 1.0
	 * @created 2013-4-15
	 */
	@SuppressWarnings("unchecked")
	public List<HashMap<String,String>> listEntityItem(String entityItemName, Integer typeId,Integer sceneId){
		StringBuffer hql=new StringBuffer("select new map(entity.name as entityName,item.name as itemName,item.description as description,item.id as itemId) from TEntityItem item,TEntity entity,TSceneEntity middle where middle.entityId = entity.id and entity.id = item.typeId");
		if(StringKit.isNotEmpty(entityItemName)){
			  hql.append(" and item.name like '" + entityItemName + "'");
		}
		if(typeId != null && typeId != 0){
			hql.append(" and item.typeId = " + typeId);
		}
		if(sceneId != null && sceneId != 0){
			hql.append(" and middle.sceneId = " + sceneId);
		}
		List<HashMap<String,String>> list = entityItemDao.findDataByHql(hql.toString());
		return list;
	}
	@Override
	public Long getEntityItemCount(Integer typeId) {
		
		return entityItemDao.getEntityItemCount(typeId);
	}

}
