package com.bit.cart;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

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
	
	@RequestMapping("/pay/")
	public String pay() {
		return "paymentList";
	}
	
//	public ModelAndView selectCartUp() {
//		
//	}
}
