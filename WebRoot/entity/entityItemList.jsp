<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<form id="pagerForm" method="post" action="<%=request.getContextPath()%>/entity/listEntityItem">
	<input type="hidden"  name="pageNum" value="${basePage.page}" />
	<input type="hidden"  name="numPerPage" value="${basePage.pageSize}" />
	<input type="hidden" name="orderField" value="${basePage.orderField}" />
	<input type="hidden" name="orderDirection" value="${basePage.orderField}" />
</form>
<div class="pageHeader">
	<form onsubmit="return navTabSearch(this);" action="<%=request.getContextPath()%>/entity/listEntityItem" method="post" rel="pagerForm">
	<div class="searchBar">
		<table class="searchContent">
			<tr>
				<td>
					实体属性名称：<input type="text" name="entityItemName" value="${requestScope.entityItemName }"/>
				</td>
				<td>
					<input type="hidden" name="typeId" value="${requestScope.typeId}"/>
					<input type="hidden" name="rel" value="${requestScope.rel }"/>
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
			<li><a class="add" href="<%=request.getContextPath()%>/entity/showItem?typeId=${requestScope.typeId}&rel=${requestScope.rel}" target="dialog" title="添加实体属性" mask="true"><span>添加</span></a></li>
			<li><a class="edit" href="<%=request.getContextPath()%>/entity/showEntityItem?entityItem.id={sid_user}&rel=${requestScope.rel}" target="dialog" title="修改实体属性" mask="true"><span>修改</span></a></li>
			<li><a class="delete" href="<%=request.getContextPath()%>/entity/deleteEntityItem?typeId=${requestScope.typeId}&entityItem.id={sid_user}&rel=${requestScope.rel}" target="ajaxTodo" title="确定要删除吗?"><span>删除</span></a></li>
		</ul>
	</div>
	<table class="table" width="100%" layoutH="138">
		<thead>
			<tr>
				<th width="30">序号</th>			   
				<th width="240" align="left">属性字段</th>
				<th width="240" align="left">属性名称</th>
				<th width="240" align="left">属性描述</th>
				<th width="240" align="left">实体</th>									
			</tr>
		</thead>
		<tbody>		
		<s:iterator value="basePage.list" id="item" status="index">
			<tr target="sid_user" rel="${item.id }">	
				<td align="center">${index.index+1}</td>		    
				<td align="left">${item.field}</td>
				<td align="left">${item.name}</td>
				<td align="left">${item.description}</td>
				<td align="left">${item.entity.name}</td>				
			</tr>
		</s:iterator>			
		</tbody>
	</table>
	<div class="panelBar">
		<div class="pagination" targetType="navTab" totalCount="${basePage.recordNum}" numPerPage="${basePage.pageSize}" pageNumShown="10" currentPage="${basePage.page}"></div>
	</div>
</div>
