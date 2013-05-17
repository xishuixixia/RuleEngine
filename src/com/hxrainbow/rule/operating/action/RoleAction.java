package com.hxrainbow.rule.operating.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.hxrainbow.rule.model.MenuNode;
import com.hxrainbow.rule.model.Role;
import com.hxrainbow.rule.operating.service.MenuService;
import com.hxrainbow.rule.operating.service.RoleService;
import com.hxrainbow.rule.util.Result;
import com.opensymphony.xwork2.ActionContext;

@Repository("roleAction")
@Scope("prototype")
public class RoleAction extends BaseAction {

	private static final long serialVersionUID = 1L;
	
	private Role role=new Role();
	
	private String oldName;
	
	private String menuIds;
	private int roleId;
	
	private String node;
	
	public void setNode(String node) {
		this.node = node;
	}
	public String getOldName() {
		return oldName;
	}
	public void setOldName(String oldName) {
		this.oldName = oldName;
	}

	@Resource
	private RoleService roleService;
	@Resource
	private MenuService menuService;
	
	public MenuService getMenuService() {
		return menuService;
	}
	public void setMenuService(MenuService menuService) {
		this.menuService = menuService;
	}
	public String save() throws Exception{
		Result r=new Result();
		if(role==null){
			r.setStatusCode("300");
			r.setMessage("请输入数据！");
			return json(r);
		}
		if(role.getId()==0){
			if(!roleService.roleNameExist(role.getName())){
				boolean success=roleService.save(role,oldName);
				if(success){
					r.setStatusCode("200");
					r.setMessage("添加角色成功！");
					r.setCallbackType("closeCurrent");
					
				}else{
					r.setStatusCode("300");
					r.setMessage("添加角色失败！");
					r.setCallbackType("");
				}
				r.setNavTabId(rel);
				
			}else{
				r.setStatusCode("300");
				r.setMessage("角色名称已经存在，请重新填写！");
				r.setCallbackType("");
				r.setNavTabId(rel);
			}
		}else{
			if(oldName!=null){
				if(oldName.equals(role.getName())){
					roleService.save(role);
				}else if(!roleService.roleNameExist(role.getName())){
					if(roleService.save(role)){
						r.setStatusCode("200");
						r.setMessage("修改角色成功！");
						r.setCallbackType("closeCurrent");
					}else{
						r.setMessage("修改角色失败！");
						r.setStatusCode("300");
						r.setCallbackType("");
					}
				}else{
					r.setStatusCode("300");
					r.setMessage("角色名称已经存在，请重新填写！");
					r.setCallbackType("");
				}
			}
		}
		r.setNavTabId(rel);
		return json(r);
	}
	public String add(){
		return SUCCESS;
	}
	
	public String menu(){
		List<MenuNode> list=menuService.getRoleMenuList(role.getId());
		ActionContext.getContext().put("nodes", list);
		return SUCCESS;
	}
	
	public String right() throws Exception{
		Result r=new Result();
		if(menuIds!=null){
			String[] idsStr=menuIds.split(",");
			int num=roleService.saveRoleMenu(idsStr, roleId);
			
			if(num>0){
				r.setMessage("角色权限设置成功！");
				r.setStatusCode("200");
				r.setCallbackType("");
			}else{
				r.setMessage("角色权限设置失败！");
				r.setStatusCode("300");
				r.setCallbackType("");
			}
		}
		return json(r);
	}
	public String get(){
		role=roleService.getRoleById(role.getId());
		return SUCCESS;
	}
	public String del() throws Exception{
		Result r=new Result();
		r.setNavTabId(rel);
		if(role==null){
			r.setStatusCode("300");
			r.setCallbackType("");
			
			r.setMessage("删除角色失败！");
		}else{
			if(role.getId()==0){
				r.setStatusCode("300");
				r.setCallbackType("");
				r.setMessage("删除角色失败！");
			}else{
				if(roleService.delete(role.getId())){
					r.setStatusCode("200");
					r.setCallbackType("");
					r.setMessage("删除角色成功！");
				}else{
					r.setStatusCode("300");
					r.setCallbackType("");
					r.setMessage("删除角色失败！角色可能不存在！");
				}
			}
		}
		return json(r);
	}
	public String execute(){
		List<Role> roles=null;
		if(role!=null&&role.getName()!=null){
			roles=roleService.findList(role.getName());
		}else{
			roles=roleService.findList();
		}
		ActionContext ctx=ActionContext.getContext();
		ctx.put("roles", roles);
		return SUCCESS;
	}

	public RoleService getRoleService() {
		return roleService;
	}

	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	public void setMenuIds(String menuIds) {
		this.menuIds = menuIds;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	
	
	
}
