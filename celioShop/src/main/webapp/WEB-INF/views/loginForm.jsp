<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="template/header.jsp" %>
<style type="text/css">
	.container h2{
		font-style: italic;
	}
	.foot h2, p{
		color: white;
	}
	.foot .companyinfo, .copy{
		font-style: italic;
	}
</style>
</head>
<body>
<%@ include file="template/pCategory.jsp" %>
<!-- Login Form -->
<div class="container">
	<div class="col-sm-4 col-sm-offset-4">
		<div class="login-form"><!--login form-->
			<h2>Sign-in to your account !</h2>
			<form action="/login">
				<input type="text" placeholder=" 아이디" />
				<input type="password" placeholder="비밀번호" />
				<button type="submit" class="btn btn-default">Sign-In</button><br/>
				<a href="/join">회원이 아니신가요?"</a><!-- 회원가입 폼으로 이동 -->
			</form>
		</div>
	</div>
</div>
<br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>
<!--/Login Form-->
<%@ include file="template/footer.jsp" %>
</body>
</html>