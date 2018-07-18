package com.bit.shop01.model;

import com.bit.shop01.model.entity.ProductVo;

public class productDaoImpl implements productDao {

	@Override
	public void addPro(ProductVo bean) throws Exception {
		String sql = "insert into product values (?,?,?,?,?,?,?)";

	}

	@Override
	public void addProImg(String proImg) throws Exception {
		

	}

	@Override
	public void selectPro(ProductVo bean) throws Exception {
		

	}

	@Override
	public void delPro(int productNum) throws Exception {
		

	}

}
