package com.turing.code.entity;

public class CodeYongpinleixing {
    private String cylId;

    private String cylName;

    public String getCylId() {
        return cylId;
    }

    public void setCylId(String cylId) {
        this.cylId = cylId == null ? null : cylId.trim();
    }

    public String getCylName() {
        return cylName;
    }

    public void setCylName(String cylName) {
        this.cylName = cylName == null ? null : cylName.trim();
    }
}