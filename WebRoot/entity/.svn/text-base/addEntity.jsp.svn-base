<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<div class="pageContent">
	<form method="post" action="<%=request.getContextPath()%>/entity/addEntity" class="pageForm required-validate" onsubmit="return validateCallback(this, dialogAjaxDone);">
		<input type="hidden" name="rel" value="<%=request.getParameter("rel")%>">
		<div class="pageFormContent" layoutH="56">
			<p>
				<label>实体名称：</label>
				<input name="entity.name" type="text" size="30" alt="请输入实体名称" class="required" />
			</p>
			<p>
				<label>标识名：</label>
				<input name="entity.identify"  type="text" size="30"  alt="请输入标识名" class="required lettersonly" />
			</p>
			<p>
				<label>包名：</label>
				<input name="entity.packageC"  type="text" size="30"  alt="请输入包名" class="required" />
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