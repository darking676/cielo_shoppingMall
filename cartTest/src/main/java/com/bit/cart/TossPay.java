package com.bit.cart;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import org.json.simple.JSONObject;

public class TossPay {
	/*URL url = null;
	URLConnection connection = null;
	StringBuilder responseBody = new StringBuilder();
	try {
		url = new URL("https://pay.toss.im/api/v1/payments");
		connection = url.openConnection();
		connection.addRequestProperty("Content-Type", "application/json");
		connection.setDoOutput(true);
		connection.setDoInput(true);
		
		JSONObject jsonBody = new JSONObject();
		jsonBody.put("orderNo", "2015072012211");
		jsonBody.put("amount", 10000);
		jsonBody.put("amountTaxFree", 0);
		jsonBody.put("productDesc", "테스트 결제");
		jsonBody.put("apiKey", "sk_test_apikey1234567890a");
		jsonBody.put("expiredTime", "2015-07-20 16:21:00");
		jsonBody.put("resultCallback", "https://myshop.com/toss/result.php");
		
		BufferedOutputStream bos = new BufferedOutputStream(connection.getOutputStream());
		bos.write(jsonBody.toJSONString().getBytes());
		bos.flush();
		bos.close();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
		String line = null;
		while ((line = br.readLine()) != null) {
			responseBody.append(line);
		}
		br.close();
	} catch (Exception e) {
		responseBody.append(e);
	}
	System.out.println(responseBody.toString());*/
}
