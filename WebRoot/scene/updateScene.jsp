<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<div class="pageContent">
	<form method="post" action="<%=request.getContextPath()%>/scene/updateScene" class="pageForm required-validate" onsubmit="return validateCallback(this, dialogAjaxDone);">
		<div class="pageFormContent" layoutH="56">
		    <input type="hidden" name="rel" value="${rel}"/>
			<p>			    
				<label>场景名称：</label>
				<input name="scene.id" type="hidden" size="30" value="${scene.id }"/>
				<input name="scene.name" type="text" size="30" alt="请输入场景名称" class="required" value="${scene.name }"/>
			</p>
			<p>
				<label>场景标识名：</label>
				<input name="scene.identify" type="text" readonly="readonly" size="30"  alt="请输入场景标识名" class="required" value="${scene.identify }"/>
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