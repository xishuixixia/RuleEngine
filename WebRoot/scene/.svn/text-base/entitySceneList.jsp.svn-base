<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<script>
function dialogAjax(json){
    $.pdialog.reloadDialog("scene_entity_list");
}
</script>

<div class="pageContent" >
	<%-- <div class="panelBar">
		<ul class="toolBar">
			<li><a class="add" href="<%=request.getContextPath()%>/scene/showAddEntityScene?sceneId=${requestScope.sceneId }&rel=${requestScope.rel}" target="dialog" rel="addEntiyScene" title="添加场景实体" mask="true"><span>添加</span></a></li>
		    <li><a class="delete" href="<%=request.getContextPath()%>/scene/deleteEntiyScene?sceneId=${requestScope.sceneId }&entityId={sid_user}" callback="dialogAjax" target="ajaxTodo" title="确定要删除吗?"><span>删除</span></a></li>
		</ul>
	</div> --%>
	<form method="post" action="<%=request.getContextPath()%>/scene/saveEntityList" class="pageForm required-validate" onsubmit="return validateCallback(this, dialogAjaxDone);">
	<input type="hidden" name="sceneId" value="${sceneId }" />
	<div style="float: left; display: block; margin: 10px; overflow: auto; width: 370px; height: 200px; border: solid 1px #CCC; line-height: 21px; background: #FFF;">

	
	<table class="table" width="100%" height="200">
		<thead>
			<tr>	
				<th width="30"><input type="checkbox" class="checkboxCtrl"
					group="id" /></th>		   
				<th width="240" align="left">实体名称</th>
				<th width="240" align="left">实体包名称</th>
				<th width="240" align="left">实体标识</th>				
			</tr>
		</thead>
		<tbody>
		   <s:iterator value="entityList" id="entity">
			<tr target="sid_user" rel="${entity.id }">	
				<td><input type="checkbox" name="entityIds"
						value="${entity.id }" <s:if test="checked">checked</s:if> /></td>		    
				<td align="left">${entity.name}</td>	
				<td align="left">${entity.packageC}</td>
				<td align="left">${entity.identify}</td>							
			</tr>
		</s:iterator>			
		</tbody>
	</table>
	</div>
	
	<div class="formBar">
			<ul>
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit">保存</button></div></div></li>
				<li>
					<div class="button"><div class="buttonContent"><button type="button" class="close">取消</button></div></div>
				</li>
			</ul>
		</div>
</form>	
</div>

