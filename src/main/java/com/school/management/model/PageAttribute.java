package com.school.management.model;

public class PageAttribute {

	private Integer pageIndex;
	private Integer pageTotal;
	private Integer recordFetched;
	private Integer recordTotal;
	private Integer recordToShowOnOnePage;
	public Integer getPageIndex() {
		return pageIndex;
	}
	public void setPageIndex(Integer pageIndex) {
		this.pageIndex = pageIndex;
	}
	public Integer getPageTotal() {
		return pageTotal;
	}
	public void setPageTotal(Integer pageTotal) {
		this.pageTotal = pageTotal;
	}
	public Integer getRecordFetched() {
		return recordFetched;
	}
	public void setRecordFetched(Integer recordFetched) {
		this.recordFetched = recordFetched;
	}
	public Integer getRecordTotal() {
		return recordTotal;
	}
	public void setRecordTotal(Integer recordTotal) {
		this.recordTotal = recordTotal;
	}
	public Integer getRecordToShowOnOnePage() {
		return recordToShowOnOnePage;
	}
	public void setRecordToShowOnOnePage(Integer recordToShowOnOnePage) {
		this.recordToShowOnOnePage = recordToShowOnOnePage;
	}
	
}
