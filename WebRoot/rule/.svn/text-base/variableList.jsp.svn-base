<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<form id="pagerForm" action="demo/database/dwzOrgLookup.html">
	<input type="hidden" name="orderDirection" value="${param.orderDirection}" />
</form>

<div class="pageHeader">
	<form rel="pagerForm" method="post" action="demo/database/dwzOrgLookup.html" onsubmit="return dwzSearch(this, 'dialog');">
	<div class="searchBar">
		<ul class="searchContent">
			<li>
				<label>变量名称:</label>
				<input class="textInput" name="variableName" value="" type="text">
			</li>
			<li>
				<label>变量类型:</label>
				<select class="combox" name="type">
					<option value="0">请选择</option>
					<option value="1">字符型</option>
					<option value="2">数字型</option>
					<option value="3">日期型</option>
					<option value="4">动态</option>
				</select>
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
				<th  width="100">变量名称</th>
				<th  width="100">变量类型</th>
				<th  width="150">变量默认值</th>
				<th width="100">选择</th>
			</tr>
		</thead>
		<tbody>
		<s:iterator value="variableList" id="show_variable">
		<tr>
				<td>${show_variable.name }</td>
				<td>
				<s:if test="#show_variable.type == 1">
				字符型
				</s:if>
				<s:if test="#show_variable.type == 2">
				数字型
				</s:if>
					<s:if test="#show_variable.type == 3">
				日期型
				</s:if>
					<s:if test="#show_variable.type == 4">
				动态
				</s:if>
				</td>
				<td>${show_variable.defaultValue }</td>
				<td>
					<a class="btnSelect" href="javascript:$.bringBack({id:'${show_variable.id }', orgName:'${show_variable.defaultValue }',type:'${ 'variable'}${ show_variable.type}'})" title="查找带回">选择</a>
				</td>
			</tr>
		</s:iterator>
		</tbody>
	</table>
</div>