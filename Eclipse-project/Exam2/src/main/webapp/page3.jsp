<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>page3</title>
</head>
<body>
	<%
	    request.setCharacterEncoding("UTF-8");
	    response.setCharacterEncoding("UTF-8");
	    response.setContentType("text/html; charset=UTF-8");
	    String text3 = request.getParameter("text3");
	    String text4 = request.getParameter("text4");
	    System.out.println("text3 -> " + text3);
	    System.out.println("text4 -> " + text4);
	    System.out.println("-----------------");
	    if (text3 == null) {
	        text3 = "";
	    }
	    if (text4 == null) {
	        text4 = "";
	    }
	%>
	<p>page3.jsp</p>
	text3：<%=text3%><br />
	text4：<%=text4%><br />
	<br />
	<br />
	<a href="index.jsp">回首頁</a>
	<br />
</body>
</html>