<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<style type="text/css">
 .home{
 float:right;
 }
</style>
<div class="pageContent">
	<div class="panelBar">
		<ul class="toolBar">			
		</ul>
	</div>
	<table class="table" width="100%" layoutH="138">
		<thead>
			<tr>
			    <th width="30" ><input type="checkbox" class="checkboxCtrl" group="id" /></th>
				<th width="240" orderfield="entityName" >实体名称</th>
				<th width="240" >实体标识名</th>
				<th width="240" >实体包名</th>						
			</tr>
		</thead>
		<tbody>
		
		<s:iterator value="listEntityScene" id="entity">
			<tr target="sid_user" rel="${entity.id }">
			    <td><input type="checkbox" name="entityId" value="{entityIdArr:'${entity.id }',entityName:'${entity.name}'}"/></td>
				<td align="left">${entity.name}</td>
				<td align="left">${entity.identify }</td>
				<td align="left">${entity.packageC }</td>								
			</tr>
		</s:iterator>
			
		</tbody>
	</table>	
	<div class="button home" ><div class="buttonContent"><button  type="button"  multLookup="entityId" warn="请选择实体">选择带回</button></div></div>
	
</div>


