package com.turing.huiyuan.page;

import java.util.Arrays;
import java.util.Date;

public class HyglHuiyuanPage {
	private Integer pageNum = 1;
	private Integer pageSize = 8;
	private String hyName;
	private String[] hyNames;
	private String hyNo;
	private String hyPhone;
	private String crfId;
	private Date hyInDate;
	private Date hyDateTo;
	private Integer start;
	private String date1;
	private String date2;
	private String[] hyXuexing;

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

	public String getCrfId() {
		return crfId;
	}

	public void setCrfId(String crfId) {
		this.crfId = crfId;
	}

	public String getDate1() {
		return date1;
	}

	public void setDate1(String date1) {
		this.date1 = date1;
	}

	public String getDate2() {
		return date2;
	}

	public void setDate2(String date2) {
		this.date2 = date2;
	}

	public String[] getHyXuexing() {
		return hyXuexing;
	}

	public void setHyXuexing(String[] hyXuexing) {
		this.hyXuexing = hyXuexing;
	}

	@Override
	public String toString() {
		return "HyglHuiyuanPage [pageNum=" + pageNum + ", pageSize=" + pageSize
				+ ", hyName=" + hyName + ", hyNo=" + hyNo + ", hyPhone="
				+ hyPhone + ", crfId=" + crfId + ", hyInDate=" + hyInDate
				+ ", hyDateTo=" + hyDateTo + ", start=" + start + ", date1="
				+ date1 + ", date2=" + date2 + ", hyXuexing="
				+ Arrays.toString(hyXuexing) + "]";
	}

	public String[] getHyNames() {
		return hyNames;
	}

	public void setHyNames(String[] hyNames) {
		this.hyNames = hyNames;
	}


}
