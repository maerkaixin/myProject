package com.turing.code.entity;

public class CodeAihao {
    private String cahId;

    private String cahName;

    private String cahCode;

    public String getCahId() {
        return cahId;
    }

    public void setCahId(String cahId) {
        this.cahId = cahId == null ? null : cahId.trim();
    }

    public String getCahName() {
        return cahName;
    }

    public void setCahName(String cahName) {
        this.cahName = cahName == null ? null : cahName.trim();
    }

    public String getCahCode() {
        return cahCode;
    }

    public void setCahCode(String cahCode) {
        this.cahCode = cahCode == null ? null : cahCode.trim();
    }
}