package com.turing.cardmanager.entity;

import java.math.BigDecimal;

public class CardType {
    private String cardId;

    private String cardName;

    private String cardNo;

    private BigDecimal cardYucunjine;

    private BigDecimal cardJiage;

    private String cardInfo;

    private String cardLck;

    private String cardState;

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId == null ? null : cardId.trim();
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName == null ? null : cardName.trim();
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo == null ? null : cardNo.trim();
    }

    public BigDecimal getCardYucunjine() {
        return cardYucunjine;
    }

    public void setCardYucunjine(BigDecimal cardYucunjine) {
        this.cardYucunjine = cardYucunjine;
    }

    public BigDecimal getCardJiage() {
        return cardJiage;
    }

    public void setCardJiage(BigDecimal cardJiage) {
        this.cardJiage = cardJiage;
    }

    public String getCardInfo() {
        return cardInfo;
    }

    public void setCardInfo(String cardInfo) {
        this.cardInfo = cardInfo == null ? null : cardInfo.trim();
    }

    public String getCardLck() {
        return cardLck;
    }

    public void setCardLck(String cardLck) {
        this.cardLck = cardLck == null ? null : cardLck.trim();
    }

    public String getCardState() {
        return cardState;
    }

    public void setCardState(String cardState) {
        this.cardState = cardState == null ? null : cardState.trim();
    }
}