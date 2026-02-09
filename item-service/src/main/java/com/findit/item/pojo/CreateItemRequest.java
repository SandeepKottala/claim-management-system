package com.findit.item.pojo;

public class CreateItemRequest {
	
	private String itemName;
	private String description;
	private String status;
	private String location;
	private Long reportedByUserId;
	
	
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Long getReportedByUserId() {
		return reportedByUserId;
	}
	public void setReportedById(Long reportedByUserId) {
		this.reportedByUserId = reportedByUserId;
	}
	
}
