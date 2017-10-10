package com.turing.code.entity;

public class CodeWeixiuleixing {
    private String cwlId;

    private String cwlName;

    public String getCwlId() {
        return cwlId;
    }

    public void setCwlId(String cwlId) {
        this.cwlId = cwlId == null ? null : cwlId.trim();
    }

    public String getCwlName() {
        return cwlName;
    }

    public void setCwlName(String cwlName) {
        this.cwlName = cwlName == null ? null : cwlName.trim();
    }
}