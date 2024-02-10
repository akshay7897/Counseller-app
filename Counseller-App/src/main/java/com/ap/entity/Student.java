package com.ap.entity;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "student_enquiry")
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "student_enqury_id")
	private Long studentId;
	
	@Column(name = "student_name")
	@NotBlank(message = "Please Enter Correct Name ")
	private String name;
	
	@NotBlank(message = "Please Enter Correct City ")
	private String city;
	
	@NotBlank(message = "Please Enter Correct Mobile Number")
	private Long mobileNo;
	
	@Email(message = "Please Enter Correct Email Address ")
	@NotBlank(message = "Please Enter Correct Email Address ")
	private String email;
	
	private String course;
	
	private String mode;
	
	private String status;
	
	@ManyToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(name ="counsellerKey" )
	private CounsellerInfo counsellerKey;
	
	@CreationTimestamp
	@Column(name = "createddate",updatable = false)
	private LocalDate createdDate;
	
	@UpdateTimestamp
	@Column(name = "updatedDate",insertable  = false)
	private LocalDate updatedDate;
	
	private Boolean isactive;

	public Long getStudentId() {
		return studentId;
	}

	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}

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

	public LocalDate getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDate createdDate) {
		this.createdDate = createdDate;
	}

	public LocalDate getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(LocalDate updatedDate) {
		this.updatedDate = updatedDate;
	}

	public Boolean getIsactive() {
		return isactive;
	}

	public void setIsactive(Boolean isactive) {
		this.isactive = isactive;
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

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", name=" + name + ", city=" + city + ", mobileNo=" + mobileNo
				+ ", email=" + email + ", course=" + course + ", mode=" + mode + ", status=" + status
				+ ", counsellerKey=" + counsellerKey + ", createdDate=" + createdDate + ", updatedDate=" + updatedDate
				+ ", isactive=" + isactive + "]";
	}

	
	

}
