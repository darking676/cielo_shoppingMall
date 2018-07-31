package com.bit.shop01.cart;

import java.util.List;

import com.bit.shop01.cart.model.entity.CartVo;

public interface CartService {

	//장바구니에 추가
	public static int insert(CartVo vo) {
		return 0;
	}

	//장바구 상품 확인
	public static int countCart(int productNum, String memId) {
		return 0;
	}

	//장바구니 수정
	public static int updateCart(CartVo vo) {
		return 0;
	}

	//장바구니 수량 변경
	public void updateCart2(CartVo vo);
	
	//장바구니 목록
	public static List<CartVo> listCart(String memId) {
		return null;
	}

	//장바구니 금액 합계
	public static int sumPrice(String memId) {
		return 0;
	}

	//장바구니 삭제
	public static void delete(int cartNum) {
	}
	
	
}
