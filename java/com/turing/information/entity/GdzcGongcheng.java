package com.turing.information.entity;

import java.util.Date;

public class GdzcGongcheng {
    private String gcId;

    private String cglId;

    private String ppId;

    private String deptId;

    private String gcName;

    private String gcInfo;

    private Double gcNum;

    private Date gcStartDate;

    private Date gcEndDate;

    private String gcPinggu;

    private String cglName;
    
    private String ppName;
    
    private String deptName;
    
    public String getGcId() {
        return gcId;
    }

    public void setGcId(String gcId) {
        this.gcId = gcId == null ? null : gcId.trim();
    }

    public String getCglId() {
        return cglId;
    }

    public void setCglId(String cglId) {
        this.cglId = cglId == null ? null : cglId.trim();
    }

    public String getPpId() {
        return ppId;
    }

    public void setPpId(String ppId) {
        this.ppId = ppId == null ? null : ppId.trim();
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId == null ? null : deptId.trim();
    }

    public String getGcName() {
        return gcName;
    }

    public void setGcName(String gcName) {
        this.gcName = gcName == null ? null : gcName.trim();
    }

    public String getGcInfo() {
        return gcInfo;
    }

    public void setGcInfo(String gcInfo) {
        this.gcInfo = gcInfo == null ? null : gcInfo.trim();
    }

    public Double getGcNum() {
        return gcNum;
    }

    public void setGcNum(Double gcNum) {
        this.gcNum = gcNum;
    }

    public Date getGcStartDate() {
        return gcStartDate;
    }

    public void setGcStartDate(Date gcStartDate) {
        this.gcStartDate = gcStartDate;
    }

    public Date getGcEndDate() {
        return gcEndDate;
    }

    public void setGcEndDate(Date gcEndDate) {
        this.gcEndDate = gcEndDate;
    }

    public String getGcPinggu() {
        return gcPinggu;
    }

    public void setGcPinggu(String gcPinggu) {
        this.gcPinggu = gcPinggu == null ? null : gcPinggu.trim();
    }

	public String getCglName() {
		return cglName;
	}

	public void setCglName(String cglName) {
		this.cglName = cglName;
	}

	public String getPpName() {
		return ppName;
	}

	public void setPpName(String ppName) {
		this.ppName = ppName;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

}