package com.tudublin.apms.mapper;

import com.tudublin.apms.entity.UserPayment;
import com.tudublin.apms.utils.MybatisUtils;

import java.util.List;

public class UserPaymentMapper {
    public Object insertUserPayment(UserPayment userPayment){
        Object num = MybatisUtils.executeUpdate(sqlSession -> sqlSession.insert("userpaymentmapper.insertUserPayment",userPayment));
        return num;
    }

    public List<UserPayment> selectByDid(Long detailsId){
        List<UserPayment> list=  (List<UserPayment>) MybatisUtils.executeQuery(sqlSession -> sqlSession.selectList(
                "userpaymentmapper.selectPayment",detailsId));

        return list;
    }

    public Object deletePaymentByDpId(Long dpId){
        Object num = MybatisUtils.executeUpdate(sqlSession -> sqlSession.delete("userpaymentmapper.deletePaymentByDpId",dpId));

        return num;
    }

}
