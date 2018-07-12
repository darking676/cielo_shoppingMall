<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 
.then(function (res) {
        // 로그인 성공시, API를 호출합니다.(결제 준비)
        Kakao.API.request({
	        url: '/v1/payment/ready',
	        success: function(res) {
	        	alert(JSON.stringify(res));
	        },
	        fail: function(error) {
	        	alert(JSON.stringify(error));
	        }
	    }).then(function (res) {	// 이전 api 성공후 다음 api 호출
     	// 로그인 성공시, API를 호출합니다.(결제 승인)
        return Kakao.API.request({
			url: '/v1/payment/approve',
			success: function(res) {
				 alert(JSON.stringify(res));
			},
			fail: function(error) {
				 alert(JSON.stringify(error));
			}
        }).then(function (res) {	// 이전 api 성공후 다음 api 호출
     	// 로그인 성공시, API를 호출합니다.(결제 취소)
        return Kakao.API.request({
			url: '/v1/payment/cancel',
			success: function(res) {
				 alert(JSON.stringify(res));
			},
			fail: function(error) {
				 alert(JSON.stringify(error));
			}
        }).then(function (res) {	// 이전 api 성공후 다음 api 호출
     	// 로그인 성공시, API를 호출합니다.(주문 상세 조회)
        return Kakao.API.request({
			url: '/v1/payment/order',
			success: function(res) {
				 alert(JSON.stringify(res));
			},
			fail: function(error) {
				 alert(JSON.stringify(error));
			}
        }).then(function (res) {	// 이전 api 성공후 다음 api 호출
    	// 주문 내역 조회							
    	return Kakao.API.request({
			url: '/v1/payment/orders',
			success: function(res) {
				 alert(JSON.stringify(res));
			},
			fail: function(error) {
				 alert(JSON.stringify(error));
			}
        }).then(function (res) {	// 이전 api 성공후 다음 api 호출
    	// 결제 내역 조회							
    	return Kakao.API.request({
			url: '/v1/payment/manage/report',
			success: function(res) {
				 alert(JSON.stringify(res));
			},
			fail: function(error) {
				 alert(JSON.stringify(error));
			} 
			-->
</body>
</html>