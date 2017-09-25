package com.turing.code.entity;

public class CodeFuwufangshi {
    private String cffId;

    private String cffName;

    public String getCffId() {
        return cffId;
    }

    public void setCffId(String cffId) {
        this.cffId = cffId == null ? null : cffId.trim();
    }

    public String getCffName() {
        return cffName;
    }

    public void setCffName(String cffName) {
        this.cffName = cffName == null ? null : cffName.trim();
    }
}