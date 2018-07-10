package com.bit.shop01.controller;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bit.shop01.model.CartDao;
import com.bit.shop01.model.entity.CartVo;

@Controller
@RequestMapping("/shop01/cart/**")
public class CartController{
	
//	@Autowired
	CartDao cdao;
	
	@RequestMapping("cartIn")
	public String insert(@ModelAttribute CartVo cv, HttpSession session) throws SQLException {
		
		String memId = (String)session.getAttribute("memId");
		cv.setMemId(memId);
		
		// 장바구니에 기존 상품이 있는지 검사
		int cnt = cdao.cntCart(cv.getProductNum(), memId);
		
		// cnt==0? cdao.update(cv) : cdao.insert(cv);
		if (cnt==0)
			cnt = cdao.update(cv);
		else
			cnt = cdao.insert(cv);
		
		if(cnt==0) {
			// 상품이 없으면 insert
			cdao.insert(cv);
		}else {
			// 상품이 있으면 update
			cdao.update(cv);
		}
		return "redrect:/sho01/cart/cartList";
	}

	@RequestMapping("cartList")
	public ModelAndView list(ModelAndView mav, HttpSession session) throws SQLException {
		
		String memId = (String)session.getAttribute("memId");
		Map<String, Object> map = new HashMap<String, Object>();
		List<CartVo> list = (List<CartVo>) cdao.list(memId); // 장바구니 정보
		int totalPay = cdao.total(memId); // 장바구니 전체 금액
		// int fee = totalPay >=  10000 ? 0 : 2500; // 배송료 : 1만원이면 무료, 나머지는 2500원 부담
		
		map.put("clist", list); // 장바구니 정보 저장
		map.put("cnt", list.size()); // 장바구니 상품의 유/무
		map.put("totPay", totalPay); //장바구니 금액 전체
//		map.put("fee", fee); // 배송료 
//		map.put("sumPay", sumPay) // 주문시 전체 금액(추가할 것)
		mav.setViewName("shop01/cartList"); // jsp 주소
		map.put("map", map); // map 변수 저장
		return mav;
	}

	@RequestMapping("cartEd")
	public String update1(HttpSession session, @RequestParam int[] productNum, @RequestParam int numbers) throws SQLException {
		String memId = (String)session.getAttribute("memId");
		for(int i=0;i<productNum.length;i++) {
			CartVo cv = new CartVo();
			cv.setMemId(memId);
			cv.setNumbers(numbers);
			cv.setProductNum(productNum[i]);
			cdao.update(cv);
		}
		return "redirect:/shop01/cart/cartList";
	}

	@RequestMapping("cartDel")
	public String delete(String memId) throws SQLException {
		cdao.delete(memId);
		return "redirect:/shop01/cart/cartList";
	}

}
