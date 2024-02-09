package com.ap.dtos;

public class SearchCriteria {
	
	private String course;
	private String mode;
	private String status;
	
	public SearchCriteria() {
		// 
	}

	public SearchCriteria(String course, String mode, String status) {
		this.course = course;
		this.mode = mode;
		this.status = status;
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

	@Override
	public String toString() {
		return "SearchCriteria [course=" + course + ", mode=" + mode + ", status=" + status + "]";
	}
	
	
	
	

}
