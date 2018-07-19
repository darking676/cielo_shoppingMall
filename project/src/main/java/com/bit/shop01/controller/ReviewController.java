package com.bit.shop01.controller;

import java.sql.SQLException;
import java.util.Map;

import javax.activation.CommandMap;
import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bit.shop01.service.RevService;

public class ReviewController {

	@RequestMapping("/rev/")
	public String rev_bbs(Model model,HttpServletRequest req) throws SQLException {
		return "rev_bbs";
	}
	
	@RequestMapping(value="/rev/openBoardModify")
	public ModelAndView openBoardModify(CommandMap commandMap) throws SQLException {
		ModelAndView mav = new ModelAndView("/rev/openBoardModify");
		Map<String, Object> map = RevService.selectBoard(commandMap.getMap());
		mav.addObject("map",map.get("map"));
		mav.addObject("list",map.get("list"));
	
		return mav;
	}
	
	public ModelAndView modifyBoard(CommandMap commandMap, HttpServletRequest req) throws SQLException {
		ModelAndView mav = new ModelAndView("redirect:/rev/openBoardDetail");
		RevService.modifyBoard(commandMap.getMap(), req);
		mav.addObject("idx", commandMap.get("idx"));
		return mav;
	}
	
}
