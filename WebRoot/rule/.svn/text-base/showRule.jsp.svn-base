<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<h2 class="contentTitle">规则详情</h2>
<div class="pageContent">
		<div class="pageFormContent nowrap" layoutH="97">
			<dl>
				<dt>规则名称：</dt>
				<dd>
					${rule.name }
				</dd>
			</dl>
			<dl>
				<dt>创建时间：</dt>
				<dd>
					<s:date name='rule.dateEntered'   format='yyyy-MM-dd'/>
				</dd>
			</dl>
			<dl>
				<dt>修改时间：</dt>
				<dd>
					<s:date name='rule.dateModified'   format='yyyy-MM-dd'/>
				</dd>
			</dl>
			<dl>
				<dt>开始时间：</dt>
				<dd>
					<s:date name='rule.begin'   format='yyyy-MM-dd'/>
				</dd>
			</dl>
			<dl>
				<dt>结束时间：</dt>
				<dd>
					<s:date name='rule.end'   format='yyyy-MM-dd'/>
				</dd>
			</dl>
			<dl>
				<dt>规则条件：</dt>
				<dd>
					${rule.condition }
				</dd>
			</dl>
			<dl>
			
				<dt>规则动作：</dt>
				<dd>
				<div>
					<div id="actionShowUpdate" class="pageContent" layouth="30" style="height: 394px; overflow: auto; ">
					 <s:iterator value="actionMap" id="test">   
					 <div style="border:1px solid #B8D0D6;padding:5px;margin:1px">${key }</div>
					 </s:iterator>
					<s:if test="actionMap.size==0"> 
						<div style="border:1px solid #B8D0D6;padding:5px;margin:1px" id="showAddActionUpdate">暂无动作
						</div>
					</s:if>
					</div>
				</div>
				</dd>
			</dl>
		</div>
</div>