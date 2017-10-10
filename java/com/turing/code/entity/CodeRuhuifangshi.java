package com.turing.code.entity;

public class CodeRuhuifangshi {
    private String crfId;

    private String crfName;

    private String crfInfo;

    public String getCrfId() {
        return crfId;
    }

    public void setCrfId(String crfId) {
        this.crfId = crfId == null ? null : crfId.trim();
    }

    public String getCrfName() {
        return crfName;
    }

    public void setCrfName(String crfName) {
        this.crfName = crfName == null ? null : crfName.trim();
    }

    public String getCrfInfo() {
        return crfInfo;
    }

    public void setCrfInfo(String crfInfo) {
        this.crfInfo = crfInfo == null ? null : crfInfo.trim();
    }
}