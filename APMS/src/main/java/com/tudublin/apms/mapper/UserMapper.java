package com.tudublin.apms.mapper;

import com.tudublin.apms.entity.Details;
import com.tudublin.apms.entity.User;
import com.tudublin.apms.entity.UserVRN;
import com.tudublin.apms.utils.MybatisUtils;

public class UserMapper {
    public User selectByUsername(String username){
        User user = (User)MybatisUtils.executeQuery(sqlSession-> sqlSession.selectOne("usermapper.selectByUsername", username));
        return user;
    }

    public Object insertSysUser(User user){
        Object num = MybatisUtils.executeUpdate(sqlSession -> sqlSession.insert("usermapper.insertSysUser",user));
        return num;
    }

    public Object insertUserRole(Long userId){
        Object num = MybatisUtils.executeUpdate(sqlSession -> sqlSession.insert("usermapper.insertUserRole",userId));
        return num;
    }
}
