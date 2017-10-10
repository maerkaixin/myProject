package com.turing.code.entity;

public class CodeJinjichengdu {
    private String cjcId;

    private String cjcName;

    public String getCjcId() {
        return cjcId;
    }

    public void setCjcId(String cjcId) {
        this.cjcId = cjcId == null ? null : cjcId.trim();
    }

    public String getCjcName() {
        return cjcName;
    }

    public void setCjcName(String cjcName) {
        this.cjcName = cjcName == null ? null : cjcName.trim();
    }
}