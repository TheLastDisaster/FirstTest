<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html><head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.3.min.js"></script>
</head>
<body>
<div class="main">
	<div class="optitle clearfix">
		<div class="title">供应商管理&gt;&gt;</div>

	</div>
	<form id="form1" name="form1" method="post" modelAttribute="pro" action="${pageContext.request.contextPath}/pro/doUpdatePro/${pro.id }">
		<input type="hidden" name="proCode" value="${pro.proCode }">
		<div class="content">
			<font color="red"></font><table class="box">
			<tbody><tr>
					<td class="field">供应商编号：</td>
					<td><input type="hidden" name="proId" value="${pro.id }5"> ${pro.id }</td>

				</tr>
			 <tr>
					<td class="field">供应商名称：</td>
					<td><input type="hidden" name="proName" value="${pro.proName }">${pro.proName }</td>
				</tr>
				 <tr>
					<td class="field">联系人：</td>
					<td><input type="text" name="proContact" class="text" id="proContact" value="${pro.proContact }" required > <font color="red">*</font><font color="red" id="proContact_span"></font></td>
				</tr>
				<tr>
					<td class="field">联系电话：</td>
					<td><input type="text" name="proPhone" class="text" id="proPhone" value="${pro.proPhone }" required> <font color="red">*</font><font color="red" id="proPhone_span"></font></td>
				</tr>
				<tr>
					<td class="field">联系地址：</td>
					<td><input name="proAddress" id="proAddress" class="text" value="${pro.proAddress }"></td>
				</tr>
			   <tr>
					<td class="field">传真：</td>
					<td><input type="text" name="proFax" class="text" id="proFax" value="${pro.proFax }"> </td>

				</tr>
				 <tr>
					<td class="field">描述：</td>
					<td><input type="text" name="proDesc" class="text" id="proDesc" value="${pro.proDesc }"> </td>

				</tr>
			</tbody></table>
		</div>
		<div class="buttons">
			<input type="submit" name="update" id="update" value="修改" class="input-button">
			<input type="button" name="button" id="button" onclick="history.back(-1)" value="返回" class="input-button"> 
		</div>

	</form>
</div>>
</body></html>