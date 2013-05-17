package com.hxrainbow.rule.operating.dao;

import java.util.List;

import com.hxrainbow.rule.model.Role;

public interface RoleDao {
	List<Role> findList();

	List<Role> findList(String name);
	
	boolean roleNameExist(String name);
	
	boolean save(final Role o);

	Role getRoleById(int id);

	boolean delete(int id);
	
	boolean roleExist(int id);
	
	boolean deleteRoleMenu(int roleId);
	int saveRoleMenu(int menuId,int roleId); 
}
