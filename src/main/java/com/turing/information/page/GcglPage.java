package com.turing.information.page;

public class GcglPage {
	private Integer pageNum =1 ;
	private Integer pageSize =8 ;
	private Integer start ;
	
	 private String gcName;
	 private Double gcNumFrom;
	 private Double gcNumTo;
	 
	 
	public Integer getPageNum() {
		return pageNum;
	}
	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public String getGcName() {
		return gcName;
	}
	public void setGcName(String gcName) {
		this.gcName = gcName;
	}
	public Double getGcNumFrom() {
		return gcNumFrom;
	}
	public void setGcNumFrom(Double gcNumFrom) {
		this.gcNumFrom = gcNumFrom;
	}
	public Double getGcNumTo() {
		return gcNumTo;
	}
	public void setGcNumTo(Double gcNumTo) {
		this.gcNumTo = gcNumTo;
	}
	public Integer getStart() {
		return start;
	}
	public void setStart(Integer start) {
		this.start = start;
	}
	
} 
