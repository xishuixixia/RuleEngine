package com.hxrainbow.rule.operating.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hxrainbow.rule.model.TEntity;
import com.hxrainbow.rule.operating.dao.EntityDao;
import com.hxrainbow.rule.operating.service.EntityService;
import com.hxrainbow.rule.util.BasePage;
import com.hxrainbow.rule.util.StringKit;

@Service("entityService")
@Transactional
public class EntityServiceImpl implements EntityService {

	@Resource
	private EntityDao entityDao;

	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	@Override
	public BasePage getPageEntity(BasePage basePage, String entityName) {
		StringBuilder hql = new StringBuilder("from TEntity where 1=1");
		StringBuilder countSql = new StringBuilder(
				"select count(t) from TEntity t where 1=1");
		if (StringKit.isNotEmpty(entityName)) {
			hql.append("where name like '");
			hql.append(entityName);
			hql.append("'");
			countSql.append("where t.name like '");
			countSql.append(entityName);
			countSql.append("'");
		}
		basePage.setList(entityDao.findPageDataByHql(basePage.getPage(),
				basePage.getPageSize(), hql.toString()));

		basePage.setRecordNum(entityDao.findTotalCount(countSql.toString())
				.intValue());
		return basePage;
	}

	/**
	 * 保存实体
	 * 
	 * @param entity
	 * @return
	 * @author guolei
	 * @version 1.0
	 * @created 2013-4-9
	 */
	@Override
	public void saveEntity(TEntity entity) {
		entityDao.saveEntity(entity);
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
	public TEntity getEntityById(Integer id) {
		return entityDao.getEntityById(id);
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
	public boolean getEntityByIdentify(String identify) {
		List<TEntity> list = entityDao.getEntityByIdentify(identify);
		if (list == null || list.size() == 0) {
			return false;
		} else {
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
	public void updateEntity(TEntity entity) {
		entityDao.updateEntity(entity);
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
	public void deleteEntity(Integer id) {
		entityDao.deleteEntity(id);
	}
}
