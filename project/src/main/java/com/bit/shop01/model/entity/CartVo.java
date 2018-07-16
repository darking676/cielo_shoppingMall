package com.bit.shop01.model.entity;

public class CartVo {

	private int basketNum; // wish_num;		장바구니 id
	private int productNum; // wish_p_id;	상품번호
	private String price; // p_price;		가격
	private int numbers; // wish_number;	수량
	
	private String memId; // wish_userid;	사용자 id
	private String proImg; // p_img;		상품 이미지
	
	public CartVo() {
		// TODO Auto-generated constructor stub
	}

	public CartVo(int basketNum, int productNum, String price, int numbers, String memId, String proImg) {
		super();
		this.basketNum = basketNum;
		this.productNum = productNum;
		this.price = price;
		this.numbers = numbers;
		this.memId = memId;
		this.proImg = proImg;
	}

	public int getBasketNum() {
		return basketNum;
	}

	public void setBasketNum(int basketNum) {
		this.basketNum = basketNum;
	}

	public int getProductNum() {
		return productNum;
	}

	public void setProductNum(int productNum) {
		this.productNum = productNum;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public int getNumbers() {
		return numbers;
	}

	public void setNumbers(int numbers) {
		this.numbers = numbers;
	}

	public String getMemId() {
		return memId;
	}

	public void setMemId(String memId) {
		this.memId = memId;
	}

	public String getProImg() {
		return proImg;
	}

	public void setProImg(String proImg) {
		this.proImg = proImg;
	}

	@Override
	public String toString() {
		return "CarVo [basketNum=" + basketNum + ", productNum=" + productNum + ", price=" + price + ", numbers="
				+ numbers + ", memId=" + memId + ", proImg=" + proImg + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + basketNum;
		result = prime * result + ((memId == null) ? 0 : memId.hashCode());
		result = prime * result + numbers;
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result + ((proImg == null) ? 0 : proImg.hashCode());
		result = prime * result + productNum;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CartVo other = (CartVo) obj;
		if (basketNum != other.basketNum)
			return false;
		if (memId == null) {
			if (other.memId != null)
				return false;
		} else if (!memId.equals(other.memId))
			return false;
		if (numbers != other.numbers)
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		if (proImg == null) {
			if (other.proImg != null)
				return false;
		} else if (!proImg.equals(other.proImg))
			return false;
		if (productNum != other.productNum)
			return false;
		return true;
	}

}
