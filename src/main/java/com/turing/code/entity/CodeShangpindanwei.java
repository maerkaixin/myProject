package com.turing.code.entity;

public class CodeShangpindanwei {
    private String csdId;

    private String csdName;

    private String csdCode;

    public String getCsdId() {
        return csdId;
    }

    public void setCsdId(String csdId) {
        this.csdId = csdId == null ? null : csdId.trim();
    }

    public String getCsdName() {
        return csdName;
    }

    public void setCsdName(String csdName) {
        this.csdName = csdName == null ? null : csdName.trim();
    }

    public String getCsdCode() {
        return csdCode;
    }

    public void setCsdCode(String csdCode) {
        this.csdCode = csdCode == null ? null : csdCode.trim();
    }
}