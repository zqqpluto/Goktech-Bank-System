<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'addDept.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<link rel="stylesheet" type="text/css" href="<%=path%>/css/main.css">


</head>

<body>
	<div class="main">
		<div class="title">
			<a href="<%=path%>/DeptServletUrl">�����б�</a> &gt;&nbsp;�鿴������Ϣ
		</div>

		<div class="line">���ű��:${deptBean.deptno}</div>
		<div class="line">��������:${deptBean.dname}</div>
		<div class="line">����λ��:${deptBean.loc}</div>
		<div class="line">
			&nbsp;<input type="button" value="�����б�"
				onclick="window.history.back();" class="button" />&nbsp;
		</div>

	</div>
</body>
</html>
