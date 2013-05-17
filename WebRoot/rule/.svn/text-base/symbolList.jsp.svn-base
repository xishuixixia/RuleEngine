<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<form id="pagerForm" action="demo/database/dwzOrgLookup.html">
	<input type="hidden" name="numPerPage" value="${model.numPerPage}" />
	<input type="hidden" name="orderField" value="${param.orderField}" />
	<input type="hidden" name="orderDirection" value="${param.orderDirection}" />
</form>

<div class="pageContent">

	<table class="table" layoutH="50" targetType="dialog" width="100%">
		<thead>
			<tr>
				<th orderfield="orgName" width="100">符号名称</th>
				<th orderfield="orgName" width="100">符号</th>
				<th width="100">选择</th>
			</tr>
		</thead>
		<tbody>
		<tr>
				<td>加</td>
				<td>+</td>
				<td>
					<a class="btnSelect" href="javascript:$.bringBack({orgName:'+',type:'symbol'})" title="查找带回">选择</a>
				</td>
			</tr>
			<tr>
				<td>减</td>
				<td>-</td>
				<td>
					<a class="btnSelect" href="javascript:$.bringBack({orgName:'-',type:'symbol'})" title="查找带回">选择</a>
				</td>
			</tr>
			<tr>
				<td>乘</td>
				<td>*</td>
				<td>
					<a class="btnSelect" href="javascript:$.bringBack({orgName:'*',type:'symbol'})" title="查找带回">选择</a>
				</td>
			</tr>
			<tr>
				<td>除</td>
				<td>/</td>
				<td>
					<a class="btnSelect" href="javascript:$.bringBack({orgName:'/',type:'symbol'})" title="查找带回">选择</a>
				</td>
			</tr>
			<tr>
				<td>等于</td>
				<td>==</td>
				<td>
					<a class="btnSelect" href="javascript:$.bringBack({orgName:'==',type:'symbol'})" title="查找带回">选择</a>
				</td>
			</tr>
			<tr>
				<td>不等于</td>
				<td>!=</td>
				<td>
					<a class="btnSelect" href="javascript:$.bringBack({orgName:'!=',type:'symbol'})" title="查找带回">选择</a>
				</td>
			</tr>
			<tr>
				<td>括号</td>
				<td>()</td>
				<td>
					<a class="btnSelect" href="javascript:$.bringBack({orgName:'( )',type:'symbol'})" title="查找带回">选择</a>
				</td>
			</tr>
			<tr>
				<td>大于</td>
				<td>></td>
				<td>
					<a class="btnSelect" href="javascript:$.bringBack({orgName:'>',type:'symbol'})" title="查找带回">选择</a>
				</td>
			</tr>
			<tr>
				<td>大于等于</td>
				<td>>=</td>
				<td>
					<a class="btnSelect" href="javascript:$.bringBack({orgName:'>=',type:'symbol'})" title="查找带回">选择</a>
				</td>
			</tr>
			<tr>
				<td>小于</td>
				<td><</td>
				<td>
					<a class="btnSelect" href="javascript:$.bringBack({orgName:'<',type:'symbol'})" title="查找带回">选择</a>
				</td>
			</tr>
			<tr>
				<td>小于等于</td>
				<td><=</td>
				<td>
					<a class="btnSelect" href="javascript:$.bringBack({orgName:'<=',type:'symbol'})" title="查找带回">选择</a>
				</td>
			</tr>
			<tr>
				<td>与</td>
				<td>&&</td>
				<td>
					<a class="btnSelect" href="javascript:$.bringBack({orgName:'&&',type:'symbol'})" title="查找带回">选择</a>
				</td>
			</tr>
			<tr>
				<td>或</td>
				<td>||</td>
				<td>
					<a class="btnSelect" href="javascript:$.bringBack({orgName:'||',type:'symbol'})" title="查找带回">选择</a>
				</td>
			</tr>
		</tbody>
	</table>
</div>