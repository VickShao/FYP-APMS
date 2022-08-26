package com.tudublin.apms.mapper;

import com.tudublin.apms.entity.SpecialList;
import com.tudublin.apms.entity.User;
import com.tudublin.apms.entity.UserVRN;
import com.tudublin.apms.utils.MybatisUtils;

import java.util.List;

public class UserVRNMapper {
    public Object insertUserVRN(UserVRN userVRN){
        Object num = MybatisUtils.executeUpdate(sqlSession -> sqlSession.insert("uservrnmapper.insertUserVRN",userVRN));
        return num;
    }

    public List<UserVRN> selectByDid(Long detailsId){
        List<UserVRN> list=  (List<UserVRN>) MybatisUtils.executeQuery(sqlSession -> sqlSession.selectList(
                "uservrnmapper.selectVRNByDid",detailsId));

        return list;
    }

    public Object deleteVRNByDvId(Long dvId){
        Object num = MybatisUtils.executeUpdate(sqlSession -> sqlSession.delete("uservrnmapper.deleteVRNByDvId",dvId));

        return num;
    }
}
