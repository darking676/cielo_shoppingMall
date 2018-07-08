package com.bit.shop01.model;

import java.sql.SQLException;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.bit.shop01.model.entity.CartVo;

@Service
public class CartDaoImpl implements CartDao {

	@Inject
	CartDao cdao;
	
	@Override
	public int insert(CartVo cv) throws SQLException {
		// 장바구니 추가
		return 0;
	}

	@Override
	public ModelAndView list(String memId) throws SQLException {
		// 장바구니 목록
		return null;
	}

	@Override
	public int update(CartVo cv) throws SQLException {
		// 장바구니 수정
		return 0;
	}

	@Override
	public String delete(String memId) throws SQLException {
		// 장바구니 삭제
		return null;
	}

	@Override
	public int cntCart(int productNum, String memId) throws SQLException {
		// 장바구니 수량
		return 0;
	}

	@Override
	public int total(String memId) throws SQLException {
		// 장바구니 금액
		return 0;
	}

	@Override
	public void update1(CartVo cv) {
		// 장바구니 수량 수정
		
	}

}
