package com.turing.information.entity;

import java.math.BigDecimal;
import java.util.Date;

public class YxglHuodongjilu {
    private String hdjlId;

    private String hdjlTitle;

    private Date hdjlStartDate;

    private Date hdjlEndDate;

    private BigDecimal hdjlLen;

    private BigDecimal hdjlTotal;

    private String hdjlInfo;

    private String hdjlAdds;

    public String getHdjlId() {
        return hdjlId;
    }

    public void setHdjlId(String hdjlId) {
        this.hdjlId = hdjlId == null ? null : hdjlId.trim();
    }

    public String getHdjlTitle() {
        return hdjlTitle;
    }

    public void setHdjlTitle(String hdjlTitle) {
        this.hdjlTitle = hdjlTitle == null ? null : hdjlTitle.trim();
    }

    public Date getHdjlStartDate() {
        return hdjlStartDate;
    }

    public void setHdjlStartDate(Date hdjlStartDate) {
        this.hdjlStartDate = hdjlStartDate;
    }

    public Date getHdjlEndDate() {
        return hdjlEndDate;
    }

    public void setHdjlEndDate(Date hdjlEndDate) {
        this.hdjlEndDate = hdjlEndDate;
    }

    public BigDecimal getHdjlLen() {
        return hdjlLen;
    }

    public void setHdjlLen(BigDecimal hdjlLen) {
        this.hdjlLen = hdjlLen;
    }

    public BigDecimal getHdjlTotal() {
        return hdjlTotal;
    }

    public void setHdjlTotal(BigDecimal hdjlTotal) {
        this.hdjlTotal = hdjlTotal;
    }

    public String getHdjlInfo() {
        return hdjlInfo;
    }

    public void setHdjlInfo(String hdjlInfo) {
        this.hdjlInfo = hdjlInfo == null ? null : hdjlInfo.trim();
    }

    public String getHdjlAdds() {
        return hdjlAdds;
    }

    public void setHdjlAdds(String hdjlAdds) {
        this.hdjlAdds = hdjlAdds == null ? null : hdjlAdds.trim();
    }
}