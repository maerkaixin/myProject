package com.turing.information.entity;

import java.math.BigDecimal;
import java.util.Date;

public class GdzcWeixiu {
    private String wxjlId;

    private String cwlId;

    private String deptId;

    private String ppId;

    private String wxjlInfo;

    private Date wxjlTime;

    private BigDecimal wxjlLen;

    private String wxjlState;

    private String wxjlName;
    
    private String deptName;
    
    private String ppName;

    private String cwlName;
    
    public String getWxjlId() {
        return wxjlId;
    }

    public void setWxjlId(String wxjlId) {
        this.wxjlId = wxjlId == null ? null : wxjlId.trim();
    }

    public String getCwlId() {
        return cwlId;
    }

    public void setCwlId(String cwlId) {
        this.cwlId = cwlId == null ? null : cwlId.trim();
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId == null ? null : deptId.trim();
    }

    public String getPpId() {
        return ppId;
    }

    public void setPpId(String ppId) {
        this.ppId = ppId == null ? null : ppId.trim();
    }

    public String getWxjlInfo() {
        return wxjlInfo;
    }

    public void setWxjlInfo(String wxjlInfo) {
        this.wxjlInfo = wxjlInfo == null ? null : wxjlInfo.trim();
    }

    public Date getWxjlTime() {
        return wxjlTime;
    }

    public void setWxjlTime(Date wxjlTime) {
        this.wxjlTime = wxjlTime;
    }

    public BigDecimal getWxjlLen() {
        return wxjlLen;
    }

    public void setWxjlLen(BigDecimal wxjlLen) {
        this.wxjlLen = wxjlLen;
    }

    public String getWxjlState() {
        return wxjlState;
    }

    public void setWxjlState(String wxjlState) {
        this.wxjlState = wxjlState == null ? null : wxjlState.trim();
    }

    public String getWxjlName() {
        return wxjlName;
    }

    public void setWxjlName(String wxjlName) {
        this.wxjlName = wxjlName == null ? null : wxjlName.trim();
    }

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getPpName() {
		return ppName;
	}

	public void setPpName(String ppName) {
		this.ppName = ppName;
	}

	public String getCwlName() {
		return cwlName;
	}

	public void setCwlName(String cwlName) {
		this.cwlName = cwlName;
	}
}