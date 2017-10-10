package com.turing.card.entity;

import java.math.BigDecimal;
import java.util.Date;

public class CardBuka {
    private String bkId;

    private String hcId;

    private Date bkTime;

    private String bkNo;

    private String bkOldNo;
    
    private String hyName;
    
    private String cardName;
    
    private String hcNo;
    
    private BigDecimal hcNum;

    public String getBkId() {
        return bkId;
    }

    public void setBkId(String bkId) {
        this.bkId = bkId == null ? null : bkId.trim();
    }

    public String getHcId() {
        return hcId;
    }

    public void setHcId(String hcId) {
        this.hcId = hcId == null ? null : hcId.trim();
    }

    public Date getBkTime() {
        return bkTime;
    }

    public void setBkTime(Date bkTime) {
        this.bkTime = bkTime;
    }

    public String getBkNo() {
        return bkNo;
    }

    public void setBkNo(String bkNo) {
        this.bkNo = bkNo == null ? null : bkNo.trim();
    }

    public String getBkOldNo() {
        return bkOldNo;
    }

    public void setBkOldNo(String bkOldNo) {
        this.bkOldNo = bkOldNo == null ? null : bkOldNo.trim();
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

	public String getHcNo() {
		return hcNo;
	}

	public void setHcNo(String hcNo) {
		this.hcNo = hcNo;
	}

	public BigDecimal getHcNum() {
		return hcNum;
	}

	public void setHcNum(BigDecimal hcNum) {
		this.hcNum = hcNum;
	}
}