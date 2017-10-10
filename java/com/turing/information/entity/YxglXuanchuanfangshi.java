package com.turing.information.entity;

import java.math.BigDecimal;
import java.util.Date;

public class YxglXuanchuanfangshi {
    private String xcfsId;

    private String xcfsName;

    private String xcfsInfo;

    private BigDecimal xcfsJiage;

    private String xcfsXiaoguo;

    private String xcfsLxr;

    private String xcfsPhone;

    private Date xcfsInDate;

    public String getXcfsId() {
        return xcfsId;
    }

    public void setXcfsId(String xcfsId) {
        this.xcfsId = xcfsId == null ? null : xcfsId.trim();
    }

    public String getXcfsName() {
        return xcfsName;
    }

    public void setXcfsName(String xcfsName) {
        this.xcfsName = xcfsName == null ? null : xcfsName.trim();
    }

    public String getXcfsInfo() {
        return xcfsInfo;
    }

    public void setXcfsInfo(String xcfsInfo) {
        this.xcfsInfo = xcfsInfo == null ? null : xcfsInfo.trim();
    }

    public BigDecimal getXcfsJiage() {
        return xcfsJiage;
    }

    public void setXcfsJiage(BigDecimal xcfsJiage) {
        this.xcfsJiage = xcfsJiage;
    }

    public String getXcfsXiaoguo() {
        return xcfsXiaoguo;
    }

    public void setXcfsXiaoguo(String xcfsXiaoguo) {
        this.xcfsXiaoguo = xcfsXiaoguo == null ? null : xcfsXiaoguo.trim();
    }

    public String getXcfsLxr() {
        return xcfsLxr;
    }

    public void setXcfsLxr(String xcfsLxr) {
        this.xcfsLxr = xcfsLxr == null ? null : xcfsLxr.trim();
    }

    public String getXcfsPhone() {
        return xcfsPhone;
    }

    public void setXcfsPhone(String xcfsPhone) {
        this.xcfsPhone = xcfsPhone == null ? null : xcfsPhone.trim();
    }

    public Date getXcfsInDate() {
        return xcfsInDate;
    }

    public void setXcfsInDate(Date xcfsInDate) {
        this.xcfsInDate = xcfsInDate;
    }
}