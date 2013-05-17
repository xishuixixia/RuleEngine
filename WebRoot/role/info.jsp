<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<div class="pageContent">
	<form method="post" action="<%=request.getContextPath()%>/role/save" class="pageForm required-validate" onsubmit="return validateCallback(this, dialogAjaxDone);">
		<input type="hidden" name="role.id" value="${role.id}">
		<input type="hidden" name="oldName" value="${role.name}">
		<input type="hidden" name="rel" value="${rel}">
		<div class="pageFormContent" layoutH="56">
			<p>
				<label>名称：</label>
				<input name="role.name" type="text" size="30" alt="请输入名称" class="required" value="${role.name}" />
			</p>
			<p>
				<label>描述：</label>
				<input name="role.description"  type="text" size="30"  alt="请输入描述" class="required" value="${role.description}" />
			</p>
			
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