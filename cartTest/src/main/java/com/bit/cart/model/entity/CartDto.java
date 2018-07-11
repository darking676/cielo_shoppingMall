package com.bit.cart.model.entity;

public class CartDto {

	private String wish_userid;
	private String p_img;
	private String p_price;
	
	private int wish_num;
	private int wish_p_id;
	private int wish_number;
	
	public CartDto() {
		// TODO Auto-generated constructor stub
	}

	public String getWish_userid() {
		return wish_userid;
	}

	public void setWish_userid(String wish_userid) {
		this.wish_userid = wish_userid;
	}

	public String getP_img() {
		return p_img;
	}

	public void setP_img(String p_img) {
		this.p_img = p_img;
	}

	public String getP_price() {
		return p_price;
	}

	public void setP_price(String p_price) {
		this.p_price = p_price;
	}

	public int getWish_num() {
		return wish_num;
	}

	public void setWish_num(int wish_num) {
		this.wish_num = wish_num;
	}

	public int getWish_p_id() {
		return wish_p_id;
	}

	public void setWish_p_id(int wish_p_id) {
		this.wish_p_id = wish_p_id;
	}

	public int getWish_number() {
		return wish_number;
	}

	public void setWish_number(int wish_number) {
		this.wish_number = wish_number;
	}

	public CartDto(String wish_userid, String p_img, String p_price, int wish_num, int wish_p_id, int wish_number) {
		super();
		this.wish_userid = wish_userid;
		this.p_img = p_img;
		this.p_price = p_price;
		this.wish_num = wish_num;
		this.wish_p_id = wish_p_id;
		this.wish_number = wish_number;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((p_img == null) ? 0 : p_img.hashCode());
		result = prime * result + ((p_price == null) ? 0 : p_price.hashCode());
		result = prime * result + wish_num;
		result = prime * result + wish_number;
		result = prime * result + wish_p_id;
		result = prime * result + ((wish_userid == null) ? 0 : wish_userid.hashCode());
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
		CartDto other = (CartDto) obj;
		if (p_img == null) {
			if (other.p_img != null)
				return false;
		} else if (!p_img.equals(other.p_img))
			return false;
		if (p_price == null) {
			if (other.p_price != null)
				return false;
		} else if (!p_price.equals(other.p_price))
			return false;
		if (wish_num != other.wish_num)
			return false;
		if (wish_number != other.wish_number)
			return false;
		if (wish_p_id != other.wish_p_id)
			return false;
		if (wish_userid == null) {
			if (other.wish_userid != null)
				return false;
		} else if (!wish_userid.equals(other.wish_userid))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CartDto [wish_userid=" + wish_userid + ", p_img=" + p_img + ", p_price=" + p_price + ", wish_num="
				+ wish_num + ", wish_p_id=" + wish_p_id + ", wish_number=" + wish_number + "]";
	}
}
