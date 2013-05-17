<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<div class="pageContent">
<form method="post" action="<%=request.getContextPath()%>/role/right" class="pageForm required-validate" onsubmit="setSelectedMenus();return validateCallback(this, dialogAjaxDone);">
<input type="hidden" name="menuIds" id="menuIds" value="">
<input type="hidden" name="roleId" value="${role.id}">
<div
	style="float: left; display: block; margin: 10px; overflow: auto; width: 370px; height: 200px; border: solid 1px #CCC; line-height: 21px; background: #FFF;">


	<ul id="roleMenuTree" class="tree treeFolder treeCheck expand">
		<s:iterator value="nodes" id="node">
			<li><a tname="node" tvalue="${node.value}" <s:if test="check">checked="true"</s:if>>${node.name}</a>
				<ul>
					<s:iterator value="children" id="nc">
						<li><a tname="node" tvalue="${nc.value}"
							<s:if test="check">checked="true"</s:if>>${nc.name}</a></li>
					</s:iterator>
				</ul>
			</li>
		</s:iterator>
	</ul>
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
	<script type="text/javascript">
	function setSelectedMenus() {
		var result="";
		$("div.ckbox.indeterminate input").each(function(i){
			result+=$(this).attr('value')+",";
		});
		$("div.ckbox.checked input").each(function(i){
			result+=$(this).attr('value')+",";
		});
		$("#menuIds").val(result);
	}
	
	
		/* function kkk() {
			var json = arguments[0], result = "";
			//	alert(json.checked);

			$(json.items).each(
					function(i) {
						result += "<p>name:" + this.name + " value:"
								+ this.value + " text: " + this.text + "</p>";
					});
			alert(result);

		}
 */	
		
	</script>