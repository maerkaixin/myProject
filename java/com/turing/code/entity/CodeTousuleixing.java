package com.turing.code.entity;

public class CodeTousuleixing {
    private String ctlId;

    private String ctlName;

    public String getCtlId() {
        return ctlId;
    }

    public void setCtlId(String ctlId) {
        this.ctlId = ctlId == null ? null : ctlId.trim();
    }

    public String getCtlName() {
        return ctlName;
    }

    public void setCtlName(String ctlName) {
        this.ctlName = ctlName == null ? null : ctlName.trim();
    }
}