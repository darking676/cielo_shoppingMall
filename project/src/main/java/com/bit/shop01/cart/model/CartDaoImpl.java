package com.bit.shop01.cart.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.bit.mybatis.CartMapper;
import com.bit.shop01.cart.model.entity.CartVo;

public class CartDaoImpl implements CartMapper {

	@Autowired
	SqlSession sqlSession;
	
	//장바구니 추가
	@Override
	public int insert(CartVo vo) {
		return sqlSession.insert("cart.listCart", vo);
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
	public int updateCart(CartVo vo) {
		return sqlSession.update("cart.updateCart", vo);
	}

	//장바구니 목록
	@Override
	public List<CartVo> listCart(String memId) {
		System.out.println("list cart(dao) : " + memId);
		return sqlSession.selectList("cart.listCart", memId);
	}
	
	public int test() {
		System.out.println("test start");
		int result = sqlSession.selectOne("cart.test");
		System.out.println("test end");
		return result;
	}

	//장바구니 금액 합계
	@Override
	public int sumPrice(String memId) {
//		sqlSession.selectOne("cart.sumPrice", memId);
		System.out.println("dao memid : " + memId);
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
