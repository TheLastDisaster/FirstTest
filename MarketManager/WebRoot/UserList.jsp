<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html><head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>超市账单管理系统-用户管理</title>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.3.min.js"></script>
</head>
<body>

	<div class="menu">

		<table>
			<tbody>
				<tr>
					<td><form method="post" action="${pageContext.request.contextPath }/user/userList/1">
							<input name="n" id="n" value="${page.n }" class="input-text" type="hidden"> 用户名：<input name="name" id="name1" class="input-text" type="text" value="${name }">&nbsp;&nbsp;&nbsp;&nbsp;
							<input id="cx" value="查 询" type="submit">
						</form>
					</td>
				</tr>
			</tbody>
		</table>
	</div>
	<div class="main">

		<div class="optitle clearfix">
			<em><input value="添加用户" class="input-button" onclick="window.location='${pageContext.request.contextPath}/user/userAdd'" type="button">
			</em>
			<div class="title">用户管理&gt;&gt;</div>
		</div>
		<div class="content">
			<table class="list">
				<tbody>
					<tr>
						<td width="70" height="29"><div class="STYLE1" align="center">编号</div>
						</td>
						<td width="100"><div class="STYLE1" align="center">用户名</div>
						</td>
						<td width="80"><div class="STYLE1" align="center">用户账号</div>
						</td>
						<td width="100"><div class="STYLE1" align="center">性别</div>
						</td>
						<td width="100"><div class="STYLE1" align="center">出生日期</div>
						</td>
						<td width="150" ><div class="STYLE1" align="center">电话</div>
						</td>
						<td width="150"><div class="STYLE1" align="center">权限</div>
						</td>
					</tr>
					<c:forEach items="${users}" var="user">
					<tr>
						<td height="30"><span class="STYLE1">${user.id}</span>
						</td>
						<td><span class="STYLE1">${user.userName } </span>
						</td>
						<td><span class="STYLE1"><a href="${pageContext.request.contextPath }/user/findUser/${user.id}">${user.userCode}</a>
						</span>
						</td>
						<td><span class="STYLE1">
							${user.gender==1?"男":"女" }
						 </span>
						</td>
						<td><span class="STYLE1"><fmt:formatDate value="${user.birthday }" pattern="yyyy-MM-dd"/> </span>
						</td>
						<td><span class="STYLE1">${user.phone }</span>
						</td>
						<td><span class="STYLE1">
							${user.userRole.roleName}
					     </span>
						</td>
					</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<input type="button" value="首页" onclick="showPage1();">
		<input type="button" value="上一页" onclick="showPage2();">
		${page.n<=page.totalPage?page.n:page.totalPage }/<b id="max">${page.totalPage }</b>
		<input type="button" value="下一页" onclick="showPage3();">
		<input type="button" value="尾页" onclick="showPage4();">
		<script type="text/javascript">
		
			var max=parseInt($("#max").html());
			var n=parseInt($("#n").val());
			function showPage1(){
				$("#n").val(1);
				$("#cx").click();
			}
			function showPage2(){
				if(n>1){
					n=n-1;
				}else{
					n=1;
				}
				$("#n").val(n);
				$("#cx").click();
			}
			function showPage3(){
				if(n<max){
					n=n+1;
				}else{
					n=max;
				}
				$("#n").val(n);
				$("#cx").click();
			}
			function showPage4(){
				n=max;
				$("#n").val(n);
				$("#cx").click();
			}
		</script>
	</div>

</body></html>