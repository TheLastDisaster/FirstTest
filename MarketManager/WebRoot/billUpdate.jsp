<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<html><head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.3.min.js"></script>
</head>
<body>
<div class="main">
	<div class="optitle clearfix">
		<div class="title">账单管理&gt;&gt;</div>
	</div>
	<f:form id="form1" name="form1" method="post" modelAttribute="bill" action="${pageContext.request.contextPath}/bill/updateBill/${bill.id} ">
		<input type="hidden" name="id" id="billId" value="${bill.id }">
		<f:hidden path="billCode"/>
		<div class="content">
			<table class="box">
			   <tbody><tr>
					<td class="field">商品名称：</td>
					<td><f:input path="productName"/> <font color="red">*</font><font color="red" id="productName_span"></font></td>
				</tr>
				 <tr>
					<td class="field">商品单位：</td>
					<td><f:input path="productUnit"/> <font color="red">*</font><font color="red" id="productUnit_span"></font></td>
				</tr>
				<tr>
					<td class="field">商品数量：</td>
					<td><f:input path="productCount"/> <font color="red">*</font><font color="red" id="productCount_span"></font></td>
				</tr>
				<tr>
					<td class="field">总额：</td>
					<td><f:input path="totalPrice"/> <font color="red">*</font><font color="red" id="billMoney_span"></font></td>
				</tr>
			   <tr>
					<td class="field">供应商：</td>
					<td>
						<f:select path="providerId" items="${proNames}"></f:select>
						<font color="red">*</font><font color="red" id="proId_span"></font>
					</td>
				</tr>
				<tr>
					<td class="field">商品描述：</td>
					<td><f:input path="productDesc"/> <font color="red">*</font><font color="red" id="billMoney_span2"></font></td>
				</tr>
				 <tr>
					<td class="field">是否付款：</td>
					<td>
						<f:radiobuttons path="isPayment" items="${isPay }"/>
					</td>
				</tr>
			</tbody></table>
		</div>
		<div class="buttons">
			<input type="submit" name="update" id="update" value="保存" class="input-button">
			<input type="button" name="button" id="button" onclick="history.back(-1)" value="返回" class="input-button"> 
		</div>

	</f:form>
</div>
</body></html>