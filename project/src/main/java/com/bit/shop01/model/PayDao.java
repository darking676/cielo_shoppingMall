package com.bit.shop01.model;

import java.sql.SQLException;
import java.util.List;

import com.bit.shop01.model.entity.CartVo;
import com.bit.shop01.model.entity.ProductVo;

public interface PayDao {

	// ������ ����Ʈ�� �޾ƿ�
	public List<CartVo> selectAllPay(CartVo cv) throws SQLException;
	
	// ��ǰ���� ������
	public int productTitle(ProductVo pv) throws SQLException;
	
	// ��ٱ��ϰ� ������� �ƴ��� Ȯ��
	public int cartEmpty(ProductVo pv) throws SQLException;
	
	/*
	// ��۷�
	public int insertPay() throws SQLException;
	
	// ������ Ȯ��
	public List<ProductVo> selectList() throws SQLException;
	
	// ���� �� ��ٱ��� ����?!
	public void updateCart(CartVo cv) throws SQLException;
	*/
}
