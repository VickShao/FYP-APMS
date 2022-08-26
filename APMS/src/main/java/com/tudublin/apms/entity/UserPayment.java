package com.tudublin.apms.entity;

public class UserPayment {
    private Long dpId;
    private Long detailsId;
    private String cardNo;
    private String cardName;
    private String expiredDate;
    private String cvv;

    public Long getDpId() {
        return dpId;
    }

    public void setDpId(Long dpId) {
        this.dpId = dpId;
    }

    public Long getDetailsId() {
        return detailsId;
    }

    public void setDetailsId(Long detailsId) {
        this.detailsId = detailsId;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public String getExpiredDate() {
        return expiredDate;
    }

    public void setExpiredDate(String expiredDate) {
        this.expiredDate = expiredDate;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    @Override
    public String toString() {
        return "UserPayment{" +
                "dpId=" + dpId +
                ", detailsId=" + detailsId +
                ", cardNo='" + cardNo + '\'' +
                ", cardName='" + cardName + '\'' +
                ", expiredDate='" + expiredDate + '\'' +
                ", cvv='" + cvv + '\'' +
                '}';
    }
}
