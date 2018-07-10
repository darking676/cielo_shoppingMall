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
		
		// ��ٱ��Ͽ� ���� ��ǰ�� �ִ��� �˻�
		int cnt = cdao.cntCart(cv.getProductNum(), memId);
		
		// cnt==0? cdao.update(cv) : cdao.insert(cv);
		if (cnt==0)
			cnt = cdao.update(cv);
		else
			cnt = cdao.insert(cv);
		
		if(cnt==0) {
			// ��ǰ�� ������ insert
			cdao.insert(cv);
		}else {
			// ��ǰ�� ������ update
			cdao.update(cv);
		}
		return "redrect:/sho01/cart/cartList";
	}

	@RequestMapping("cartList")
	public ModelAndView list(ModelAndView mav, HttpSession session) throws SQLException {
		
		String memId = (String)session.getAttribute("memId");
		Map<String, Object> map = new HashMap<String, Object>();
		List<CartVo> list = (List<CartVo>) cdao.list(memId); // ��ٱ��� ����
		int totalPay = cdao.total(memId); // ��ٱ��� ��ü �ݾ�
		// int fee = totalPay >=  10000 ? 0 : 2500; // ��۷� : 1�����̸� ����, �������� 2500�� �δ�
		
		map.put("clist", list); // ��ٱ��� ���� ����
		map.put("cnt", list.size()); // ��ٱ��� ��ǰ�� ��/��
		map.put("totPay", totalPay); //��ٱ��� �ݾ� ��ü
//		map.put("fee", fee); // ��۷� 
//		map.put("sumPay", sumPay) // �ֹ��� ��ü �ݾ�(�߰��� ��)
		mav.setViewName("shop01/cartList"); // jsp �ּ�
		map.put("map", map); // map ���� ����
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
