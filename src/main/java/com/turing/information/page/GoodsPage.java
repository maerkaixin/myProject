package com.turing.information.page;

import java.math.BigDecimal;

public class GoodsPage {
	private Integer pageNum = 1;
	private Integer pageSize = 8;
	private Integer start;
	private String goodsName;
	private String goodsNo;
	private String goodsMa;
	private String qyId;
    private String csdId;
	private String cspId;
	private String cslId;
	
	private BigDecimal goodsMjFrom;
	private BigDecimal goodsMjTo;
	
	
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
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public String getGoodsNo() {
		return goodsNo;
	}
	public void setGoodsNo(String goodsNo) {
		this.goodsNo = goodsNo;
	}
	public String getGoodsMa() {
		return goodsMa;
	}
	public void setGoodsMa(String goodsMa) {
		this.goodsMa = goodsMa;
	}
	public String getQyId() {
		return qyId;
	}
	public void setQyId(String qyId) {
		this.qyId = qyId;
	}
	public String getCspId() {
		return cspId;
	}
	public void setCspId(String cspId) {
		this.cspId = cspId;
	}
	public String getCslId() {
		return cslId;
	}
	public void setCslId(String cslId) {
		this.cslId = cslId;
	}
	public String getCsdId() {
		return csdId;
	}
	public void setCsdId(String csdId) {
		this.csdId = csdId;
	}
	public BigDecimal getGoodsMjFrom() {
		return goodsMjFrom;
	}
	public void setGoodsMjFrom(BigDecimal goodsMjFrom) {
		this.goodsMjFrom = goodsMjFrom;
	}
	public BigDecimal getGoodsMjTo() {
		return goodsMjTo;
	}
	public void setGoodsMjTo(BigDecimal goodsMjTo) {
		this.goodsMjTo = goodsMjTo;
	}

}
