<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8"/>
<meta http-equiv="X-UA-Compatible" content="IE=edge"/>
<meta name="viewport" content="user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, width=device-width"/>
<title>API Demo - Kakao JavaScript SDK</title>
<script src="//developers.kakao.com/sdk/js/kakao.min.js"></script>

</head>
<body>
<a id="kakao-login-btn"></a>
<script type='text/javascript'>
  //<![CDATA[
    // 사용할 앱의 JavaScript 키를 설정해 주세요.
    Kakao.init('a298e57f808781924ebcb67ce66dcbb1');
    // 카카오 로그인 버튼을 생성합니다.
    Kakao.Auth.createLoginButton({
		container: '#kakao-login-btn',
		// login 성공시 ...
		success: function(authObj) {
    	  Kakao.API.request({
  	        url: '/v1/api/payment/ready',
  	        // 결제 준비 성공시 ...
  	        success: function(res) {
  	        	alert(JSON.stringify(res));
  	        },
  	        // 결제 준비 실패시 ...
  	        fail: function(error) {
  	        	alert(JSON.stringify(error));
  	        }
		});
      },
      // login 실패시 ...
      fail: function(err) {
        alert(JSON.stringify(err));
      }
    });
  //]]>
</script>

</body>
</html>