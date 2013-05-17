<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<form id="pagerForm" method="post" action="<%=request.getContextPath()%>/scene/listScene">
	<input type="hidden"  name="pageNum" value="${basePage.page}" />
	<input type="hidden"  name="numPerPage" value="${basePage.pageSize}" />
	<input type="hidden" name="orderField" value="${basePage.orderField}" />
	<input type="hidden" name="orderDirection" value="${basePage.orderField}" />
</form>
<div class="pageHeader">
	<form onsubmit="return navTabSearch(this);" action="<%=request.getContextPath()%>/scene/listScene" method="post" rel="pagerForm">
	<div class="searchBar">
		<table class="searchContent">
			<tr>
				<td>
					场景名称：<input type="text" name="sceneName" value="${requestScope.sceneName }"/>
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
			<li><a class="add" href="<%=request.getContextPath()%>/scene/addScene.jsp?rel=${rel}" target="dialog" rel="addScene" title="添加场景" mask="true"><span>添加</span></a></li>
			<li><a class="edit" href="<%=request.getContextPath()%>/scene/showScene?sceneId={sid_user}&rel=${rel}" target="dialog" title="修改场景" mask="true"><span>修改</span></a></li>
			<li><a class="delete" href="<%=request.getContextPath()%>/scene/deleteScene?sceneId={sid_user}&rel=${rel}" target="ajaxTodo" title="确定要删除吗?"><span>删除</span></a></li>
		</ul>
	</div>
	<table class="table" width="100%" layoutH="138">
		<thead>
			<tr>
				<th width="30">序号</th>
				<th width="240" align="left">场景名称</th>
				<th width="240" align="left">场景标识名</th>
				<th width="240" align="center">操作</th>
			</tr>
		</thead>
		<tbody>
		
		<s:iterator value="basePage.list" id="scene" status="index">
			<tr target="sid_user" rel="${scene.id }">
				<td align="center">${index.index+1}</td>
				<td align="left">${scene.name}</td>
				<td align="left">${scene.identify }</td>
				<td align="center"><a  href="<%=request.getContextPath()%>/scene/listEntityOfScene?rel=listEntityOfScene&sceneId=${scene.id}" width="405" height="300" mask="false" target="dialog" rel="scene_entity_list" title="场景[${scene.name}]实体">关联实体</a></td>
			</tr>
		</s:iterator>
			
		</tbody>
	</table>
	<div class="panelBar">
		<div class="pages">
			<span>显示</span>
			<select class="combox" name='numPerPage' onchange="navTabPageBreak({numPerPage:this.value})">
				<%
					int[] nums={10,15,20,30,40};
					for(int n:nums){
						 out.println("<option value='"+n+"' ");
						 com.hxrainbow.rule.util.BasePage bp=(com.hxrainbow.rule.util.BasePage)request.getAttribute("basePage");
						 if(bp.getPageSize()==n){
							 out.println(" selected");
						 }
						 out.println(">"+n+"</option>");
						
					}
				%>

				
				
			</select>
			<span>条，共${basePage.recordNum}条</span>
		</div>
		<div class="pagination" targetType="navTab" totalCount="${basePage.recordNum}" numPerPage="${basePage.pageSize}" pageNumShown="${basePage.pageSize }" currentPage="${basePage.page}"></div>
	</div>
</div>
