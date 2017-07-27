<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>系统登录 - 超市账单管理系统</title>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.3.min.js"></script>
<script type="text/javascript">
  function validate(){
		var userCode = $(":text").val();
		if(userCode == ""){
			userCode=null;
		}
		var userPassword = $(":password").val();
		if(userPassword == ""){
			userPassword = null;
		}
		$("#passwordSpan").html("");
		$("#loginNameSpan").html("");
		$.post("user/login",{"userCode":userCode,"userPassword":userPassword},function(data){
			if(data != null){
				if(data.flag == 1){
					$("#loginNameSpan").html(data.msg);
				}else if(data.flag == 2){
					$("#passwordSpan").html(data.msg);
				}else{
					location.href = "frame.jsp";
				}
			}
		},"json");
	}
  </script>
</head>
<body class="blue-style">
<div id="login">
	<div class="icon"></div>
	<div class="login-box">
		<form  action=""  name="actionForm" id="actionForm"  method="post" >
			<dl>
				<dt>用户名：</dt>
				<dd><input type="text" class="input-text" /> <span id="loginNameSpan"></span></dd>
				<dt>密　码：</dt>
				<dd><input type="password"  class="input-text" /><span id="passwordSpan"></span></dd>
			</dl>
			<div class="buttons">
				<input type="button"   value="登录系统" class="input-button" onclick="validate();" />
				<input type="reset"  value="重　　填" class="input-button" />
			</div>
		</form>
	</div>
</div>
</body>
</html>
