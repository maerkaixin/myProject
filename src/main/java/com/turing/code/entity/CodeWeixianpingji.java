package com.turing.code.entity;

public class CodeWeixianpingji {
    private String cwpId;

    private String cwpName;

    public String getCwpId() {
        return cwpId;
    }

    public void setCwpId(String cwpId) {
        this.cwpId = cwpId == null ? null : cwpId.trim();
    }

    public String getCwpName() {
        return cwpName;
    }

    public void setCwpName(String cwpName) {
        this.cwpName = cwpName == null ? null : cwpName.trim();
    }
}