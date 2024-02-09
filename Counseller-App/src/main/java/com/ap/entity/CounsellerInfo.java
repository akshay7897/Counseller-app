package com.ap.entity;

import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "counseller_Info")
public class CounsellerInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "counsellerkey")
	private Long counsellerKey;

	@NotBlank(message = "Please Enter Correct Name")
	private String name;

	@NotBlank(message = "Please Enter Correct Email")
	@Email(message = "Please Enter Correct Email")
	private String email;

	@NotBlank(message = "Please Enter Correct Password")
	private String password;

	@NotBlank(message = "Please Enter Correct Mobile Number")
	private String mobileNumber;

	@CreationTimestamp
	@Column(name = "createddate",updatable = false)
	private Date cretedDate;

	@UpdateTimestamp
	@Column(name = "updatedDate",insertable  = false)
	private Date updatedDate;
	
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

	public Date getCretedDate() {
		return cretedDate;
	}

	public void setCretedDate(Date cretedDate) {
		this.cretedDate = cretedDate;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}
	

	public boolean isIsactive() {
		return isactive;
	}

	public void setIsactive(boolean isactive) {
		this.isactive = isactive;
	}

	@Override
	public String toString() {
		return "CounsellerInfo [counsellerKey=" + counsellerKey + ", name=" + name + ", email=" + email + ", password="
				+ password + ", mobileNumber=" + mobileNumber + ", cretedDate=" + cretedDate + ", updatedDate="
				+ updatedDate + ", isactive=" + isactive + "]";
	}

	

}
