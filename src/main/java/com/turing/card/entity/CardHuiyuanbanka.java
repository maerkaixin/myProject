package com.turing.card.entity;

import java.math.BigDecimal;
import java.util.Date;

public class CardHuiyuanbanka {
    private String hcId;

    private String hyId;

    private String cardId;

    private Date hcTime;

    private BigDecimal hcNum;

    private String hcNo;

    private String hcPass;

    private String hcState;
    
    private String hyName;
    
    private String cardName;
    
    private String hyNo;
    
    private String cardYucunjine;

    public String getHcId() {
        return hcId;
    }

    public void setHcId(String hcId) {
        this.hcId = hcId == null ? null : hcId.trim();
    }

    public String getHyId() {
        return hyId;
    }

    public void setHyId(String hyId) {
        this.hyId = hyId == null ? null : hyId.trim();
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId == null ? null : cardId.trim();
    }

    public Date getHcTime() {
        return hcTime;
    }

    public void setHcTime(Date hcTime) {
        this.hcTime = hcTime;
    }

    public BigDecimal getHcNum() {
        return hcNum;
    }

    public void setHcNum(BigDecimal hcNum) {
        this.hcNum = hcNum;
    }

    public String getHcNo() {
        return hcNo;
    }

    public void setHcNo(String hcNo) {
        this.hcNo = hcNo == null ? null : hcNo.trim();
    }

    public String getHcPass() {
        return hcPass;
    }

    public void setHcPass(String hcPass) {
        this.hcPass = hcPass == null ? null : hcPass.trim();
    }

    public String getHcState() {
        return hcState;
    }

    public void setHcState(String hcState) {
        this.hcState = hcState == null ? null : hcState.trim();
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

	public String getHyNo() {
		return hyNo;
	}

	public void setHyNo(String hyNo) {
		this.hyNo = hyNo;
	}

	public String getCardYucunjine() {
		return cardYucunjine;
	}

	public void setCardYucunjine(String cardYucunjine) {
		this.cardYucunjine = cardYucunjine;
	}

}