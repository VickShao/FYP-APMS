package com.tudublin.apms.mapper;

import com.tudublin.apms.entity.SpecialList;
import com.tudublin.apms.utils.MybatisUtils;

import java.util.List;

public class SpecialListMapper {
    public List<SpecialList> selectSpecialListWhite(){
        List<SpecialList> list=  (List<SpecialList>) MybatisUtils.executeQuery(sqlSession -> sqlSession.selectList(
                "speciallistmapper.selectSpecialListWhite"));

        return list;
    }

    public List<SpecialList> selectSpecialListBlack(){
        List<SpecialList> list=  (List<SpecialList>) MybatisUtils.executeQuery(sqlSession -> sqlSession.selectList(
                "speciallistmapper.selectSpecialListBlack"));

        return list;
    }

    public Object insertUserSpecialList(SpecialList specialList){
        Object num = MybatisUtils.executeUpdate(sqlSession -> sqlSession.insert("speciallistmapper.insertUserSpecialList",specialList));

        return num;
    }
    public SpecialList selectSpecialListByUserName(String userName){
        SpecialList specialList=  (SpecialList) MybatisUtils.executeQuery(sqlSession -> sqlSession.selectOne(
                "speciallistmapper.selectSpecialListByUserName", userName));

        return specialList;
    }
    public SpecialList selectSpecialListByVRN(String VRN){
        SpecialList specialList=  (SpecialList) MybatisUtils.executeQuery(sqlSession -> sqlSession.selectOne(
                "speciallistmapper.selectSpecialListByVRN", VRN));

        return specialList;
    }

    public Object deleteUserSpecialList(String slId){
        Object num = MybatisUtils.executeUpdate(sqlSession -> sqlSession.delete("speciallistmapper.deleteSpecialListBySLId",slId));

        return num;
    }
}
