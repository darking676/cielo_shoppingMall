<style>
@import url('https://fonts.googleapis.com/css?family=Nanum+Gothic');

body { font-family: 'Nanum Gothic', sans-serif;}
</style>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="../template/header.jsp" %>
</head>
<body>
<%@ include file="../template/header2.jsp" %>
<!-- content -->
<!-- num proimg proname numbers(or +update) checkbox(or delete) -->
<table>
	<thead>
		<tr>
			<th>번호</th>
			<th>상품</th>
			<th>상품 이름</th>
			<th>수량</th>
			<th>수정/삭제</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${clist }" var="cean">
			<tr>
				<td>${cean.productNum }</td>
				<td>${cean.proImg }</td>
				<td>${cean.productName }</td>
				<td>${cean.numbers }</td>
				<td></td>
			</tr>
		</c:forEach>
	</tbody>
</table>

<!-- /content -->
<%@ include file="../template/footer.jsp" %>
</body>
</html>