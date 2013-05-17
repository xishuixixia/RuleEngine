<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<script type="text/javascript">

function showSys(){
	var value = $("#meta").val();
	$("#meta_hidden").val(value);
}
</script>

<div class="pageContent">
	<form id="subForm" method="post" action="<%=request.getContextPath()%>/jw/saveSysCourse"
		class="pageForm required-validate"
		onsubmit="return validateCallback(this, dialogAjaxDone);">
		<div class="pageFormContent" layoutH="56">
			<p>
				<label>选择动作类型：</label> 
				<input type="hidden" id="meta_hidden" rel="meta_hidden"/>
				<select name="meta" class="combox required" id="meta" onchange="showSys()">
					<option value="">请选择</option>
					<s:iterator value="list" id = "meta">
						<option value="${meta.id }">${meta.name }</option>
					</s:iterator>
				</select>
			</p>
		</div>
		<div class="formBar">
			<ul>
				<li>
				<a class="button" mask=true lookupGroup="org6" href="<%=request.getContextPath()%>/action/showAddAction?actionMeta.id={meta_hidden}&sceneId=${sceneId }&is_update=${is_update}" width="600" height="300"  title="添加动作"><span>下一步</span></a>
				</li>
				<li>
				</li>
			</ul>
		</div>
	</form>
</div>
