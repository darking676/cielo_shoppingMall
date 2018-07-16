<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<script type="text/javascript">
	var nid_login = new nid_login("client id","callback uri");
	//접근 토큰 값 출력
	alert(nid_login.oauthParams.access_token);
	//네이버 사용자 프로필 조회
	nid_login.get_naver_userprofile("naverLoginCallback()");
	//네이버 사용자 프로필 조회 후 프로필 정보를 처리할 콜백 함수
	function naverLoginCallback() {
		alert(nid_login.getNaverUserProfileData('email'));
		alert(nid_login.getNaverUserProfileData('nickname'));
		alert(nid_login.getNaverUserProfileData('age'));
	}
</script>
</body>
</html>