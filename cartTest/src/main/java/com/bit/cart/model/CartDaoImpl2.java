package com.bit.cart.model;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.bit.cart.model.entity.CartDto;

@Repository("CartDaoImpl2")
public class CartDaoImpl2 extends AbstractDao {

	@SuppressWarnings("unchecked")
	public List<CartDto> selectCartList(String memId) throws Exception {
		return selectList("cart.selectCartList", memId);
	}
	
	public void insertCart1(CartDto cean) {
		insert("cart.insertCart", cean);
	}
	
	public CartDto configProduct(CartDto cean) throws Exception {
		return selectOne3("cart.configProduct", cean);
	}
	
	public void updateCart(CartDto cean) {
		update("cart.updateCart", cean);
	}
	
	public void deleteCart(CartDto cean) {
		update("cart.deleteCart", cean);
	}
}
