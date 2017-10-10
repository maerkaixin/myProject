package com.turing.code.entity;

public class CodeShangpinpinpai {
    private String cspId;

    private String cspName;

    private String cspInfo;

    public String getCspId() {
        return cspId;
    }

    public void setCspId(String cspId) {
        this.cspId = cspId == null ? null : cspId.trim();
    }

    public String getCspName() {
        return cspName;
    }

    public void setCspName(String cspName) {
        this.cspName = cspName == null ? null : cspName.trim();
    }

    public String getCspInfo() {
        return cspInfo;
    }

    public void setCspInfo(String cspInfo) {
        this.cspInfo = cspInfo == null ? null : cspInfo.trim();
    }
}