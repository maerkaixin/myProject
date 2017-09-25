package com.turing.code.entity;

public class CodeQiyexingzhi {
    private String cqxId;

    private String cqxName;

    public String getCqxId() {
        return cqxId;
    }

    public void setCqxId(String cqxId) {
        this.cqxId = cqxId == null ? null : cqxId.trim();
    }

    public String getCqxName() {
        return cqxName;
    }

    public void setCqxName(String cqxName) {
        this.cqxName = cqxName == null ? null : cqxName.trim();
    }
}