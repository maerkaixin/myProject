package com.turing.card.page;

public class ZhuankaPage {
	private Integer pageNum = 1;
	private Integer pageSize = 8;
	private Integer start;
	private String zckName;
	private String zrkName;
	
	
	
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
	public Integer getStart() {
		return this.getPageSize()*(this.getPageNum()-1);
	}
	public void setStart(Integer start) {
		this.start = start;
	}
	public String getZckName() {
		return zckName;
	}
	public void setZckName(String zckName) {
		this.zckName = zckName;
	}
	public String getZrkName() {
		return zrkName;
	}
	public void setZrkName(String zrkName) {
		this.zrkName = zrkName;
	}
	
}
