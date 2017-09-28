package com.turing.information.page;

public class WxPage {
	private Integer pageNum = 1;
	private Integer pageSize = 8;
	private Integer start;
	private String wxjlName;
	
	
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
		return start;
	}
	public void setStart(Integer start) {
		this.start = start;
	}
	public String getWxjlName() {
		return wxjlName;
	}
	public void setWxjlName(String wxjlName) {
		this.wxjlName = wxjlName;
	}

}
