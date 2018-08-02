package com.bit.shop01.cart;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bit.mybatis.CartMapper;
import com.bit.shop01.cart.model.entity.CartVo;

@Service
public class CartServiceImpl implements CartService {

//	cartMapperImpl dao = new cartMapperImpl();
//	cartMapper cartMapper;
	
	@Autowired
	CartMapper cartMapper;
	
	public CartServiceImpl() {
		// TODO Auto-generated constructor stub
	}
	
	//장바구니에 추가
	public int insert(CartVo vo) {
		return cartMapper.insert(vo);
	}
	
//	public int test() {
//		return cartMapper.test();
//	}

	//장바구니에서 상품 확인
	public int countCart(int productNum, String memId) {
		return cartMapper.countCart(productNum, memId);
	}

	//장바구니 수정
	public int editCart(CartVo vo) {
		return cartMapper.eidtCart(vo);
	}

	//장바구니 목록
	public List<CartVo> listCart(String memId) {
		System.out.println("list cart (service) : " + memId);
		System.out.println("list cart (service) : " + cartMapper.listCart(memId));
		return cartMapper.listCart(memId);
	}

	//장바구니 금액 합계
	public int sumPrice(String memId) {
		return cartMapper.sumPrice(memId);
	}

	//장바구니 삭제
	public void delete(int cartNum) {
		cartMapper.delete(cartNum);
	}

	//장바구니 상품 수량 변경
	public void updateCart(CartVo vo) {
		cartMapper.updateCart(vo);
	}
	

	
}
