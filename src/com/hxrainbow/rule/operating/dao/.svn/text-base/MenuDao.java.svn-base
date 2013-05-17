package com.hxrainbow.rule.operating.dao;

import java.util.List;

import com.hxrainbow.rule.model.Menu;
import com.hxrainbow.rule.model.MenuNode;

public interface MenuDao {
	List<Menu> getMenuList(String role);
	List<MenuNode> getRoleMenuList(int id);
	public List<Menu> getMenuChildren();	
    boolean save(final Menu m);
    public void saveMenuRole(String sceneName);       
    public void deleteMenu(String sceneName);
}
