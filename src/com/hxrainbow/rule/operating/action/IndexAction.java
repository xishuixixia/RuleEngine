package com.hxrainbow.rule.operating.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.hxrainbow.rule.model.Menu;
import com.hxrainbow.rule.operating.service.MenuService;
import com.opensymphony.xwork2.ActionContext;
@Controller
@Scope("prototype")
public class IndexAction extends BaseAction{

	private static final long serialVersionUID = 1L;
	
	@Resource
	private MenuService menuService;

	public MenuService getMenuService() {
		return menuService;
	}

	public void setMenuService(MenuService menuService) {
		this.menuService = menuService;
	}
	
	
	public String execute(){
		String role="sa";
		List<Menu> list=menuService.getMenuList(role);
		ActionContext.getContext().put("menus", list);
		return SUCCESS;
	}
	

}
