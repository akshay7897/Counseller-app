package com.ap.dtos;

public class CounsellerResponse {

	private Long counsellerKey;

	private String name;

	private String email;

	private String password;

	private String mobileNumber;

	private boolean isactive;

	public Long getCounsellerKey() {
		return counsellerKey;
	}

	public void setCounsellerKey(Long counsellerKey) {
		this.counsellerKey = counsellerKey;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public boolean isIsactive() {
		return isactive;
	}

	public void setIsactive(boolean isactive) {
		this.isactive = isactive;
	}

	@Override
	public String toString() {
		return "CounsellerResponse [counsellerKey=" + counsellerKey + ", name=" + name + ", email=" + email
				+ ", password=" + password + ", mobileNumber=" + mobileNumber + ", isactive=" + isactive + "]";
	}

	
	
}
