
package com.bit.shop01.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.method.support.ModelAndViewContainer;

import com.bit.shop01.model.entity.MemVo;
import com.bit.shop01.service.MemService;

@Controller
public class MembersController {

	@Autowired
	private MemService memService;

	Logger log = Logger.getLogger(this.getClass());

	@RequestMapping(value = "/login/", method = RequestMethod.GET)
	public String login() {

		return "/info/login";

	}


	@RequestMapping(value = "/login/", method = RequestMethod.POST)
	public String login(String memId, String memPassword, HttpSession session) throws Exception {
		MemVo loginMem = memService.login(memId, memPassword);
		System.out.println(memId + memPassword);
		if(memId.equals("manager")) {
				session.setAttribute("check", loginMem);
				return "info2/manPage";
		}else if (loginMem != null) {
					session.setAttribute("check", loginMem);
					return "/info/logAfter";
		} else {
			return "/info/login";
		}
	}
	

	@RequestMapping(value = "/changePasswd", method = RequestMethod.GET)
	public String changePasswd() {
		return "/info/changePasswd";
	}

	@RequestMapping(value = "/changePasswd", method = RequestMethod.POST)
	public String changePasswd(String memPassword, String email, String address, String hp, HttpSession session)
			throws Exception {
		
		String memId = ((MemVo) session.getAttribute("check")).getMemId();
		
		MemVo memVo = new MemVo();
		System.out.println(">>>>>>>"+memVo);
		memVo.setMemId(memId);
		memVo.setMemPassword(memPassword);
		memVo.setEmail(email);
		memVo.setAddress(address);
		memVo.setHp(hp);

		memService.changePasswd(memVo);

		return "/info/changePasswdConfirm";
	}


	@RequestMapping(value = "/logout/", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		session.removeAttribute("check");

		return "/info/login";

	}

	@RequestMapping(value = "/join/", method = RequestMethod.GET)
	public String gojoin(MemVo memVo) {

		return "/info/join";

	}

	@RequestMapping(value = "/join/", method = RequestMethod.POST)
	public String welcome(MemVo memVo) throws Exception {

		System.out.println(memVo);
		memService.insert(memVo);
		return "/info/welcome";

	}

}
