package com.bit.shop01.model;

import com.bit.shop01.model.entity.ProductVo;

public interface productDao {

	// product page Ãß°¡
	void addPro(ProductVo bean) throws Exception;
	
	// add images
	void addProImg(String proImg) throws Exception;
	
	// detail page
	void selectPro(ProductVo bean) throws Exception;
	
	// del product
	void delPro(int productNum) throws Exception;
	
}
