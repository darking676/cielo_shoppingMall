package com.bit.cart.model;

import java.util.List;

import com.bit.cart.model.entity.CartDto;

public interface CartDao {

	List<CartDto> selectCartList(String user_id) throws Exception;
	
	void insertCart(CartDto cean) throws Exception;
	
	CartDto configProduct(CartDto cean) throws Exception;
	
	void updateCart(CartDto cean) throws Exception;
	
	void deleteCart(CartDto cean) throws Exception;

}
