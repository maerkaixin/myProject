package com.turing.code.entity;

public class CodeTousufangshi {
    private String ctfId;

    private String ctfName;

    public String getCtfId() {
        return ctfId;
    }

    public void setCtfId(String ctfId) {
        this.ctfId = ctfId == null ? null : ctfId.trim();
    }

    public String getCtfName() {
        return ctfName;
    }

    public void setCtfName(String ctfName) {
        this.ctfName = ctfName == null ? null : ctfName.trim();
    }
}