package com.bit.shop01.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bit.shop01.cart.CartService;
import com.bit.shop01.cart.model.CartDaoImpl;
import com.bit.shop01.cart.model.entity.CartVo;
import com.bit.shop01.model.entity.MemVo;

@Controller
public class CartController {

	@Autowired
	private CartService service;
	
	@RequestMapping(value = "/cart/", method = RequestMethod.GET)
	public String cart() {
		return "/info/cart";
	}
	
//	CartServiceImpl service = new CartServiceImpl();
	CartDaoImpl dao = new CartDaoImpl();
	
//	//장바구니 목록
//	@RequestMapping(value = "/cart2/", method = RequestMethod.GET)
//	public String cart2() {
//		return "/info2/cart2";
//	}
	
	//장바구니에 상품 추가
	@RequestMapping(value="/cart2/insert")
	public String insert(@ModelAttribute CartVo cartVo, HttpSession session) {
		MemVo loginMember = (MemVo)session.getAttribute("check");
		String memId = loginMember.getMemId();
		cartVo.setMemId(memId);
		
		//상품이 있는지 검사
		int count = service.countCart(cartVo.getProductNum(), memId);
		if (count == 0) {
			//없으면 update(수정)
			service.updateCart(cartVo);
		} else {
			//있으면 insert
			service.insert(cartVo);
		}
		
		if(count == 0) {
			//없으면 insert
			service.insert(cartVo);
		} else {
			//있으면 update(수정)
			service.updateCart(cartVo);
		}
		
		return "redirect:/cart2/";
	}
	
	//장바구니 목록
	@RequestMapping(value="/cart2/")
	public ModelAndView list(HttpSession session, ModelAndView mav, HttpServletRequest request) {
		
		MemVo loginMember = (MemVo)session.getAttribute("check");
		String memId = loginMember.getMemId();
		System.out.println("memid(cart controller) : "+memId);
//		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		Map<String, Object> map = new HashMap<String, Object>();
//		List<CartVo> list = service.listCart(memId);
		List<CartVo> list = new ArrayList<CartVo>();
		
//		int test = service.test();
//		System.out.println("test : " + test);
		
		list =  service.listCart(memId);
		int sumPrice = service.sumPrice(memId);
		
		System.out.println("sum price : " + sumPrice);
		
		//배송료(10만원 이상이면 무료 아니면 2500원)
		int fee = sumPrice >= 100000 ? 0 : 2500;
		
		System.out.println("fee : " + fee);
		
		map.put("list", list);				//장바구니 정보를 map에 저장
		map.put("count", list.size());		//장바구니 상품 확인
		map.put("sumPrice", sumPrice);		//장바구니 전체 금액 합계
		map.put("fee", fee);				//배송료
		map.put("AllSum", sumPrice + fee);	//주문금액 합계
		
		mav.setViewName("info2/cart2");		//뷰 저장
		mav.addObject("map", map);			//변수 저장
		
		return mav;
	}
	
	//장바구니에서 상품 삭제
	@RequestMapping(value="/cart2/delete", method = RequestMethod.GET)
	public String delete(int basketNum) {
		service.delete(basketNum);
		return "redirect:/cart2/?basketNum="+basketNum;
	}
	
	//장바구니에서 수정
	@RequestMapping(value="/cart2/update")
//	public String update(int quantity, int productNum, HttpSession session, HttpServletRequest req) {
	public String update(@RequestParam int[] quantity, @RequestParam int[] productNum, HttpSession session, HttpServletRequest req) {
		MemVo loginMember = (MemVo)session.getAttribute("check");
		String memId = loginMember.getMemId();
		
//		quantity=Integer.parseInt(req.getParameter("quantity"));
//		productNum=Integer.parseInt(req.getParameter("productNum"));
		System.out.println("???1 "+quantity);
		
		for(int i=0; i<productNum.length; i++) {
			System.out.println("???2 "+quantity[i]);
			CartVo cartVo = new CartVo();
			cartVo.setMemId(memId);
			cartVo.setQuantity(quantity[i]);
			cartVo.setProductNum(productNum[i]);
			service.updateCart(cartVo);
		}
		System.out.println("???3 "+quantity);
		
//		return "redirect:/cart2/?quantity="+quantity+"&&?productNum="+productNum;
		return "redirect:/cart2/";
	}

}
