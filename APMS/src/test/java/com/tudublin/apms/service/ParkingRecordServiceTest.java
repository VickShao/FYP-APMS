package com.tudublin.apms.service;

import com.tudublin.apms.entity.Node;
import com.tudublin.apms.entity.ParkingRecord;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class ParkingRecordServiceTest {
    private ParkingRecordService parkingRecordService = new ParkingRecordService();
    @Test
    public void selectAllParkingRecord() {
        List<ParkingRecord> parkingRecords = parkingRecordService.selectAllParkingRecord();
        for(ParkingRecord n:parkingRecords){
            System.out.println(n.getVehicleRegNum());
        }
    }

    @Test
    public void selectPaidParkingRecord() {
        List<ParkingRecord> parkingRecords = parkingRecordService.selectPaidParkingRecord();
        for(ParkingRecord n:parkingRecords){
            System.out.println(n.getVehicleRegNum());
        }
    }

    @Test
    public void selectUnpaidParkingRecord() {
        List<ParkingRecord> parkingRecords = parkingRecordService.selectUnpaidParkingRecord();
        for(ParkingRecord n:parkingRecords){
            System.out.println(n.getVehicleRegNum());
        }
    }

    @Test
    public void selectAllParkingRecordByVRN() {
        List<ParkingRecord> parkingRecords = parkingRecordService.selectAllParkingRecordByVRN("152D31031");
        for(ParkingRecord n:parkingRecords){
            System.out.println(n.getVehicleRegNum());
        }
    }

    @Test
    public void selectUnpaidParkingRecordByVRN() {
        List<ParkingRecord> parkingRecords = parkingRecordService.selectUnpaidParkingRecordByVRN("152D31031");
        for(ParkingRecord n:parkingRecords){
            System.out.println(n.getVehicleRegNum());
        }
    }

    @Test
    public void update() {
        ParkingRecord parkingRecord = new ParkingRecord();
        parkingRecord.setPkRecordId(1l);
        parkingRecord.setPayment(3.4f);

        parkingRecordService.updateOneParkingRecord(parkingRecord);
    }
}