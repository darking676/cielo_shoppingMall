package com.bit.shop01.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bit.shop01.cart.CartService;
import com.bit.shop01.cart.model.entity.CartVo;

@Controller
public class CartController {

	@RequestMapping(value = "/cart/", method = RequestMethod.GET)
	public String cart(HttpSession session) {
		return "/info/cart";
	}
	
	//장바구니 목록
	@RequestMapping(value = "/cart2/", method = RequestMethod.GET)
	public String cart2(HttpSession session) {
		return "/info2/cart2";
	}
	
	//장바구니에 상품 추가
	@RequestMapping(value="/insert")
	public String insert(@ModelAttribute CartVo vo, HttpSession session) {
		String memId = (String) session.getAttribute("memId");
		vo.setMemId(memId);
		
		//상품이 있는지 검사
		int count = CartService.countCart(vo.getProductNum(), memId);
		if (count == 0) {
			//없으면 update(수정)
			CartService.updateCart(vo);
		} else {
			//있으면 insert
			CartService.insert(vo);
		}
		
		if(count == 0) {
			//없으면 insert
			CartService.insert(vo);
		} else {
			//있으면 update(수정)
			CartService.updateCart(vo);
		}
		
		return "redirect:/cart2/";
	}
	
	//장바구니 목록
	@RequestMapping(value="/list")
	public ModelAndView list(HttpSession session, ModelAndView mav) {
		
		String memId = (String) session.getAttribute("memId");
		Map<String, Object> map = new HashMap<String, Object>();
		List<CartVo> list = CartService.listCart(memId);
		int sumPrice = CartService.sumPrice(memId);
		
		//배송료(10만원 이상이면 무료 아니면 2500원)
		int fee = sumPrice >= 100000 ? 0 : 2500;
		
		map.put("list", list);				//장바구니 정보를 map에 저장
		map.put("count", list.size());		//장바구니 상품 확인
		map.put("sumPrice", sumPrice);		//장바구니 전체 금액 합계
		map.put("fee", fee);				//배송료
		map.put("AllSum", sumPrice + fee);	//주문금액 합계
		
		mav.setViewName("/info2/cart2/");	//뷰 저장
		mav.addObject("map", map);			//map변수 저장
		
		return mav;
	}
	
	//장바구니에서 상품 삭제
	@RequestMapping(value="/delete")
	public String delete(@RequestParam int cartNum) {
		CartService.delete(cartNum);
		return "redirect:/cart2/";
	}
	
	//장바구니에서 수정
	@RequestMapping(value="/update")
	public String update(@RequestParam int[] amount, @RequestParam int[] productNum, HttpSession session) {
		String memId = (String) session.getAttribute("memId");
		for(int i=0; i<productNum.length; i++) {
			CartVo vo = new CartVo();
			vo.setMemId(memId);
			vo.setQuantity(amount[i]);
			vo.setProductNum(productNum[i]);
			CartService.updateCart(vo);
		}
		
		return "redirect:/cart2/";
	}

}
