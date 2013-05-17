<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<form id="pagerForm" method="post" action="<%=request.getContextPath()%>/entity/listEntity">
	<input type="hidden" name="basePage.page" value="1" />
</form>
<div class="pageHeader">
	<form onsubmit="return navTabSearch(this);" action="<%=request.getContextPath()%>/entity/listEntity" method="post" rel="pagerForm">
	<div class="searchBar">
		<table class="searchContent">
			<tr>
				<td>
					条件名称：<input type="text" name="conditionName" value="${requestScope.conditionName }"/>
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
			<li><a class="add" href="<%=request.getContextPath()%>/condition/showAddCondition" target="navTab" rel="addCondition" title="添加条件" mask="true"><span>添加</span></a></li>
			<li><a class="edit" href="<%=request.getContextPath()%>/condition/showEntity?entity.id={sid_user}" target="dialog" title="修改实体" mask="true"><span>修改</span></a></li>
			<li><a class="delete" href="<%=request.getContextPath()%>/condition/deleteEntity?entity.id={sid_user}" target="ajaxTodo" title="确定要删除吗?"><span>删除</span></a></li>
		</ul>
	</div>
	<table class="table" width="100%" layoutH="138">
		<thead>
			<tr>
				<th width="240">条件名称</th>
				<th width="240">创建日期</th>
				<th width="240">条件类型</th>
				<th width="240">条件描述</th>
			</tr>
		</thead>
		<tbody>
		
		<s:iterator value="basePage.list" id="condition_show">
			<tr target="sid_user" rel="${condition_show.id }">
				<td align="left">${condition_show.name}</td>
				<td align="left"><s:date name="#condition_show.dateEntered"   format="yyyy-MM-dd HH:mm:ss"/></td>
				<td align="left">${condition_show.typeId }</td>
				<td align="left">${condition_show.description }</td>
			</tr>
		</s:iterator>
		</tbody>
	</table>
	<div class="panelBar">
		<div class="pagination" targetType="navTab" totalCount="${basePage.recordNum}" numPerPage="${basePage.pageSize}" pageNumShown="10" currentPage="${basePage.page}"></div>
	</div>
</div>
