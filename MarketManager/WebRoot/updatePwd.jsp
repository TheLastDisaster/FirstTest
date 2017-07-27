<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.3.min.js"></script>
</head>
<body>
	<div class="main">
		<div class="optitle clearfix">
			<div class="title">密码修改&gt;&gt;</div>
		</div>
		<form action="${pageContext.request.contextPath }/user/pwdUpdate" method="post">
			<div class="content">
				<table class="box"> 
				  <input type="hidden" name="id" value="${user.id}" />
					 <tr>
					<td class="field">旧密码：</td>
					<td><input type="password" name="oldPassword" class="text" id="oldPassword" required /> <font color="red">*</font><font color="red" id="password_span"></font></td>
				</tr>
				 <tr>
					<td class="field">新密码：</td>
					<td><input type="password" name="newPassword" class="text" id="newPassword" required  onchange="pwd();"/><b id="msg"></b> <font color="red">*</font></td>
				</tr>
				<script type="text/javascript">
					function pwd(){
						$("#msg").html("");
						$("#update").removeAttr("disabled");
						var newPassword= $("#newPassword").val();
						var reNewPassword= $("#reNewPassword").val();
						if(reNewPassword!=newPassword){
							$("#msg").html("两次密码不一致");
							$("#update").attr("disabled","disabled");
						}
					}
				</script>
				<tr>
					<td class="field">重复新密码：</td>
					<td><input type="password" name="reNewPassword" class="text" id="reNewPassword" required onchange="pwd();" /> <font color="red">*</font></td>
				</tr>
				</table>
			</div>
			<div class="buttons">
				<input type="submit" id="update" value="修改" class="input-button" />
			</div>
		</form>
	</div>
</body>
</html>
