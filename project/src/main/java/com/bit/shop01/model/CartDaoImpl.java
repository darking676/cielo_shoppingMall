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
		// ��ٱ��� �߰�
		return 0;
	}

	@Override
	public ModelAndView list(String memId) throws SQLException {
		// ��ٱ��� ���
		return null;
	}

	@Override
	public int update(CartVo cv) throws SQLException {
		// ��ٱ��� ����
		return 0;
	}

	@Override
	public String delete(String memId) throws SQLException {
		// ��ٱ��� ����
		return null;
	}

	@Override
	public int cntCart(int productNum, String memId) throws SQLException {
		// ��ٱ��� ����
		return 0;
	}

	@Override
	public int total(String memId) throws SQLException {
		// ��ٱ��� �ݾ�
		return 0;
	}

	@Override
	public void update1(CartVo cv) {
		// ��ٱ��� ���� ����
		
	}

}
