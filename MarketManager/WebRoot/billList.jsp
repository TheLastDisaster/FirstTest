<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html><head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>超市账单管理系统-账单管理</title>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.3.min.js" charset="utf-8"></script>
</head>
<body>

	<div class="menu">

		<table>
			<tbody>
				<tr>
					<td><form method="post" action="${pageContext.request.contextPath}/bill/billList/1">
							<input name="method" value="query" class="input-text" type="hidden"> 
							商品名称：<input id="productName" name="productName" class="input-text" type="text" value="${productName }">
							供应商名称：<input id="proName" name="proName" class="input-text" type="text" value="${proName }">
							<c:if test="${isPayment==1 }">
								是否付款：<input type="radio" name="isPayment" value="2">是<input type="radio" name="isPayment" value="1" checked>否
							</c:if>
							<c:if test="${isPayment==2 }">
								是否付款：<input type="radio" name="isPayment" value="2" checked>是<input type="radio" name="isPayment" value="1" >否
							</c:if>
							<c:if test="${isPayment==0||isPayment==null }">
								是否付款：<input type="radio" name="isPayment" value="2" >是<input type="radio" name="isPayment" value="1" >否
							</c:if>
							<input value="查 询" type="submit">
						</form>
					</td>
				</tr>
			</tbody>
		</table>
	</div>
	<div class="main">
		<div class="optitle clearfix">
			<em><input value="添加账单" class="input-button" onclick="window.location='${pageContext.request.contextPath}/bill/addBill/0'" type="button">
			</em>
			<div class="title">账单管理&gt;&gt;</div>
		</div>
		<div class="content">
			<table class="list">
				<tbody>
					<tr>
						<td width="70" height="29"><div class="STYLE1" align="center">编号</div>
						</td>
						<td width="80"><div class="STYLE1" align="center">商品名称</div>
						</td>
						<td width="80"><div class="STYLE1" align="center">供应商</div>
						</td>
						<td width="100"><div class="STYLE1" align="center">账单金额</div>
						</td>
						<td width="100"><div class="STYLE1" align="center">是否付款</div>
						</td>
						<td width="100"><div class="STYLE1" align="center">操作时间</div>
						</td>
					</tr>
					<c:forEach items="${bills }"  var="b" >
					<tr>
						<td height="23"><span class="STYLE1">${b.id }</span>
						</td>
						<td><span class="STYLE1"><a href="${pageContext.request.contextPath}/bill/billView/${b.id}" style="color:red" > ${b.productName }</a>
						</span>
						</td>
						<td><span class="STYLE1"> ${b.provider.proName }</span>
						</td>
						<td><span class="STYLE1">${b.totalPrice }</span>
						</td>
						<td><span class="STYLE1">
							${b.isPayment==1?"否":"是" }
						</span>
						</td>
						<td><span class="STYLE1">
							<fmt:formatDate value="${b.modifyDate==null?b.creationDate:b.modifyDate }"  pattern="yyyy-MM-dd" />
						</span>
						</td>
					</tr>
					
				</c:forEach>
				</tbody>
				<input type="hidden" name="n" id="n" value="${page.n }">
			</table>
			<input type="button" value="首页" onclick="showPage1();">
		<input type="button" value="上一页" onclick="showPage2();">
		${page.n<=page.totalPage?page.n:page.totalPage }/<b id="max">${page.totalPage }</b>
		<input type="button" value="下一页" onclick="showPage3();">
		<input type="button" value="尾页" onclick="showPage4();">
		<script type="text/javascript">
			var max=parseInt($("#max").html());
			var n=parseInt($("#n").val());
			var isPayment=parseInt($("input[name=isPayment]:checked").val());
			var proName=$("#proName").val();
			var productName=$("#productName").val();
			if((typeof $("input[name=isPayment]:checked").val())=="undefined"){
				isPayment=0;
			}
			function showPage1(){
				$("#n").val(1);
				var url="1?n=1\&isPayment="+isPayment+"&\proName="+proName+"\&productName="+productName;
				url=encodeURI(encodeURI(url));
				window.location.href=url;
			}
			function showPage2(){
				if(n>1){
					n=n-1;
				}else{
					n=1;
				}
				$("#n").val(n);
				var url="1?n="+n+"\&isPayment="+isPayment+"\&proName="+proName+"\&productName="+productName
				url=encodeURI(encodeURI(url));
				window.location.href=url;
			}
			function showPage3(){
				if(n<max){
					n=n+1;
				}else{
					n=max;
				}
				$("#n").val(n);
				alert(n);
				var url="1?n="+n+"\&isPayment="+isPayment+"\&proName="+proName+"\&productName="+productName
				url=encodeURI(encodeURI(url));
				window.location.href=url;
			}
			function showPage4(){
				n=max;
				$("#n").val(n);
				var url="1?n="+n+"\&isPayment="+isPayment+"\&proName="+proName+"\&productName="+productName
				url=encodeURI(encodeURI(url));
				window.location.href=url;
			}
		</script>
		</div>
	</div>

</body></html>