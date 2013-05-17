package com.hxrainbow.rule.operating.service.impl;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.hxrainbow.rule.model.Menu;
import com.hxrainbow.rule.model.MenuNode;
import com.hxrainbow.rule.operating.dao.MenuDao;
import com.hxrainbow.rule.operating.service.MenuService;
@Repository("menuService")
public class MenuServiceImpl implements MenuService {
	@Resource
	private MenuDao menuDao;
	
	@Override
	public List<Menu> getMenuList(String role) {
		Map<Integer,Menu> map=new HashMap<Integer,Menu>();
		List<Menu> oldList=menuDao.getMenuList(role);
		for(Menu m:oldList){
			if(m.getParentId()==0){
				map.put(m.getId(), m);
			}else{
				map.get(m.getParentId()).getChildren().add(m);
			}
		}
		return new LinkedList<Menu>(map.values());
	}

	public MenuDao getMenuDao() {
		return menuDao;
	}

	public void setMenuDao(MenuDao menuDao) {
		this.menuDao = menuDao;
	}

	@Override
	public List<MenuNode> getRoleMenuList(int id) {
		List<MenuNode> list=new LinkedList<MenuNode>();
		List<MenuNode> oldList=menuDao.getRoleMenuList(id);
		for(MenuNode m:oldList){
			
			if(m.getParentId().equals("0")){
				list.add(m);
				//map.put(m.getValue(), m);
			}else{
				for(MenuNode p:list){
					if(p.getValue().equals(m.getParentId())){
						p.addChild(m);
						break;
					}
				}
				//map.get(m.getParentId()).getChildren().add(m);
			}
		}
		
		return list;
	}
	@Override
	public List<Menu> getMenuChildren() {
		Map<Integer,Menu> map=new HashMap<Integer,Menu>();
		List<Menu> oldList=menuDao.getMenuChildren();
		for(Menu m:oldList){			
			map.put(m.getSequence(), m);			
		}
		return new LinkedList<Menu>(map.values());
	}

	@Override
	public boolean save(Menu m) {					
		return save(m);		
	}

	
	
}
