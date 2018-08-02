package com.bit.mybatis;

import java.util.List;

import com.bit.shop01.cart.model.entity.CartVo;

public interface CartMapper {
	
//	public int test();
	
	//��ٱ��� �߰�
	public int insert(CartVo vo);

	//��ٱ��� ��ǰ Ȯ��
	public int countCart(int productNum, String memId);

	//��ٱ��� ����
	public int eidtCart(CartVo vo);

	//��ٱ��� ���
//	public ArrayList<CartVo> listCart(String memId);
	public List<CartVo> listCart(String memId);

	//��ٱ��� �ݾ� �հ�
	public int sumPrice(String memId);

	//��ٱ��� ����
	public void delete(int cartNum);

	//��ٱ��� ���� ����
	public int updateCart(CartVo vo);

}
