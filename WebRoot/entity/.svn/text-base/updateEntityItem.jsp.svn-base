<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<div class="pageContent">
	<form method="post" action="<%=request.getContextPath()%>/entity/updateEntityItem" class="pageForm required-validate" onsubmit="return validateCallback(this, dialogAjaxDone);">
		<input type="hidden" name="rel" value="${requestScope.rel}"/>
		<div class="pageFormContent" layoutH="56">
			<p>
				<label>属性字段：</label>
				<input name="entityItem.id" type="hidden" size="30" value="${entityItem.id }"/>
				<input name="entityItem.field" type="text" size="30" alt="请输入实体名称" class="required alphanumeric" value="${entityItem.field }"/>
			</p>
			<p>
				<label>属性名称：</label>
				<input name="entityItem.name" type="text" size="30"  alt="请输入属性名称" class="required " value="${entityItem.name }"/>
			</p>
			<p>
				<label>属性描述：</label>				
				<input name="entityItem.description"  type="text" size="30"  alt="请输入属性描述" class="required" />
			</p>
			<p>
				<!-- <label>实体ID：</label> -->
				<input name="entityItem.typeId"  type="hidden" size="30"  alt="请输入包名" class="required" value="${entityItem.typeId }"/>
			</p>
		</div>
		<div class="formBar">
			<ul>
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit">修改</button></div></div></li>
				<li>
					<div class="button"><div class="buttonContent"><button type="button" class="close">取消</button></div></div>
				</li>
			</ul>
		</div>
	</form>
</div>