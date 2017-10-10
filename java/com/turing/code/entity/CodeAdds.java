package com.turing.code.entity;

public class CodeAdds {
    private String caId;

    private String caParId;

    private String caName;

    public String getCaId() {
        return caId;
    }

    public void setCaId(String caId) {
        this.caId = caId == null ? null : caId.trim();
    }

    public String getCaParId() {
        return caParId;
    }

    public void setCaParId(String caParId) {
        this.caParId = caParId == null ? null : caParId.trim();
    }

    public String getCaName() {
        return caName;
    }

    public void setCaName(String caName) {
        this.caName = caName == null ? null : caName.trim();
    }
}