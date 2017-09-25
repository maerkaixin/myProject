package com.turing.code.entity;

public class CodeEmail {
    private String cemId;

    private String cemWeb;

    private String cemName;

    public String getCemId() {
        return cemId;
    }

    public void setCemId(String cemId) {
        this.cemId = cemId == null ? null : cemId.trim();
    }

    public String getCemWeb() {
        return cemWeb;
    }

    public void setCemWeb(String cemWeb) {
        this.cemWeb = cemWeb == null ? null : cemWeb.trim();
    }

    public String getCemName() {
        return cemName;
    }

    public void setCemName(String cemName) {
        this.cemName = cemName == null ? null : cemName.trim();
    }
}