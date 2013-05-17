<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery.textbox.js"></script>

<script type="text/javascript">
function setType(){
	var value = $("#typeId").val();
	$("#type_hidden").val(value);
}
</script>


<h2 class="contentTitle">添加条件</h2>
<div class="pageContent">
	<form method="post" action="condition/addCondition" class="pageForm required-validate" onsubmit="return validateCallback(this)">
		<div class="pageFormContent nowrap" layoutH="97">
			<dl>
				<dt>条件名称：</dt>
				<dd>
					<input name="condition.name" type="text" size="30" alt="请输入实体名称" class="required" />
				</dd>
			</dl>
			<dl>
				<dt>条件类型：</dt>
				<dd>
					<select class="required combox" name="condition.typeId" onchange="setType()" id="typeId">
							<option value="">请选择</option>
							<s:iterator value="entityList" id="entity_show">
					   			<option value="${entity_show.id }">${entity_show.name }</option>
							</s:iterator>
					</select>
					<input type="hidden" id="type_hidden" rel="type_hidden"/>
				</dd>
			</dl>
			<dl>
				<dt>&nbsp;&nbsp;&nbsp;&nbsp;</dt>
				<dd>
					<a class="button" href="entity/listItem?typeId={type_hidden}" lookupGroup="org1" width="500" height="300"><span>属性</span></a>
					<a class="button" href="variable/listVariable" lookupGroup="org2" width="650" height="400"><span>变量</span></a>
					<a class="button" href="condition/symbolList.jsp" lookupGroup="org3" width="500" height="400"><span>符号</span></a>
				</dd>
			</dl>
			<dl>
				<dt>条件内容：</dt>
				<dd>
					<textarea id="content" rows="6" cols="60" spellcheck="false" autocomplete="off" name="condition.describeC" alt="请输入条件内容"></textarea>
					<input type="hidden" name="item" id="item">
					<input type="hidden" name="static" id="staticC">
					<input type="hidden" name="dynamic" id="dynamic">
				</dd>
			</dl>
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