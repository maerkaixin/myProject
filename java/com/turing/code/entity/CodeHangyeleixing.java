package com.turing.code.entity;

public class CodeHangyeleixing {
    private String chlId;

    private String chlName;

    public String getChlId() {
        return chlId;
    }

    public void setChlId(String chlId) {
        this.chlId = chlId == null ? null : chlId.trim();
    }

    public String getChlName() {
        return chlName;
    }

    public void setChlName(String chlName) {
        this.chlName = chlName == null ? null : chlName.trim();
    }
}