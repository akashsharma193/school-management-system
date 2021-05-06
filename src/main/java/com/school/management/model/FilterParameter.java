package com.school.management.model;

import javax.ws.rs.QueryParam;

public class FilterParameter {
	
	private @QueryParam("pageIndex") Integer pageIndex=0;
	private @QueryParam("recordToShowOnOnePage") Integer recordToShowOnOnePage=25;
	private @QueryParam("recordTotal") Long recordTotal;
	private @QueryParam("arcFlag") String arcFlag="";

	private @QueryParam("id") String id="";
	private @QueryParam("firstName") String firstName="";
	private @QueryParam("lastName") String lastName="";
	private @QueryParam("isActive") String isActive="";
	public Integer getPageIndex() {
		return pageIndex;
	}
	public void setPageIndex(Integer pageIndex) {
		this.pageIndex = pageIndex;
	}
	public Integer getRecordToShowOnOnePage() {
		return recordToShowOnOnePage;
	}
	public void setRecordToShowOnOnePage(Integer recordToShowOnOnePage) {
		this.recordToShowOnOnePage = recordToShowOnOnePage;
	}
	public Long getRecordTotal() {
		return recordTotal;
	}
	public void setRecordTotal(Long recordTotal) {
		this.recordTotal = recordTotal;
	}
	public String getArcFlag() {
		return arcFlag;
	}
	public void setArcFlag(String arcFlag) {
		this.arcFlag = arcFlag;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getIsActive() {
		return isActive;
	}
	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}
}
