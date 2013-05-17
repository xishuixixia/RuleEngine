<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<form id="pagerForm" action="demo/database/dwzOrgLookup.html">
	<input type="hidden" name="numPerPage" value="${model.numPerPage}" />
	<input type="hidden" name="orderField" value="${param.orderField}" />
	<input type="hidden" name="orderDirection" value="${param.orderDirection}" />
</form>
<div class="pageHeader">
	<form rel="pagerForm" method="post" action="rule/showItemRule?sceneId=${sceneId}&flag=${flag}" onsubmit="return dwzSearch(this, 'dialog');">
	<div class="searchBar">
		<ul class="searchContent">
			<li>
				<label>属性名称:</label>
				<input class="textInput" name="itemName" value="" type="text">
			</li>	  
			<li>
				<label>所属实体:</label>
				<s:select name="entityId" cssClass="combox" list="entityList" listKey="id"  listValue="name" theme="simple"  headerKey="0" headerValue="请选择"/>
			</li>
		</ul>
		<div class="subBar">
			<ul>
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit">查询</button></div></div></li>
			</ul>
		</div>
	</div>
	</form>
</div>
<div class="pageContent">

	<table class="table" layoutH="118" targetType="dialog" width="100%">
		<thead>
			<tr>
				<th width="200">属性名称</th>
				<th width="100">实体名称</th>
				<th  width="200">描述</th>
				<th width="100">选择</th>
			</tr>
		</thead>
		<tbody>
		<s:iterator value="itemList" id="item_entity">
		<tr>
				<td>${item_entity.itemName }</td>
				<td>${item_entity.entityName }</td>
				<td>${item_entity.description }</td>
				<td>
					<a class="btnSelect" href="javascript:$.bringBack({id:'${item_entity.itemId }', orgName:'${item_entity.entityName}${'的' }${item_entity.itemName }',type:'${'condition'}${flag}${itemInput}',variableId:'${variableId}'})" title="查找带回">选择</a>
				</td>
			</tr>
		</s:iterator>
		</tbody>
	</table>
</div>