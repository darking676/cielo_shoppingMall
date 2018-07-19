package com.bit.upload;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		
		return "uploadAjax";
	}
	
	@RequestMapping(value = "/uploadForm", method = RequestMethod.POST)
	public String uploadRes() {
		
		return "uploadForm";
	}
	
}
