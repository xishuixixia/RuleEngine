<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery.textbox.js"></script>

<script type="text/javascript">
function setType(){
	var value = $("#typeId").val();
	$("#type_hidden").val(value);
}
function deleteDiv(my){
	
	 $(my).parent().parent().remove();
}
</script>


<h2 class="contentTitle">添加规则</h2>
<div class="pageContent">
	<form method="post" action="rule/addRule" class="pageForm required-validate" onsubmit="return validateCallback(this,navTabAjaxDone)">
		<div class="pageFormContent nowrap" layoutH="97">
			<dl>
				<dt>规则名称：</dt>
				<dd>
					<input name="rule.name" type="text" size="30" alt="请输入规则名称" class="required" />
					<input name="rule.sceneId" type="hidden" value="${sceneId }"/>
					<input name="rel" type="hidden" value="${rel }"/>
				</dd>
			</dl>
			<dl>
				<dt>立即启用：</dt>
				<dd>
					<select name="rule.enabled" class="combox">
						<option value="1">启用</option>
						<option value="2">不启用</option>
					</select>
				</dd>
			</dl>
			<dl>
				<dt>开始时间：</dt>
				<dd>
					<input type="text" name="rule.begin"  class="date" readonly="true"/>
					<a class="inputDateButton" href="javascript:;">选择</a>
				</dd>
			</dl>
			<dl>
				<dt>结束时间：</dt>
				<dd>
					<input type="text" name="rule.end" class="date" readonly="true"/>
					<a class="inputDateButton" href="javascript:;">选择</a>
				</dd>
			</dl>
			<dl>
				<dt>&nbsp;&nbsp;&nbsp;&nbsp;</dt>
				<dd>
					<a class="button" href="rule/showItemRule?sceneId=${sceneId }&flag=1" lookupGroup="org1" width="650" height="300"><span>属性</span></a>
<%-- 					<a class="button" href="variable/listVariable" lookupGroup="org2" width="650" height="400"><span>变量</span></a> --%>
					<a class="button" href="rule/symbolList.jsp" lookupGroup="org3" width="500" height="400"><span>符号</span></a>
				</dd>
			</dl>
			<dl>
				<dt>规则条件：</dt>
				<dd>
					<textarea id="content" rows="6" cols="60" spellcheck="false" autocomplete="off" name="rule.condition" alt="请输入条件内容"></textarea>
				</dd>
			</dl>
			<dl>
			
			<dl>
				<dt>&nbsp;&nbsp;&nbsp;&nbsp;</dt>
				<dd>
					<a class="button" href="action/ruleActionMeta?sceneId=${sceneId }"  mask="true" target="dialog" rel="type_list" title="选择动作类型" width="650" height="300"><span>动作</span></a>
				</dd>
			</dl>
				<dt>规则动作：</dt>
				<dd>
				<div>
					<div id="actionShow" class="pageContent" layouth="30" style="height: 394px; overflow: auto; ">
						<div style="border:1px solid #B8D0D6;padding:5px;margin:1px" id="showAddAction">请添加动作
						</div>
					</div>
				</div>
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