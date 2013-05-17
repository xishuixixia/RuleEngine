<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<style type="text/css">
body {
	margin: 0px;
	background-color:#4c86c6;
	padding: 0px;
	border: 0 none;
	font-size: 12px;
	font-family: Arial, Helvetica, sans-serif;
	color: #3a69a1;
}
img, a img {
	padding: 0px;
	border: 0 none;
}
body, a {
	color: BLACK;
	font-family: Arial, Helvetica, sans-serif;
}
a {
	text-decoration: none;
	cursor: pointer;
	font-size: 12px;
	font-family: Arial, Helvetica, sans-serif;	
	float:right;
	color: #3a69a1;
}
a:hover {
	color: #444;
	text-decoration: underline;	
	cursor: pointer;
	font-family: Arial, Helvetica, sans-serif;
	
}
form {
   margin: 0px;
   padding: 0px;
   border: 0 none;
}
.input {
	margin: 1px 0px 0px 0px;
	width: 140px;
	height: 26px;
	background-color: #fff;
	padding: 0px 0px 0px 0px;
	border: 0 none;
	line-height: 26px;
	font-size: 18px;
	font-family: Arial, Helvetica, sans-serif;
	font-weight: bold;
}

.input_1 {
	margin: 8px 0px 0px 0px;
	width: 140px;
	height: 26px;
	background-color: #fff;
	padding: 0px 0px 0px 0px;
	border: 0 none;
	line-height: 26px;
	font-size: 18px;
	font-family: Arial, Helvetica, sans-serif;
	font-weight: bold;
}

.input_2 {
	margin: 12px 0px 0px 0px;
	width: 140px;
	height: 26px;
	background-color: #fff;
	padding: 0px 0px 0px 0px;
	border: 0 none;
	line-height: 26px;
	font-size: 18px;
	font-family: Arial, Helvetica, sans-serif;
	font-weight: bold;
}

.button {
	margin: 12px 0px 0px 0px;
	width: 100px;
	height: 26px;
	background: #4c86c6;
	padding: 0px 0px 0px 0px;
	border: 0 none;
	line-height: 26px;
	font-size: 12px;
	font-family: Arial, Helvetica, sans-serif;
	font-weight: bold;
	color: #fff;
	text-align: center;
	cursor: pointer;
}

.clear {
	clear: both;
	padding: 0px;
	border: 0 none;
	margin: 0px;
}

div#page_wrap {
	/*margin: -108px 0px 0px -50%;*/
	margin: -159px 0px 0px -50%;
	width: 100%;
	height: 318px;
	background: #4c86c6;
	left: 50%;
	top: 50%;
	position: absolute;
	border: 0 none;
	padding: 0px;
	clear: both;
}
div#login_wrap {
	margin: -159px 0px 0px -224px;   
	width: 448px;
	height: 318px;
	background-color: #B4CDE6;
	left: 50%;
	top: 50%;
	position: absolute;
	border: 0 none;
	padding: 0px;
}
.login_box {
	margin: 0 auto;
	margin-top: 40px;
	width: 320px;
	height: 220px;
	padding: 0px;
	border: 0 none;
}
.login_box ul{ 
	margin: 0px;
	padding: 0px;
	border: 0 none;
	float: left;
}
.login_box ul li {
	float: left;
    margin: 0px;
	width: 320px;
	height: 40px;
	list-style-type: none;
	border: 0 none;
	padding: 0px;
	line-height: 40px;
	vertical-align: middle;
}
</style>
<script>
function upLoadPic(){
	document.form1.action="<%=request.getContextPath()%>/test/upLoadPicTest";
	document.form1.submit();
	return true;
}
function updateName(){
	document.form1.action="<%=request.getContextPath()%>/test/updateNameTest";
	document.form1.submit();
	return true;
}
function messageField(){
	document.form1.action="<%=request.getContextPath()%>/test/messageFieldTest";
	document.form1.submit();
	return true;
}
function integrity(){
	document.form1.action="<%=request.getContextPath()%>/test/integrityTest";
	document.form1.submit();
	return true;
}
</script>
</head>
<body>
<center><h1>资料完善场景</h1></center>

<form name="form1" method="post"  style="margin-top:130px;">
<div id="page_wrap">
    <div id="login_wrap">
        <div class="login_box">               
            <ul>                               
				<table>
				<tr>
				<td>用户名称:</td>
				<td><input name="member.username" class="input" type="text" value=""/></td>				
				</tr>
				<tr>
				<td></td>
				<td></td>
				<td><input type="submit" name="" class="button" value="上传头像" onClick="upLoadPic()" style="float:right;"/></td>
				</tr>
				<tr>
				<td></td>
				<td></td>
				<td><input type="submit" name="" class="button" value="修改昵称" onClick="updateName()" style="float:right;"/></td>
				</td>
				</tr>
				<tr>
				<td></td>
				<td></td>
				<td><input type="submit" name="" class="button" value="完成必填字段" onClick="messageField()" style="float:right;"/></td>
				</tr>
				<tr>
				<td>非必填字段数量:</td>
				<td><input name="member.nonRequiredInfo" class="input" type="text"/></td>
				</tr>
				<tr>
				<td></td>
				<td></td>
				<td><input type="submit" class="button" value="完成非必填字段" onClick="integrity()" style="float:right;"/></td>
				</tr>
				</table>
           </ul>
             
        </div>
    </div>
</div>
</form>

</body>
</html>