package com.bit.shop01.model.entity;

public class MemVo {
	
	private String memId, memName, memPassword, email, address, hp;
	
	private String User_profileImagePath, User_id;
	
	public MemVo() {}

	public MemVo(String memId, String memName, String memPassword, String email, String address, String hp,
			String user_profileImagePath, String user_id) {
		super();
		this.memId = memId;
		this.memName = memName;
		this.memPassword = memPassword;
		this.email = email;
		this.address = address;
		this.hp = hp;
		User_profileImagePath = user_profileImagePath;
		User_id = user_id;
	}

	public String getMemId() {
		return memId;
	}

	public void setMemId(String memId) {
		this.memId = memId;
	}

	public String getMemName() {
		return memName;
	}

	public void setMemName(String memName) {
		this.memName = memName;
	}

	public String getMemPassword() {
		return memPassword;
	}

	public void setMemPassword(String memPassword) {
		this.memPassword = memPassword;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public String getUser_profileImagePath() {
		return User_profileImagePath;
	}

	public void setUser_profileImagePath(String user_profileImagePath) {
		User_profileImagePath = user_profileImagePath;
	}

	public String getUser_id() {
		return User_id;
	}

	public void setUser_id(String user_id) {
		User_id = user_id;
	}

	@Override
	public String toString() {
		return "MemVo [memId=" + memId + ", memName=" + memName + ", memPassword=" + memPassword + ", email=" + email
				+ ", address=" + address + ", hp=" + hp + ", User_profileImagePath=" + User_profileImagePath
				+ ", User_id=" + User_id + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((User_id == null) ? 0 : User_id.hashCode());
		result = prime * result + ((User_profileImagePath == null) ? 0 : User_profileImagePath.hashCode());
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((hp == null) ? 0 : hp.hashCode());
		result = prime * result + ((memId == null) ? 0 : memId.hashCode());
		result = prime * result + ((memName == null) ? 0 : memName.hashCode());
		result = prime * result + ((memPassword == null) ? 0 : memPassword.hashCode());
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
		MemVo other = (MemVo) obj;
		if (User_id == null) {
			if (other.User_id != null)
				return false;
		} else if (!User_id.equals(other.User_id))
			return false;
		if (User_profileImagePath == null) {
			if (other.User_profileImagePath != null)
				return false;
		} else if (!User_profileImagePath.equals(other.User_profileImagePath))
			return false;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
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
		if (memName == null) {
			if (other.memName != null)
				return false;
		} else if (!memName.equals(other.memName))
			return false;
		if (memPassword == null) {
			if (other.memPassword != null)
				return false;
		} else if (!memPassword.equals(other.memPassword))
			return false;
		return true;
	}

}
