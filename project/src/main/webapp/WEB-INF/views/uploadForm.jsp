<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	파일 업로드<br/>
	File : ${savedName }
	
<script type="text/javascript">
	var res = "${savedName }";
	parent.addFilePath(res); // 파일명을 부모페이지로 전달
</script>

</body>
</html>