package com.bit.shop01.model.entity;

public class CartVo {

	private int basketNum;
	private String memId;
	private int productNum;
	private int numbers;
	
	public CartVo() {
		// TODO Auto-generated constructor stub
	}

	public CartVo(int basketNum, String memId, int productNum, int numbers) {
		super();
		this.basketNum = basketNum;
		this.memId = memId;
		this.productNum = productNum;
		this.numbers = numbers;
	}

	public int getBasketNum() {
		return basketNum;
	}

	public void setBasketNum(int basketNum) {
		this.basketNum = basketNum;
	}

	public String getMemId() {
		return memId;
	}

	public void setMemId(String memId) {
		this.memId = memId;
	}

	public int getProductNum() {
		return productNum;
	}

	public void setProductNum(int productNum) {
		this.productNum = productNum;
	}

	public int getNumbers() {
		return numbers;
	}

	public void setNumbers(int numbers) {
		this.numbers = numbers;
	}

	@Override
	public String toString() {
		return "CartVo [basketNum=" + basketNum + ", memId=" + memId + ", productNum=" + productNum + ", numbers="
				+ numbers + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + basketNum;
		result = prime * result + ((memId == null) ? 0 : memId.hashCode());
		result = prime * result + numbers;
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
		if (productNum != other.productNum)
			return false;
		return true;
	}
}
