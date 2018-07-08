package com.bit.shop01.model;

import java.sql.SQLException;
import java.util.List;

import com.bit.shop01.model.entity.CartVo;
import com.bit.shop01.model.entity.ProductVo;

public interface PayDao {

	// 결제할 리스트를 받아옴
	public List<CartVo> selectAllPay(CartVo cv) throws SQLException;
	
	// 상품명을 가져옴
	public int productTitle(ProductVo pv) throws SQLException;
	
	// 장바구니가 비었는지 아닌지 확인
	public int cartEmpty(ProductVo pv) throws SQLException;
	
	/*
	// 배송료
	public int insertPay() throws SQLException;
	
	// 결제후 확인
	public List<ProductVo> selectList() throws SQLException;
	
	// 결제 후 장바구니 비우기?!
	public void updateCart(CartVo cv) throws SQLException;
	*/
}
