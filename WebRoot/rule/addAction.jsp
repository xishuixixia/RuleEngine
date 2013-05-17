<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<script type="text/javascript">
	$.pdialog.close("type_list");
	$("#dialogBackground").show();
	function showAction(){

		var show = $("#actionType").val()+",";
		var temp = $("#actionId").val()+"##";
		$("p[name='variable']").each(function(){
			show = show + "[" + $(this).find('[id="variableName"]').attr("value") + ":" +$(this).find('[id="variableValue"]').val() +"]";
			temp = temp + $(this).find('input[id="variableId"]').val() + "," + $(this).find('[id="variableValue"]').val() +"##";
		});
		
		if($("#flag").val() == '5'){
			$.bringBack({id:show, orgName:temp,type:'actionUpdate'});
		}else{
			$.bringBack({id:show, orgName:temp,type:'action'});
		}
	}
</script>
<div class="pageContent">
		<div class="pageFormContent" layoutH="56">
			<p>
				<label>动作类型：</label>
				${actionMeta.name }
				<input id="actionType"  type="hidden" value="${actionMeta.name }"/>
				<input id="actionId"   type="hidden" value="${actionMeta.id }"/>
				<input id="flag"  type="hidden" value="${is_update }"/>
			</p>
			<s:iterator value="variableList" id="show_variable">
			<p name="variable">
				<label id="variableName" value='${show_variable.name }'>${show_variable.name }：</label>
				<input id="variableValue" name="${show_variable.identify }"  type="text" size="30"  class="required" />
				<input id="variableId" name="${'id_' }${show_variable.identify }" value="${show_variable.id}" type="hidden" size="30"  class="required" />
				<a class="btnLook" href="rule/showItemRule?sceneId=${sceneId }&flag=2&itemInput=${show_variable.identify}&variableId=${show_variable.id}" mask=true target="dialog" rel="action_value">查找带回</a>
			</p>
			</s:iterator>
		</div>
		<div class="formBar">
			<ul>
				<li><div class="buttonActive"><div class="buttonContent"><button type="button" onclick="showAction()">添加</button></div></div></li>
				<li>
					<div class="button"><div class="buttonContent"><button type="button" class="close">取消</button></div></div>
				</li>
			</ul>
		</div>
</div>