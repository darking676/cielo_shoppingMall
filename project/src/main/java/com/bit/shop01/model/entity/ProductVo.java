package com.bit.shop01.model.entity;

public class ProductVo {

	private int productNum;
	private String productType;
	private String productName;
	private String explane;
	private int price;
	private int inventory;
	
	private String proImg;
	
	public ProductVo() {
		// TODO Auto-generated constructor stub
	}

	public ProductVo(int productNum, String productType, String productName, String explane, int price, int inventory,
			String proImg) {
		super();
		this.productNum = productNum;
		this.productType = productType;
		this.productName = productName;
		this.explane = explane;
		this.price = price;
		this.inventory = inventory;
		this.proImg = proImg;
	}

	@Override
	public String toString() {
		return "ProductVo [productNum=" + productNum + ", productType=" + productType + ", productName=" + productName
				+ ", explane=" + explane + ", price=" + price + ", inventory=" + inventory + ", proImg=" + proImg + "]";
	}

	public int getProductNum() {
		return productNum;
	}

	public void setProductNum(int productNum) {
		this.productNum = productNum;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getExplane() {
		return explane;
	}

	public void setExplane(String explane) {
		this.explane = explane;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getInventory() {
		return inventory;
	}

	public void setInventory(int inventory) {
		this.inventory = inventory;
	}

	public String getProImg() {
		return proImg;
	}

	public void setProImg(String proImg) {
		this.proImg = proImg;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((explane == null) ? 0 : explane.hashCode());
		result = prime * result + inventory;
		result = prime * result + price;
		result = prime * result + ((proImg == null) ? 0 : proImg.hashCode());
		result = prime * result + ((productName == null) ? 0 : productName.hashCode());
		result = prime * result + productNum;
		result = prime * result + ((productType == null) ? 0 : productType.hashCode());
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
		ProductVo other = (ProductVo) obj;
		if (explane == null) {
			if (other.explane != null)
				return false;
		} else if (!explane.equals(other.explane))
			return false;
		if (inventory != other.inventory)
			return false;
		if (price != other.price)
			return false;
		if (proImg == null) {
			if (other.proImg != null)
				return false;
		} else if (!proImg.equals(other.proImg))
			return false;
		if (productName == null) {
			if (other.productName != null)
				return false;
		} else if (!productName.equals(other.productName))
			return false;
		if (productNum != other.productNum)
			return false;
		if (productType == null) {
			if (other.productType != null)
				return false;
		} else if (!productType.equals(other.productType))
			return false;
		return true;
	}
	
}
