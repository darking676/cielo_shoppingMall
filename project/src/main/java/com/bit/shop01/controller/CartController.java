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
	
//	//��ٱ��� ���
//	@RequestMapping(value = "/cart2/", method = RequestMethod.GET)
//	public String cart2() {
//		return "/info2/cart2";
//	}
	
	//��ٱ��Ͽ� ��ǰ �߰�
	@RequestMapping(value="/cart2/insert")
	public String insert(@ModelAttribute CartVo cartVo, HttpSession session) {
		MemVo loginMember = (MemVo)session.getAttribute("check");
		String memId = loginMember.getMemId();
		cartVo.setMemId(memId);
		
		//��ǰ�� �ִ��� �˻�
		int count = service.countCart(cartVo.getProductNum(), memId);
		if (count == 0) {
			//������ update(����)
			service.updateCart(cartVo);
		} else {
			//������ insert
			service.insert(cartVo);
		}
		
		if(count == 0) {
			//������ insert
			service.insert(cartVo);
		} else {
			//������ update(����)
			service.updateCart(cartVo);
		}
		
		return "redirect:/cart2/";
	}
	
	//��ٱ��� ���
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
		
		//��۷�(10���� �̻��̸� ���� �ƴϸ� 2500��)
		int fee = sumPrice >= 100000 ? 0 : 2500;
		
		System.out.println("fee : " + fee);
		
		map.put("list", list);				//��ٱ��� ������ map�� ����
		map.put("count", list.size());		//��ٱ��� ��ǰ Ȯ��
		map.put("sumPrice", sumPrice);		//��ٱ��� ��ü �ݾ� �հ�
		map.put("fee", fee);				//��۷�
		map.put("AllSum", sumPrice + fee);	//�ֹ��ݾ� �հ�
		
		mav.setViewName("info2/cart2");		//�� ����
		mav.addObject("map", map);			//���� ����
		
		return mav;
	}
	
	//��ٱ��Ͽ��� ��ǰ ����
	@RequestMapping(value="/cart2/delete", method = RequestMethod.GET)
	public String delete(int basketNum) {
		service.delete(basketNum);
		return "redirect:/cart2/?basketNum="+basketNum;
	}
	
	//��ٱ��Ͽ��� ����
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
