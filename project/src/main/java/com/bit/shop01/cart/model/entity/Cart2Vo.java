package com.bit.shop01.cart.model.entity;

public class Cart2Vo {

	private int count;
	private int sumPrice;
	private int fee;
	private int AllSum;
	
	public Cart2Vo() {
		// TODO Auto-generated constructor stub
	}

	public Cart2Vo(int count, int sumPrice, int fee, int allSum) {
		super();
		this.count = count;
		this.sumPrice = sumPrice;
		this.fee = fee;
		AllSum = allSum;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getSumPrice() {
		return sumPrice;
	}

	public void setSumPrice(int sumPrice) {
		this.sumPrice = sumPrice;
	}

	public int getFee() {
		return fee;
	}

	public void setFee(int fee) {
		this.fee = fee;
	}

	public int getAllSum() {
		return AllSum;
	}

	public void setAllSum(int allSum) {
		AllSum = allSum;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + AllSum;
		result = prime * result + count;
		result = prime * result + fee;
		result = prime * result + sumPrice;
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
		Cart2Vo other = (Cart2Vo) obj;
		if (AllSum != other.AllSum)
			return false;
		if (count != other.count)
			return false;
		if (fee != other.fee)
			return false;
		if (sumPrice != other.sumPrice)
			return false;
		return true;
	}

}
