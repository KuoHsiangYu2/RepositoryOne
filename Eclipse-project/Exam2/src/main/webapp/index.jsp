<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index</title>
<style type="text/css">
form {
	margin: 4px;
}
</style>
</head>
<body>
	<p>index.jsp</p>
	<a href="https://openhome.cc/Gossip/ServletJSP/JSPIncludeForward.html">
		&lt;jsp:include&gt;、&lt;jsp:forward&gt; 標籤
	</a>
	<br />
	<br />
	<form method="post" action="page2.jsp" enctype="application/x-www-form-urlencoded">
		method="post" action="page2.jsp"<br />
		<input type="text" name="text1" />
		<input type="submit" value="提交" />
	</form>
	<br />
	<form method="get" action="page2.jsp" enctype="application/x-www-form-urlencoded">
		method="get" action="page2.jsp"<br />
		<input type="text" name="text2" />
		<input type="submit" value="提交" />
	</form>
	<br />
	<hr />
	<br />
	<form method="post" action="page3.jsp" enctype="application/x-www-form-urlencoded">
		method="post" action="page3.jsp"<br />
		<input type="text" name="text3" />
		<input type="submit" value="提交" />
	</form>
	<br />
	<form method="get" action="page3.jsp" enctype="application/x-www-form-urlencoded">
		method="get" action="page3.jsp"<br />
		<input type="text" name="text4" />
		<input type="submit" value="提交" />
	</form>
</body>
</html>