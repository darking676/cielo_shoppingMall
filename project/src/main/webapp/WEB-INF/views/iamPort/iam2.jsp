<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>정기결제 연동</title>
<script type="text/javascript">
	app.post("/subscriptions/issue-billing", async(req, res) => { // POST 요청처리
		try {
			const{
				card_number,	// 카드번호
				expiry,			// 카드 유효기간
				birth,			// 생년월일
				pwd_2digit,		// 카드 비번 앞의 2자리
				customer_uid,	// 카드 빌링키와 1vs1로 대응하는 값
			} = req.body;		// req의 body에서 카드 정보 추출
			
			// 인증 토큰 발급
			const getToken = await axios({
				url : "https://api.iamport.kr/users/getToken",
				method : "POST",
				headers : {"content-Type":"application/json"},
				data : {
					// REST api_key/api_secret
					imp_key : "8542999742312688",
					imp_secret : "iORsNRtGoYYjTU5kbptq4hfuzupDdhSv6KXTCqA1pykitqCFP65ToloXPNB25uxbev5QWFRlecDHCfnr"
				}
			});
			const{access_token} = getToken.data.response;	// 인증 토큰
			
			//빌링키 발급 요청
			const issueBilling = await axios({
				url: `https://api.iamport.kr/subscribe/customers/${customer_uid}`,
	            method: "post",
	            headers: { "Authorization": access_token }, // 인증 토큰 Authorization header에 추가
	            data: {
	                card_number,	// 카드 번호
	                expiry,			// 카드 유효기간
	                birth,			// 생년월일
	                pwd_2digit,		// 카드 비밀번호 앞 두자리
	            }
			});
			
			 // 빌링키 발급
			 const { code, message } = issueBilling;
		        if (code === 0) { 	// 성공
		            res.send({ status: "success", message: "Billing has successfully issued" });
		        } else { 			// 실패
		            res.send({ status: "failed", message });
		        }
		        
		} catch (e) {
			res.status(400).send(e);
		}
	});
	
	// 결제 예약
	axios({
	    url: `https://api.iamport.kr/subscribe/payments/schedule`,
	    method: "post",
	    headers: { "Authorization": access_token }, // 인증 토큰 Authorization header에 추가
	    data: {
	        customer_uid: "gildong_0001_1234", // 카드(빌링키)와 1:1로 대응하는 값
	        schedules: [
	            {
	                merchant_uid: "order_monthly_0001", // 주문 번호
	                schedule_at: 1519862400, // 결제 시도 시각 in Unix Time Stamp. ex. 다음 달 1일
	                amount: 8900,
	                name: "월간 이용권 정기결제",
	                buyer_name: "홍길동",
	                buyer_tel: "01012345678",
	                buyer_email: "gildong@gmail.com"
	            }
	        ]
	    }
	});
</script>
</head>
<body>
	<form action="https://www.myservice.com/subscription/issue-billing" method="post">
	    <div>
	        <label for="card_number">카드 번호 XXXX-XXXX-XXXX-XXXX</label>
	        <input id="card_number" type="text" name="card_number">
	    </div>
	    <div>
	        <label for="expiry">카드 유효기간 YYYY-MM</label>
	        <input id="expiry" type="text" name="expiry">
	    </div>
	    <div>
	        <label for="birth">생년월일 YYMMDD</label>
	        <input id="birth" type="text" name="birth">
	    </div>
	    <div>
	        <label for="pwd_2digit">카드 비밀번호 앞 두자리 XX</label>
	        <input id="pwd_2digit" type="text" name="pwd_2digit">
	    </div>
	    <input hidden type="text" value="gildong_0001_1234" name="customer_uid">
	    <input type="submit" value="결제하기">
	</form>
</body>
</html>