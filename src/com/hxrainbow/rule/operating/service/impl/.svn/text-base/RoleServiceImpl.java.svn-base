package com.hxrainbow.rule.operating.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.hxrainbow.rule.model.Role;
import com.hxrainbow.rule.operating.dao.RoleDao;
import com.hxrainbow.rule.operating.service.RoleService;
@Repository("roleService")
public class RoleServiceImpl implements RoleService {

	@Resource
	private RoleDao roleDao;
	@Override
	public List<Role> findList() {
		return roleDao.findList();
	}
	public RoleDao getRoleDao() {
		return roleDao;
	}
	public void setRoleDao(RoleDao roleDao) {
		this.roleDao = roleDao;
	}
	@Override
	public List<Role> findList(String name) {
		return roleDao.findList(name);
	}
	@Override
	public boolean roleNameExist(String name) {
		if(name==null){
			return false;
		}
		return roleDao.roleNameExist(name);
	}
	@Override
	public boolean save(Role o) {
		
		return save(o,null);
	}
	@Override
	public boolean save(Role o,String oldName) {
		if(o==null){
			return false;
		}
		/*if(o.getId()>0){
			if(o.getName().equals(oldName)){
				roleDao.save(o);
			}else{
				
			}
		}*/
		return roleDao.save(o);
	}
	
	public Role getRoleById(int id){
		return roleDao.getRoleById(id);
	}
	@Override
	public boolean delete(int id) {
		if(id<=0){
			return false;
		}else if(roleDao.roleExist(id)){
			deleteRoleMenu(id);
			return roleDao.delete(id);
		}else{
			return false;
		}
	}
	@Override
	public boolean deleteRoleMenu(int roleId) {
		return roleDao.deleteRoleMenu(roleId);
	}
	@Override
	public int saveRoleMenu(String[] menuIds, int roleId) {
		int i=0;
		if(roleDao.deleteRoleMenu(roleId)){
			for(String menuIdStr:menuIds){
				if(menuIdStr.length()>0){
					int menuId=Integer.parseInt(menuIdStr);
					i+=roleDao.saveRoleMenu(menuId, roleId);
				}
			}
		}
		return i;
	}

	
}
