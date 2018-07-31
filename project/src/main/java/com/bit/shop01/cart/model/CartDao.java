package com.bit.shop01.cart.model;

import java.util.List;

import com.bit.shop01.cart.model.entity.CartVo;

public interface CartDao {

	//장바구니 추가
	public void insert(CartVo vo);

	//장바구니 상품 확인
	public int countCart(int productNum, String memId);

	//장바구니 수정
	public void updateCart(CartVo vo);

	//장바구니 목록
	public List<CartVo> listCart(String memId);

	//장바구니 금액 합계
	public int sumPrice(String memId);

	//장바구니 삭제
	public void delete(int cartNum);

	//장바구니 수량 변경
	public void updateCart2(CartVo vo);

}
