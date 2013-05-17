<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<form id="pagerForm" action="demo/database/dwzOrgLookup.html">
	<input type="hidden" name="numPerPage" value="${model.numPerPage}" />
	<input type="hidden" name="orderField" value="${param.orderField}" />
	<input type="hidden" name="orderDirection" value="${param.orderDirection}" />
</form>

<div class="pageHeader">
	<form rel="pagerForm" method="post" action="demo/database/dwzOrgLookup.html" onsubmit="return dwzSearch(this, 'dialog');">
	<div class="searchBar">
		<ul class="searchContent">
			<li>
				<label>属性名称:</label>
				<input class="textInput" name="orgName" value="" type="text">
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
				<th orderfield="orgName" width="100">属性名称</th>
				<th width="100">选择</th>
			</tr>
		</thead>
		<tbody>
		<s:iterator value="itemList" id="item_entity">
		<tr>
				<td>${item_entity.name }</td>
				<td>
					<a class="btnSelect" href="javascript:$.bringBack({id:'${item_entity.id }', orgName:'${item_entity.name }',type:'condition'})" title="查找带回">选择</a>
				</td>
			</tr>
		</s:iterator>
		</tbody>
	</table>
</div>