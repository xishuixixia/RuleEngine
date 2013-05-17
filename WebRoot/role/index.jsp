<%@ page language="java" import="java.util.*,com.hxrainbow.rule.util.BasePage" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<form id="pagerForm" method="post" action="<%=request.getContextPath()%>/role/list">
	<input type="hidden"  name="pageNum" value="1" />
	<input type="hidden"  name="numPerPage" value="100" />
	<input type="hidden" name="orderField" value="${basePage.orderField}" />
	<input type="hidden" name="orderDirection" value="${basePage.orderField}" />
</form>
<div class="pageHeader">
	<form onsubmit="return navTabSearch(this);" action="<%=request.getContextPath()%>/role/list" method="post" rel="pagerForm">
	
	<div class="searchBar">
		<table class="searchContent">
			<tr>
				<td>
					名称：<input type="text" name="role.name" value="${role.name}"/>
				</td>
			</tr>
		</table>
		<div class="subBar">
			<ul>
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit">检索</button></div></div></li>																			
			</ul>
		</div>
	</div>
	</form>
</div>
<div class="pageContent">
	<div class="panelBar">
		<ul class="toolBar">
			<li><a class="add" href="<%=request.getContextPath()%>/role/add?rel=${requestScope.rel}" target="dialog"  title="添加角色" mask="true"><span>添加</span></a></li>
			<li><a class="edit" href="<%=request.getContextPath()%>/role/get?role.id={sid_role}&rel=${requestScope.rel}" target="dialog" title="修改角色" ><span>修改</span></a></li>
			<li><a class="delete" href="<%=request.getContextPath()%>/role/del?role.id={sid_role}&rel=${requestScope.rel}" target="ajaxTodo" title="确定要删除吗?"><span>删除</span></a></li>
		</ul>
	</div>
	<table class="table" width="100%" layoutH="138">
		<thead>
			<tr>							    
				<th width="30">序号</th>
				<th width="240"  align="left">名称</th>
				<th width="240" align="left" >描述</th>
				<th width="240" align="left">操作</th>
			</tr>
		</thead>
		<tbody>
		
		<s:iterator value="roles" id="r" status="index">
			<tr target="sid_role" height="25" rel="${r.id}">							  
				<td align="center">${index.index+1}</td>
				<td align="left">${r.name}</td>
				<td align="left">${r.description}</td>
				<td align="left">
				<a class="btnEdit" href="<%=request.getContextPath()%>/role/get?role.id=${r.id}&rel=${requestScope.rel}" target="dialog" title="修改角色" ><span>修改</span></a>
				<a class="btnDel"  href="<%=request.getContextPath()%>/role/del?role.id=${r.id}&rel=${requestScope.rel}" target="ajaxTodo" title="确定要删除吗?"><span>删除</span></a>
				<a class="btnSelect"  href="<%=request.getContextPath()%>/role/menu?rel=${requestScope.rel }&role.id=${r.id}" width="405" height="300" target="dialog"  title="角色[${r.name}]权限设置"><span>权限</span></a>
				</td>
			</tr>
		</s:iterator>
			
		</tbody>
	</table>
	<div class="panelBar">
		
		<div class="pagination" targetType="navTab" totalCount="${basePage.recordNum}" numPerPage="${basePage.pageSize}" pageNumShown="${basePage.pageSize}" currentPage="${basePage.page}"></div>
	</div>
</div>
