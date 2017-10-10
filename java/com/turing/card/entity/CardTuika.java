package com.turing.card.entity;

import java.math.BigDecimal;
import java.util.Date;

public class CardTuika {
    private String tkId;

    private String hcId;

    private Date tkTime;

    private String tkInfo;
    
    private String hyName;
    
    private String cardName;
    
    private String hcNo;
    
    private BigDecimal hcNum;

    public String getTkId() {
        return tkId;
    }

    public void setTkId(String tkId) {
        this.tkId = tkId == null ? null : tkId.trim();
    }

    public String getHcId() {
        return hcId;
    }

    public void setHcId(String hcId) {
        this.hcId = hcId == null ? null : hcId.trim();
    }

    public Date getTkTime() {
        return tkTime;
    }

    public void setTkTime(Date tkTime) {
        this.tkTime = tkTime;
    }

    public String getTkInfo() {
        return tkInfo;
    }

    public void setTkInfo(String tkInfo) {
        this.tkInfo = tkInfo == null ? null : tkInfo.trim();
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