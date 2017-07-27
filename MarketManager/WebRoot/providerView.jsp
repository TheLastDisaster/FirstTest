<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html><head><meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/css/style.css">
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.8.3.min.js"></script>
</head>
<body>
	<div class="main">
		<div class="optitle clearfix">
			<div class="title">供应商管理&gt;&gt;</div>
		</div>
			<div class="content">
				<table class="box"> 
					<tbody><tr>
						<td class="field">供应商编号：</td>
						<td>${pro.id }<input type="hidden" id="proId" value="${pro.id }"></td>
						
					</tr>
					<tr>
						<td class="field">供应商名称：</td>
						<td>${pro.proName }</td>
					</tr>
					 <tr>
					<td class="field">联系人：</td>
					<td>${pro.proContact }</td>
				</tr>
				<tr>
					<td class="field">联系电话：</td>
					<td>${pro.proPhone }</td>

				</tr>
				<tr>
					<td class="field">联系地址：</td>
					<td>${pro.proAddress }</td>
				</tr>
			   <tr>
					<td class="field">传真：</td>
					<td>${pro.proFax }</td>

				</tr>
				 <tr>
					<td class="field">描述：</td>
					<td>${pro.proDesc }</td>

				</tr>
				</tbody></table>
			</div>
			<div class="buttons">
			<form id="form1" name="form1" method="post" action="${pageContext.request.contextPath }/pro/updatePro/${pro.id }">
				<input type="submit" id="update" value="修改" class="input-button" >
			</form>
			<form id="form1" name="form1" method="post" action="${pageContext.request.contextPath }/pro/delPro/${pro.id }">
				<input type="submit" id="del" value="删除" class="input-button"> 
			</form>
				<input type="submit" id="backButton" onclick="history.back(-1)" value="返回" class="input-button">
			</div>
	</div>
</body></html>