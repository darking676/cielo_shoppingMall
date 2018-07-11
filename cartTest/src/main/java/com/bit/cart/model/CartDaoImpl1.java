package com.bit.cart.model;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.bit.cart.model.entity.CartDto;

@Service("cartDao")
public class CartDaoImpl1 implements CartDao {
	
	Logger log = Logger.getLogger(this.getClass());

	@Resource(name="cartDao")
	CartDao cartDao;
	
	@Override
	public List<CartDto> selectCartList(String user_id) throws Exception {
		return cartDao.selectCartList(user_id);
	}

	@Override
	public void insertCart(CartDto cean) throws Exception {
		cartDao.insertCart(cean);

	}

	@Override
	public CartDto configProduct(CartDto cean) throws Exception {
		return cartDao.configProduct(cean);
	}

	@Override
	public void updateCart(CartDto cean) throws Exception {
		cartDao.configProduct(cean);

	}

	@Override
	public void deleteCart(CartDto cean) throws Exception {
		cartDao.deleteCart(cean);

	}

}
