package com.ap.dtos;

public class CounsellerDashboard {
	
	private String name;
	private Integer enrolledCount;
	private Integer lostCount;
	
	public CounsellerDashboard() {
		// 
	}

	public CounsellerDashboard(String name, Integer enrolledCount, Integer lostCount) {
		this.name = name;
		this.enrolledCount = enrolledCount;
		this.lostCount = lostCount;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getEnrolledCount() {
		return enrolledCount;
	}

	public void setEnrolledCount(Integer enrolledCount) {
		this.enrolledCount = enrolledCount;
	}

	public Integer getLostCount() {
		return lostCount;
	}

	public void setLostCount(Integer lostCount) {
		this.lostCount = lostCount;
	}

	@Override
	public String toString() {
		return "CounsellerDashboard [name=" + name + ", enrolledCount=" + enrolledCount + ", lostCount=" + lostCount
				+ "]";
	}
	
	

}
