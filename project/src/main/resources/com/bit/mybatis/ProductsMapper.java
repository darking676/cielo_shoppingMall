package com.bit.mybatis;

import java.util.ArrayList;
import java.util.HashMap;

import com.bit.shop01.bbs.AttachFile;
import com.bit.shop01.bbs.AttachFile2;
import com.bit.shop01.products.ProductsVo;

public interface ProductsMapper {
	
	 /*
	  * �듅�젙 寃뚯떆�뙋�쓽 珥� 寃뚯떆臾� 媛��닔 援ы븯湲�
	  */
	 public int getTotalRecord(HashMap<String, String> hashmap);
	 /*
     * 寃뚯떆�뙋 紐⑸줉
     */
    public ArrayList<ProductsVo> getProductsList(HashMap<String, String> hashmap);
    /*
     * �깉濡쒖슫 寃뚯떆湲� 異붽�
     */
    public int insert(ProductsVo productsVo);
    /*
     * 寃뚯떆湲� �닔�젙
     */
    public void update(ProductsVo productsVo);   
   
    /*
     * 寃뚯떆湲� �궘�젣
     */
    public void delete(int productNum);

    /*
     * 寃뚯떆�뙋 �씠由�(醫낅쪟)
     */
    public String getProductsNum(String procd);
    
    /*
     * 寃뚯떆�뙋 媛앹껜 媛��졇�삤湲�
     */
    public ProductsVo getProductsVo(int productNum);

	public ProductsVo getPrevProductsVo(HashMap<String, String> hashmap);

	public ProductsVo getNextProductsVo(HashMap<String, String> hashmap);
	
	 /*
	  * 媛��옣 理쒓렐 寃뚯떆臾� 媛��졇�삤湲�
	  */
	 public ProductsVo getNewProductsVo();
	 
	 /*
	  * 泥⑤��뙆�씪 異붽�
	  */
	 public void insertAttachFile(AttachFile attachFile);

	 /*
	  *  寃뚯떆湲��쓽 泥⑤��뙆�씪 由ъ뒪�듃
	  */
	 public ArrayList<AttachFile> getAttachFileList(int productNum);
}
 
	
