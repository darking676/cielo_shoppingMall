package com.bit.mybatis;

import java.util.List;

import com.bit.shop01.cart.model.entity.CartVo;

public interface CartMapper {
	
//	public int test();
	
	//장바구니 추가
	public int insert(CartVo vo);

	//장바구니 상품 확인
	public int countCart(int productNum, String memId);

	//장바구니 수정
	public int eidtCart(CartVo vo);

	//장바구니 목록
//	public ArrayList<CartVo> listCart(String memId);
	public List<CartVo> listCart(String memId);

	//장바구니 금액 합계
	public int sumPrice(String memId);

	//장바구니 삭제
	public void delete(int cartNum);

	//장바구니 수량 변경
	public int updateCart(CartVo vo);

}
