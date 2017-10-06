package com.turing.information.page;

public class CangkuPage {
	private Integer pageNum = 1;
	private Integer pageSize = 8;
	private Integer start;
	
	private String deptId;
	private String ckNo;
	
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
	public String getDeptId() {
		return deptId;
	}
	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}
	public String getCkNo() {
		return ckNo;
	}
	public void setCkNo(String ckNo) {
		this.ckNo = ckNo;
	}
	
}
