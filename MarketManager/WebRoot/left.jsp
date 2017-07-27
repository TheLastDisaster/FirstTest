<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>超市账单管理系统</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/css/style.css" />
<script type="text/javascript">
	function logout() {
		top.location = "login.html";
	}
</script>
</head>
<body class="frame-bd">
	<ul class="left-menu">
		<li><a href="bill/billList/0" target="mainFrame"><img
				src="images/btn_bill.gif" />
		</a>
		</li>
		<li><a href="pro/proList/0" target="mainFrame"><img
				src="images/btn_suppliers.gif" />
		</a>
		</li>
		<li><a href="user/userList/0" target="mainFrame"><img
				src="images/btn_users.gif" />
		</a>
		</li>	
		<li><a href="updatePwd.jsp" target="mainFrame"><img
				src="images/btn_password.gif" />
		</a>
		</li>
		<li><a href="user/loginOut" target="mainFrame"><img
				src="images/btn_exit.gif" />
		</a>
		</li>
	</ul>
</body>
</html>
