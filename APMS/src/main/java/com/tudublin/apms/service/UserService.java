package com.tudublin.apms.service;


import com.tudublin.apms.entity.Details;
import com.tudublin.apms.entity.User;
import com.tudublin.apms.entity.UserVRN;
import com.tudublin.apms.mapper.UserMapper;
import com.tudublin.apms.service.exception.LoginException;
import com.tudublin.apms.utils.Md5Utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class UserService {
    private UserMapper userMapper = new UserMapper();

    /**
     * 根据前台输入进行登录校验
     * @param username 前台输入的用户名
     * @param password 前台输入的密码
     * @return
     */
    public User checkLogin(String username, String password){
        User user = userMapper.selectByUsername(username);
        if(user == null){
            throw new LoginException("User not exist");
        }
        String md5 = Md5Utils.md5Digest(password,user.getSalt());
        if(!md5.equals(user.getPassword())){
            throw new LoginException("Password incorrect ");
        }
        return user;
    }

    public void checkRegister(String username, String password, String password2, String email, String phone){
        User user = userMapper.selectByUsername(username);
        if(user != null){
            throw new LoginException("Username exist");
        }
        if(!password.equals(password2)){
            throw new LoginException("Password not same");
        }
        Pattern p = Pattern.compile("\\w{3,15}@(\\w{2,8}\\.){1,2}(com|net|cn)");
        Matcher m = p.matcher(email);
        if(!m.matches()){
            throw new LoginException("Email is not valid");
        }
        Pattern p2 = Pattern.compile("\\d{10}|\\(\\d{3}\\)\\d{3}-\\d{4}|\\d{3}-\\d{3}-\\d{4}");
        Matcher m2 = p.matcher(phone);
        if(!m2.matches()){
            throw new LoginException("Phone number is not valid");
        }


    }

    public Object insertSysUser(User user){
        return userMapper.insertSysUser(user);
    }
    public Object insertUserRole(Long userId){
        return userMapper.insertUserRole(userId);
    }
    public User selectByUsername(String username){ return userMapper.selectByUsername(username); }
}
