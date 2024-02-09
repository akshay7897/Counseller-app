package com.ap.dtos;

import com.ap.entity.CounsellerInfo;

public class StudentEnquryRequest {
	
	private String name;
	
	private String city;
	
	private Long mobileNo;
	
	private String email;
	
	private String course;
	
	private String mode;
	
	private String status;
	
	private CounsellerInfo counsellerKey;
	
	private Boolean isactive;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Long getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(Long mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public CounsellerInfo getCounsellerKey() {
		return counsellerKey;
	}

	public void setCounsellerKey(CounsellerInfo counsellerKey) {
		this.counsellerKey = counsellerKey;
	}

	public Boolean getIsactive() {
		return isactive;
	}

	public void setIsactive(Boolean isactive) {
		this.isactive = isactive;
	}

	@Override
	public String toString() {
		return "StudentEnquryRequest [name=" + name + ", city=" + city + ", mobileNo=" + mobileNo + ", email=" + email
				+ ", course=" + course + ", mode=" + mode + ", status=" + status + ", counsellerKey=" + counsellerKey
				+ ", isactive=" + isactive + "]";
	}
	
	

}
