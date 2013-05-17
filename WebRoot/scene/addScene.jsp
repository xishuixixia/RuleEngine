<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<div class="pageContent">
	<form method="post" action="<%=request.getContextPath()%>/scene/addScene" class="pageForm required-validate" onsubmit="return validateCallback(this, dialogAjaxDone);">
		<div class="pageFormContent" layoutH="56">
		   <input type="hidden" name="rel" value="<%=request.getParameter("rel")%>">
			<p>
				<label>场景名称：</label>
				<input name="scene.name" type="text" size="30" alt="请输入场景名称" class="required" />
			</p>
			<p>
				<label>场景标识：</label>
				<input name="scene.identify"  type="text" size="30"  alt="请输入场景标识名" class="required lettersonly" />
			</p>
			<p>
				<label>关联实体：</label>
								
				<input name="sceneEntity.entityIdArr" type="hidden" size="30" value="${sceneEntity.entityId}"/>
				<input name="sceneEntity.entityName" type="text" size="30" value="${sceneEntity.entityName}"/>
				<a class="btnLook" href="scene/listEntityScene" lookupGroup="sceneEntity"  width="405" height="300">查找带回实体</a>
				
						
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