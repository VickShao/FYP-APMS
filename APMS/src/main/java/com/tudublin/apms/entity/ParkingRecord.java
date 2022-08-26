package com.tudublin.apms.entity;

import java.util.Date;

public class ParkingRecord {
    private Long PkRecordId;
    private String vehicleRegNum;
    private String entryTime;
    private String exitTime;
    private float payment;
    private Boolean ifPaid;

    public Long getPkRecordId() {
        return PkRecordId;
    }

    public void setPkRecordId(Long pkRecordId) {
        PkRecordId = pkRecordId;
    }

    public String getVehicleRegNum() {
        return vehicleRegNum;
    }

    public void setVehicleRegNum(String vehicleRegNum) {
        this.vehicleRegNum = vehicleRegNum;
    }

    public String getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(String entryTime) {
        this.entryTime = entryTime;
    }

    public String getExitTime() {
        return exitTime;
    }

    public void setExitTime(String exitTime) {
        this.exitTime = exitTime;
    }

    public float getPayment() {
        return payment;
    }

    public void setPayment(float payment) {
        this.payment = payment;
    }

    public Boolean getIfPaid() {
        return ifPaid;
    }

    public void setIfPaid(Boolean ifPaid) {
        this.ifPaid = ifPaid;
    }

    @Override
    public String toString() {
        return "ParkingRecord{" +
                "PkRecordId=" + PkRecordId +
                ", vehicleRegNum='" + vehicleRegNum + '\'' +
                ", entryTime=" + entryTime +
                ", exitTime=" + exitTime +
                ", payment=" + payment +
                ", ifPaid=" + ifPaid +
                '}';
    }
}


