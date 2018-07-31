package com.bit.shop01.cart;

import java.util.List;

import javax.inject.Inject;

import com.bit.shop01.cart.model.CartDao;
import com.bit.shop01.cart.model.entity.CartVo;

public class CartServiceImpl implements CartService {

	@Inject
	CartDao cartDao;
	
	//장바구니에 추가
	public void insert(CartVo vo) {
		cartDao.insert(vo);
	}

	//장바구니에서 상품 확인
	public int countCart(int productNum, String memId) {
		return cartDao.countCart(productNum, memId);
	}

	//장바구니 수정
	public void updateCart(CartVo vo) {
		cartDao.updateCart(vo);
	}

	//장바구니 목록
	public List<CartVo> listCart(String memId) {
		return cartDao.listCart(memId);
	}

	//장바구니 금액 합계
	public int sumPrice(String memId) {
		return cartDao.sumPrice(memId);
	}

	//장바구니 삭제
	public void delete(int cartNum) {
		cartDao.delete(cartNum);
	}

	//장바구니 상품 수량 변경
	@Override
	public void updateCart2(CartVo vo) {
		cartDao.updateCart2(vo);
	}

	
}
