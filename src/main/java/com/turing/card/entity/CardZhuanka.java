package com.turing.card.entity;

import java.math.BigDecimal;
import java.util.Date;

public class CardZhuanka {
    private String zkId;

    private BigDecimal zkNum;

    private Date zkTime;

    private String zkOldId;

    private String zkNewId;
    
    private String zrkCardName;
    private String zckCardName;
    private String zrkName;
    private String zckName;

    
    
    
    
    
    public String getZkId() {
        return zkId;
    }

    public void setZkId(String zkId) {
        this.zkId = zkId == null ? null : zkId.trim();
    }

    public BigDecimal getZkNum() {
        return zkNum;
    }

    public void setZkNum(BigDecimal zkNum) {
        this.zkNum = zkNum;
    }

    public Date getZkTime() {
        return zkTime;
    }

    public void setZkTime(Date zkTime) {
        this.zkTime = zkTime;
    }

    public String getZkOldId() {
        return zkOldId;
    }

    public void setZkOldId(String zkOldId) {
        this.zkOldId = zkOldId == null ? null : zkOldId.trim();
    }

    public String getZkNewId() {
        return zkNewId;
    }

    public void setZkNewId(String zkNewId) {
        this.zkNewId = zkNewId == null ? null : zkNewId.trim();
    }

	public String getZrkCardName() {
		return zrkCardName;
	}

	public void setZrkCardName(String zrkCardName) {
		this.zrkCardName = zrkCardName;
	}

	public String getZckCardName() {
		return zckCardName;
	}

	public void setZckCardName(String zckCardName) {
		this.zckCardName = zckCardName;
	}

	public String getZrkName() {
		return zrkName;
	}

	public void setZrkName(String zrkName) {
		this.zrkName = zrkName;
	}

	public String getZckName() {
		return zckName;
	}

	public void setZckName(String zckName) {
		this.zckName = zckName;
	}
}