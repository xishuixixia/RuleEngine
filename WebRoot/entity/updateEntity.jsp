<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<div class="pageContent">
	<form method="post" action="<%=request.getContextPath()%>/entity/updateEntity" class="pageForm required-validate" onsubmit="return validateCallback(this, dialogAjaxDone);">
		<input type="hidden" name="rel" value="${rel}"/>
		<div class="pageFormContent" layoutH="56">
			<p>
				<label>实体名称：</label>
				<input name="entity.id" type="hidden" size="30" value="${entity.id }"/>
				<input name="entity.name" type="text" size="30" alt="请输入实体名称" class="required" value="${entity.name }"/>
			</p>
			<p>
				<label>标识名：</label>
				<input name="entity.identify"  readonly="readonly" type="text" size="30"  alt="请输入标识名" class="required lettersonly" value="${entity.identify }"/>
			</p>
			<p>
				<label>包名：</label>
				<input name="entity.packageC"  type="text" size="30"  alt="请输入包名" class="required" value="${entity.packageC }"/>
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