package com.tudublin.apms.service;

import com.tudublin.apms.entity.Node;
import com.tudublin.apms.entity.ParkingRecord;
import com.tudublin.apms.mapper.ParkingRecordMapper;

import java.util.List;

public class ParkingRecordService {
    private ParkingRecordMapper parkingRecordMapper = new ParkingRecordMapper();
    public List<ParkingRecord> selectAllParkingRecord(){
        return parkingRecordMapper.selectAllParkingRecord();
    }
    public List<ParkingRecord> selectPaidParkingRecord(){
        return parkingRecordMapper.selectPaidParkingRecord();
    }
    public List<ParkingRecord> selectUnpaidParkingRecord(){
        return parkingRecordMapper.selectUnpaidParkingRecord();
    }
    public List<ParkingRecord> selectAllParkingRecordByVRN(String VRN){
        return parkingRecordMapper.selectAllParkingRecordByVRN(VRN);
    }
    public List<ParkingRecord> selectUnpaidParkingRecordByVRN(String VRN){
        return parkingRecordMapper.selectUnpaidParkingRecordByVRN(VRN);
    }

    public Object updateOneParkingRecord(ParkingRecord parkingRecord){
        return parkingRecordMapper.updateOneParkingRecord(parkingRecord);
    }
}
