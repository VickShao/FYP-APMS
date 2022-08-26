package com.tudublin.apms.mapper;

import com.tudublin.apms.entity.Details;
import com.tudublin.apms.entity.SpecialList;
import com.tudublin.apms.utils.MybatisUtils;

import java.util.List;

public class DetailsMapper {

    public Details selectDetailsById(Long details_Id){
        Details details = (Details)MybatisUtils.executeQuery(sqlSession -> sqlSession.selectOne("detailsMapper.selectById", details_Id));
        return details;
    }

    public Object insertUserDetails(Details details){
        Object num = MybatisUtils.executeUpdate(sqlSession -> sqlSession.insert("detailsMapper.insertUserDetails",details));
        return num;
    }
}
