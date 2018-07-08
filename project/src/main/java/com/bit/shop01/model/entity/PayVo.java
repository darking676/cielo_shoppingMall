package com.bit.shop01.model.entity;

public class PayVo {

	private int paymentNum;
	private String memId;
	private int productNum;
	private String address;
	private String hp;
	private String creditcardNum;
	private String creditcardPassword;
	
	public PayVo() {
		// TODO Auto-generated constructor stub
	}

	public PayVo(int paymentNum, String memId, int productNum, String address, String hp, String creditcardNum,
			String creditcardPassword) {
		super();
		this.paymentNum = paymentNum;
		this.memId = memId;
		this.productNum = productNum;
		this.address = address;
		this.hp = hp;
		this.creditcardNum = creditcardNum;
		this.creditcardPassword = creditcardPassword;
	}

	@Override
	public String toString() {
		return "PayVo [paymentNum=" + paymentNum + ", memId=" + memId + ", productNum=" + productNum + ", address="
				+ address + ", hp=" + hp + ", creditcardNum=" + creditcardNum + ", creditcardPassword="
				+ creditcardPassword + "]";
	}

	public int getPaymentNum() {
		return paymentNum;
	}

	public void setPaymentNum(int paymentNum) {
		this.paymentNum = paymentNum;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getHp() {
		return hp;
	}

	public void setHp(String hp) {
		this.hp = hp;
	}

	public String getCreditcardNum() {
		return creditcardNum;
	}

	public void setCreditcardNum(String creditcardNum) {
		this.creditcardNum = creditcardNum;
	}

	public String getCreditcardPassword() {
		return creditcardPassword;
	}

	public void setCreditcardPassword(String creditcardPassword) {
		this.creditcardPassword = creditcardPassword;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((creditcardNum == null) ? 0 : creditcardNum.hashCode());
		result = prime * result + ((creditcardPassword == null) ? 0 : creditcardPassword.hashCode());
		result = prime * result + ((hp == null) ? 0 : hp.hashCode());
		result = prime * result + ((memId == null) ? 0 : memId.hashCode());
		result = prime * result + paymentNum;
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
		PayVo other = (PayVo) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (creditcardNum == null) {
			if (other.creditcardNum != null)
				return false;
		} else if (!creditcardNum.equals(other.creditcardNum))
			return false;
		if (creditcardPassword == null) {
			if (other.creditcardPassword != null)
				return false;
		} else if (!creditcardPassword.equals(other.creditcardPassword))
			return false;
		if (hp == null) {
			if (other.hp != null)
				return false;
		} else if (!hp.equals(other.hp))
			return false;
		if (memId == null) {
			if (other.memId != null)
				return false;
		} else if (!memId.equals(other.memId))
			return false;
		if (paymentNum != other.paymentNum)
			return false;
		if (productNum != other.productNum)
			return false;
		return true;
	}
}
