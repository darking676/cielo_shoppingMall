package com.bit.shop01.model;

import java.sql.SQLException;

import org.springframework.web.servlet.ModelAndView;

import com.bit.shop01.model.entity.CartVo;

public interface CartDao {
	
	// detail -> cart
	public int insert(CartVo cv) throws SQLException;
	
	// cart -> ��ǰ ���
	public ModelAndView list(String memId) throws SQLException;
	
	// ����
	public int update(CartVo cv) throws SQLException;

	// ����
	public String delete(String memId) throws SQLException;

	// ��ٱ��� ���� üũ
	public int cntCart(int productNum, String memId) throws SQLException;

	// ��ٱ��� �ݾ�
	public int total(String memId) throws SQLException;

	// ���� ����
	public void update1(CartVo cv);
}
