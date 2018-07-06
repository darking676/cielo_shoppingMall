package com.bit.shop01.model;

import java.sql.SQLException;

import org.springframework.web.servlet.ModelAndView;

import com.bit.shop01.model.entity.CartVo;

public interface CartDao {
	
	// detail -> cart
	public int insert(CartVo cv) throws SQLException;
	
	// cart -> 상품 목록
	public ModelAndView list(String memId) throws SQLException;
	
	// 수정
	public int update(CartVo cv) throws SQLException;

	// 삭제
	public String delete(String memId) throws SQLException;

	// 장바구니 수량 체크
	public int cntCart(int productNum, String memId) throws SQLException;

	// 장바구니 금액
	public int total(String memId) throws SQLException;

	// 수량 수정
	public void update1(CartVo cv);
}
