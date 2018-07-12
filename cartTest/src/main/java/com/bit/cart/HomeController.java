package com.bit.cart;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bit.cart.model.CartDao;

@Controller
public class HomeController {
	
	HttpSession session;
	
	Logger log = Logger.getLogger(getClass());
	
	CartDao cartDao;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String cart() {
		return "cart";
	}
	
	@RequestMapping("/login/")
	public String login() {
		return "kakaoLogin";
	}
	
	@RequestMapping("/pay/")
	public String pay() {
		return "kakaopay";
	}
	
//	public ModelAndView selectCartUp() {
//		
//	}
}
