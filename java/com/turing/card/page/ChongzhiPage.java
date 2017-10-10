package com.turing.card.page;

public class ChongzhiPage {
	private Integer pageNum = 1;
	private Integer pageSize = 8;
	private Integer start;
	private String hyName;
	private String cardName;
	
	
	
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
	public String getHyName() {
		return hyName;
	}
	public void setHyName(String hyName) {
		this.hyName = hyName;
	}
	public String getCardName() {
		return cardName;
	}
	public void setCardName(String cardName) {
		this.cardName = cardName;
	}
	
}
