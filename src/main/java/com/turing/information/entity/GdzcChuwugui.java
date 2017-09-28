package com.turing.information.entity;

import java.math.BigDecimal;

public class GdzcChuwugui {
    private String cwgId;

    private String cwgNo;

    private String cwgState;

    private BigDecimal cwgJiage;

    public String getCwgId() {
        return cwgId;
    }

    public void setCwgId(String cwgId) {
        this.cwgId = cwgId == null ? null : cwgId.trim();
    }

    public String getCwgNo() {
        return cwgNo;
    }

    public void setCwgNo(String cwgNo) {
        this.cwgNo = cwgNo == null ? null : cwgNo.trim();
    }

    public String getCwgState() {
        return cwgState;
    }

    public void setCwgState(String cwgState) {
        this.cwgState = cwgState == null ? null : cwgState.trim();
    }

    public BigDecimal getCwgJiage() {
        return cwgJiage;
    }

    public void setCwgJiage(BigDecimal cwgJiage) {
        this.cwgJiage = cwgJiage;
    }
}