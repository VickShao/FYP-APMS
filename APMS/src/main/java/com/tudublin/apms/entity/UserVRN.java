package com.tudublin.apms.entity;

public class UserVRN {
    private Long dvId;
    private Long detailsId;
    private String vehicleRegNo;
    private String comment;

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Long getDvId() {
        return dvId;
    }

    public void setDvId(Long dvId) {
        this.dvId = dvId;
    }

    public Long getDetailsId() {
        return detailsId;
    }

    public void setDetailsId(Long detailsId) {
        this.detailsId = detailsId;
    }

    public String getVehicleRegNo() {
        return vehicleRegNo;
    }

    public void setVehicleRegNo(String vehicleRegNo) {
        this.vehicleRegNo = vehicleRegNo;
    }

    @Override
    public String toString() {
        return "UserVRN{" +
                "dvId=" + dvId +
                ", detailsId=" + detailsId +
                ", vehicleRegNo='" + vehicleRegNo + '\'' +
                ", comment='" + comment + '\'' +
                '}';
    }
}
