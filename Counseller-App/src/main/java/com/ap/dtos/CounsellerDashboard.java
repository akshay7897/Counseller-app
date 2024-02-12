package com.ap.dtos;

public class CounsellerDashboard {
	
	private Integer total;
	private Integer enrolledCount;
	private Integer lostCount;
	
	public CounsellerDashboard() {
		// 
	}
	public CounsellerDashboard(Integer total, Integer enrolledCount, Integer lostCount) {
		super();
		this.total = total;
		this.enrolledCount = enrolledCount;
		this.lostCount = lostCount;
	}

	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
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
		return "CounsellerDashboard [total=" + total + ", enrolledCount=" + enrolledCount + ", lostCount=" + lostCount
				+ "]";
	}

	
	
	

}
