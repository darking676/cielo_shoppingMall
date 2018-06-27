<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- header -->
<%@ include file="template/header.jsp" %>
<!-- header -->
<style type="text/css">
	.navbar .ccc{
		color: skyblue;
		font-style: italic;
	}
	#carousel img{
		width: 300px;
		height: 200px;
	}
	#carousel input{
		text-align: center;
	}
	#carousel #e1{
		position: static;
		top: 10;
	}
	.foot h2,p{
		color: white;
	}
	#accordian{
		display: inline;
	}
</style>

</head>
<body>

<!-- Products Category -->
<%@ include file="template/pCategory.jsp" %>
<!-- Products Category -->

<!-- Event Slider -->
<%@ include file="template/slider2.jsp" %>
<!-- /Event Slider -->

<!-- products -->
<%-- <%@ include file="template/products.jsp" %> --%>
<!-- /products -->

<!-- Footer -->
<%@ include file="template/footer.jsp" %>
<!-- /Footer -->

</body>
</html>