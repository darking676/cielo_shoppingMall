<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
app.post("/billings", async (req, res) => {
    try {
        const { customer_uid } = req.body; // req body에서 customer_uid 추출
		//IMP.request_pay(param, callback) 호출
		IMP.request_pay({ // param
		    pg: "inicis",
		    pay_method: "card", // "card"만 지원됩니다
		    merchant_uid: "issue_billingkey_monthly_0001", // 빌링키 발급용 주문번호
		    customer_uid: "gildong_0001_1234", // 카드(빌링키)와 1:1로 대응하는 값
		    name: "최초인증결제",
		    amount: 0, // 0 으로 설정하여 빌링키 발급만 진행합니다.
		    buyer_email: "gildong@gmail.com",
		    buyer_name: "홍길동",
		    buyer_tel: "010-4242-4242",
		    buyer_addr: "서울특별시 강남구 신사동",
		    buyer_postcode: "01181"
			},function (rsp) { // callback
			if (rsp.success) {
		        // 빌링키 발급 성공
		        // jQuery로 HTTP 요청
		        jQuery.ajax({
		            url: "https://www.myservice.com/billings/", // 서비스 웹서버
		            method: "POST",
		            headers: { "Content-Type": "application/json" },
		            data: {
		                customer_uid: "gildong_0001_1234", // 카드(빌링키)와 1:1로 대응하는 값
		            }
		        })
		    } else {
		        // 빌링키 발급 실패
		    }
		});
    } catch (e) {
    	res.status(400).send(e);	
    }
});
	
</script>
</head>
<body>

</body>
</html>