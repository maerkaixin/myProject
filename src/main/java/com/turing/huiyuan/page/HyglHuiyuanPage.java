package com.turing.huiyuan.page;

import java.util.Date;

public class HyglHuiyuanPage {
	private Integer pageNum = 1;
	private Integer pageSize = 8;
	private String hyName;
	private String hyNo;
	private String hyPhone;
	private Date hyInDate;
	private Date hyDateTo;
	private Integer start;

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

	public String getHyName() {
		return hyName;
	}

	public void setHyName(String hyName) {
		this.hyName = hyName;
	}

	public String getHyNo() {
		return hyNo;
	}

	public void setHyNo(String hyNo) {
		this.hyNo = hyNo;
	}

	public String getHyPhone() {
		return hyPhone;
	}

	public void setHyPhone(String hyPhone) {
		this.hyPhone = hyPhone;
	}

	public Date getHyInDate() {
		return hyInDate;
	}

	public void setHyInDate(Date hyInDate) {
		this.hyInDate = hyInDate;
	}

	public Date getHyDateTo() {
		return hyDateTo;
	}

	public void setHyDateTo(Date hyDateTo) {
		this.hyDateTo = hyDateTo;
	}

	public Integer getStart() {
		return start;
	}

	public void setStart(Integer start) {
		this.start = start;
	}

}
