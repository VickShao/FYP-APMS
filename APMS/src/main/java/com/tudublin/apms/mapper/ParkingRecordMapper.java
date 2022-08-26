package com.tudublin.apms.mapper;

import com.tudublin.apms.entity.ParkingRecord;
import com.tudublin.apms.utils.MybatisUtils;

import java.util.List;

public class ParkingRecordMapper {
    public List<ParkingRecord> selectAllParkingRecord(){
        List<ParkingRecord> list=  (List<ParkingRecord>) MybatisUtils.executeQuery(sqlSession -> sqlSession.selectList(
                "parkingrecordmapper.selectAllParkingRecord"));

        return list;
    }
    public List<ParkingRecord> selectPaidParkingRecord(){
        List<ParkingRecord> list=  (List<ParkingRecord>) MybatisUtils.executeQuery(sqlSession -> sqlSession.selectList(
                "parkingrecordmapper.selectPaidParkingRecord"));

        return list;
    }
    public List<ParkingRecord> selectUnpaidParkingRecord(){
        List<ParkingRecord> list=  (List<ParkingRecord>) MybatisUtils.executeQuery(sqlSession -> sqlSession.selectList(
                "parkingrecordmapper.selectUnpaidParkingRecord"));

        return list;
    }
    public List<ParkingRecord> selectAllParkingRecordByVRN(String VRN){
        List<ParkingRecord> list=  (List<ParkingRecord>) MybatisUtils.executeQuery(sqlSession -> sqlSession.selectList(
                "parkingrecordmapper.selectAllParkingRecordByVRN", VRN));

        return list;
    }

    public List<ParkingRecord> selectUnpaidParkingRecordByVRN(String VRN){
        List<ParkingRecord> list=  (List<ParkingRecord>) MybatisUtils.executeQuery(sqlSession -> sqlSession.selectList(
                "parkingrecordmapper.selectUnpaidParkingRecordByVRN", VRN));

        return list;
    }

    public Object updateOneParkingRecord(ParkingRecord parkingRecord){
        Object num = MybatisUtils.executeUpdate(sqlSession -> sqlSession.update("parkingrecordmapper.updateOneParkingRecord",parkingRecord));

        return num;
    }
}
