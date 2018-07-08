package com.bit.shop01.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;

import com.bit.shop01.model.PayDao;
import com.bit.shop01.model.memDao;
import com.bit.shop01.model.entity.CartVo;

public class PayController {

	HttpSession httpSession;
	Logger log = Logger.getLogger(getClass());
	
	//Template;
	
	@Resource(name="pdao")
	PayDao pdao;
	
	@Resource(name="mdao")
	memDao mdao;
	
	public ModelAndView payView(CartVo cv, HttpSession httpSession) {
		ModelAndView mav = new ModelAndView();
		//
		
		return mav;
		
	}
	
}
