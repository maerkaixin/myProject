package com.turing.code.entity;

public class CodeFuwuleixing {
    private String cflId;

    private String cflName;

    public String getCflId() {
        return cflId;
    }

    public void setCflId(String cflId) {
        this.cflId = cflId == null ? null : cflId.trim();
    }

    public String getCflName() {
        return cflName;
    }

    public void setCflName(String cflName) {
        this.cflName = cflName == null ? null : cflName.trim();
    }
}