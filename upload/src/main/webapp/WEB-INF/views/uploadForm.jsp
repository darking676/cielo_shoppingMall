<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:choose>
	<c:when test="${empty userImage }">
		<div>
			<img id ="profileImg" src = "/displayFile?fileName=/lion.gif" style = "border-radius:0%; padding-top : 10px; height:100px; width:100px;">
		</div>
	</c:when>
	<c:otherwise>
		<div>
			<img id ="profileImg" src = "/displayFile?fileName=${userImage }" style = "border-radius:0%; padding-top : 10px; height:100px; width:100px;">
		</div>
	</c:otherwise>
</c:choose>
uploaded Files<br/>
File : ${savedName }
<script type="text/javascript">
	var res = "${savedName}";
	parent.addFilePath(res);
</script>
</body>
</html>