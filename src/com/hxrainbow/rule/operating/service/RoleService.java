package com.hxrainbow.rule.operating.service;

import java.util.List;

import com.hxrainbow.rule.model.Role;

public interface RoleService {
	List<Role> findList();
	List<Role> findList(String name);
	boolean roleNameExist(String name);
	boolean save(final Role o);
	
	Role getRoleById(int id);
	boolean save(Role o, String oldName);
	
	boolean delete(int id);
	
	boolean deleteRoleMenu(int roleId);
	int saveRoleMenu(String[] menuIds,int roleId); 
	
}
