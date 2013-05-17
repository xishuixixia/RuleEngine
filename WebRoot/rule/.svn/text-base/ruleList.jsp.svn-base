<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<form id="pagerForm" method="post" action="<%=request.getContextPath()%>/rule/listRule">
	<input type="hidden" name="basePage.page" value="1" />
	<input type="hidden" name="sceneId" value="${sceneId }"/>
	<input type="hidden" name="rule.name" value="${rule.name }"/>
	<input type="hidden"  name="pageNum" value="${basePage.page}" />
	<input type="hidden"  name="numPerPage" value="${basePage.pageSize}" />
	<input type="hidden" name="orderField" value="${basePage.orderField}" />
	<input type="hidden" name="orderDirection" value="${basePage.orderField}" />
	<input type="hidden" name="rel" value="${rel}" />
</form>
<div class="pageHeader">
	<form onsubmit="return navTabSearch(this);" action="<%=request.getContextPath()%>/rule/listRule" method="post" rel="pagerForm">
	<div class="searchBar">
		<table class="searchContent">
			<tr>
				<td>
					规则名称：<input type="text" name="rule.name" value="${requestScope.conditionName }"/>
					<input type="hidden" name="sceneId" value="${sceneId }"/>
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
			<li><a class="add" href="<%=request.getContextPath()%>/rule/showAddRule?sceneId=${sceneId}&rel=${rel}" target="navTab" rel="addCondition" title="添加规则" mask="true"><span>添加</span></a></li>
			<li><a class="edit" rel="update_rule" href="<%=request.getContextPath()%>/rule/showUpdateRule?rule.id={sid_user}&sceneId=${sceneId}&rel=${rel}" target="navTab" title="修改规则"><span>修改</span></a></li>
			<li><a class="delete" href="<%=request.getContextPath()%>/rule/deleteRule?rule.id={sid_user}&rel=${rel}" target="ajaxTodo" title="确定要删除吗?"><span>删除</span></a></li>
		</ul>
	</div>
	<table class="table" width="100%" layoutH="138">
		<thead>
			<tr>
				<th width="30">序号</th>
				<th width="200" align="left">规则名称</th>
				<th width="240" align="left">条件</th>
				<th width="200" align="left">动作</th>
				<th width="100" align="left">创建日期</th>
				<th width="100" align="left">是否启用</th>
				<th width="100">操作</th>
			</tr>
		</thead>
		<tbody>
		
		<s:iterator value="basePage.list" id="rule_show" status="index">
			<tr target="sid_user" rel="${rule_show.id }" >
				<td align="center">${index.index+1}</td>
			
				<td align="left"><a href="<%=request.getContextPath()%>/rule/showRule?rule.id=${rule_show.id}" target="navTab" rel="ruleShow" title="规则详情">${rule_show.name}</a></td>
				
				<td align="left">${rule_show.condition }</td>
				<td align="left">${rule_show.action }</td>
				<td align="left"><s:date name="#rule_show.dateEntered"   format="yyyy-MM-dd"/></td>
				<td align="left">
				<s:if test="#rule_show.enabled == 1">启用</s:if>
				<s:if test="#rule_show.enabled == 2">未启用</s:if>
				</td>
				<td align="middle">
				<s:if test="#rule_show.enabled == 1"><a target="ajaxTodo" href="rule/updateEnabledRule?rule.id=${rule_show.id }&rule.enabled=2">停用</a></s:if>
				<s:if test="#rule_show.enabled == 2"><a target="ajaxTodo" href="rule/updateEnabledRule?rule.id=${rule_show.id }&rule.enabled=1">启用</a></s:if>
				</td>
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

