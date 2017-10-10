package com.turing.card.page;

public class HybkPage {
	private Integer pageNum = 1;
	private Integer pageSize = 8;
	private Integer start ;
	private String hyId;
	private String hyName;
	private String cardId;
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
		return start;
	}
	public void setStart(Integer start) {
		this.start = start;
	}
	public String getHyId() {
		return hyId;
	}
	public void setHyId(String hyId) {
		this.hyId = hyId;
	}
	public String getCardId() {
		return cardId;
	}
	public void setCardId(String cardId) {
		this.cardId = cardId;
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
