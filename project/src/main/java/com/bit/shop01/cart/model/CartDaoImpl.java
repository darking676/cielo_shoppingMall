package com.bit.shop01.cart.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;

import com.bit.shop01.cart.model.entity.CartVo;

public class CartDaoImpl implements CartDao {

	@Inject
	SqlSession sqlSession;
	
	//장바구니 추가
	@Override
	public void insert(CartVo vo) {
		sqlSession.insert("cart.listCart", vo);
	}

	//장바구니 상품 확인
	@Override
	public int countCart(int productNum, String memId) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("productNum", productNum);
		map.put("memId", memId);
		return sqlSession.selectOne("cart.sumPrice", memId);
	}

	//장바구니 수정
	@Override
	public void updateCart(CartVo vo) {
		sqlSession.update("cart.updateCart", vo);
	}

	//장바구니 목록
	@Override
	public List<CartVo> listCart(String memId) {
		return sqlSession.selectList("cart.listCart", memId);
	}

	//장바구니 금액 합계
	@Override
	public int sumPrice(String memId) {
		sqlSession.selectOne("cart.sumPrice", memId);
		return sqlSession.selectOne("cart.sumPrice", memId);
	}

	//장바구니 삭제
	@Override
	public void delete(int cartNum) {
		sqlSession.delete("cart.deleteCart", cartNum);
	}

	//장바구니 상품 수량 변경
	@Override
	public void updateCart2(CartVo vo) {
		sqlSession.update("cart.sumCart", vo);
	}

}
