package com.turing.card.entity;

import java.math.BigDecimal;
import java.util.Date;

public class CardChongzhi {
    private String czId;

    private String hcId;

    private BigDecimal czNum;

    private Date czTime;

    private BigDecimal oldNum;

    private String hyName;
    
    private String cardName;
    
    public String getCzId() {
        return czId;
    }

    public void setCzId(String czId) {
        this.czId = czId == null ? null : czId.trim();
    }

    public String getHcId() {
        return hcId;
    }

    public void setHcId(String hcId) {
        this.hcId = hcId == null ? null : hcId.trim();
    }

    public BigDecimal getCzNum() {
        return czNum;
    }

    public void setCzNum(BigDecimal czNum) {
        this.czNum = czNum;
    }

    public Date getCzTime() {
        return czTime;
    }

    public void setCzTime(Date czTime) {
        this.czTime = czTime;
    }

    public BigDecimal getOldNum() {
        return oldNum;
    }

    public void setOldNum(BigDecimal oldNum) {
        this.oldNum = oldNum;
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