package com.bit.shop01.cart;

import java.util.List;

import com.bit.shop01.cart.model.entity.CartVo;

public interface CartService {
	
//	public int test();
	
	//��ٱ��Ͽ� �߰�
	public int insert(CartVo vo);

	//��ٱ� ��ǰ Ȯ��
	public int countCart(int productNum, String memId);

	//��ٱ��� ����
	public int editCart(CartVo vo);

	//��ٱ��� ���� ����
	public void updateCart(CartVo vo);
	
	//��ٱ��� ���
	public List<CartVo> listCart(String memId);

	//��ٱ��� �ݾ� �հ�
	public int sumPrice(String memId);

	//��ٱ��� ����
	public void delete(int cartNum);

	
}
