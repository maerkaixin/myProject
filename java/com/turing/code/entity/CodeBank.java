package com.turing.code.entity;

public class CodeBank {
    private String cbId;

    private String cbName;

    private String cbCode;

    public String getCbId() {
        return cbId;
    }

    public void setCbId(String cbId) {
        this.cbId = cbId == null ? null : cbId.trim();
    }

    public String getCbName() {
        return cbName;
    }

    public void setCbName(String cbName) {
        this.cbName = cbName == null ? null : cbName.trim();
    }

    public String getCbCode() {
        return cbCode;
    }

    public void setCbCode(String cbCode) {
        this.cbCode = cbCode == null ? null : cbCode.trim();
    }
}