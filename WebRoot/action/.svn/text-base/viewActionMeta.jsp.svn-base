<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<style>
.lose{
float:right;margin-right:80px;margin-top: -10px
}
</style>
<div class="pageContent">
		<div id="show" class="pageFormContent" layoutH="56">
		    <input type="hidden" name="rel" value="${rel}"/>
			<p>
				<label>动作类型名称：</label>
				${actionMeta.name }
			</p>
			<p>
				<label>动作类型实现类：</label>
				${actionMeta.methodC }
			</p>
			<p>
				<label>描述：</label>
				${actionMeta.description}
			</p>
			<s:iterator value="variableList" id="variable_show" status="st">
			<fieldset>
				<p>
					<label>变量标签：</label>
					${variable_show.name }
				</p>
				<p>
					<label>变量标识：</label>
					${variable_show.identify }
				</p>
			</fieldset>
			</s:iterator>
		</div>
</div>