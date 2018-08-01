<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page session="true" %>
<%session.setAttribute("check", request.getParameter("check")); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Test add</title>
</head>
<body>
<center>
	<h1>상품선택</h1>
	<hr>
		<%=session.getAttribute("check") %>
	<hr>
	
</center>
</body>
</html>