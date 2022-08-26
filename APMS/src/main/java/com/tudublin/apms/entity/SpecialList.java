package com.tudublin.apms.entity;

public class SpecialList {
    private Long slId;
    private String userName;
    private String vehicleRegNum;
    private String comment;
    private boolean status;


    public Long getSlId() {
        return slId;
    }

    public void setSlId(Long slId) {
        this.slId = slId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getVehicleRegNum() {
        return vehicleRegNum;
    }

    public void setVehicleRegNum(String vehicleRegNum) {
        this.vehicleRegNum = vehicleRegNum;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "SpecialList{" +
                "slId=" + slId +
                ", userName='" + userName + '\'' +
                ", vehicleRegNum='" + vehicleRegNum + '\'' +
                ", comment='" + comment + '\'' +
                ", status=" + status +
                '}';
    }
}