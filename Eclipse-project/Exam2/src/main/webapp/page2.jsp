<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>page2</title>
</head>
<body>
	<%
	    request.setCharacterEncoding("UTF-8");
	    response.setCharacterEncoding("UTF-8");
	    response.setContentType("text/html; charset=UTF-8");
	%>
	<p>page2.jsp</p>
	text1：${param.text1}<br />
	text2：${param.text2}<br />
	<br />
	<a href="index.jsp">回首頁</a><br />
</body>
</html>