package com.bit.shop01.model;

import java.util.List;

import com.bit.shop01.model.entity.CartVo;


public interface cartDao {

	List<CartVo> selectCartList(String user_id) throws Exception;
	
	void insertCart(CartVo cean) throws Exception;
	
	CartVo configProduct(CartVo cean) throws Exception;
	
	void updateCart(CartVo cean) throws Exception;
	
	void deleteCart(CartVo cean) throws Exception;
	
}
