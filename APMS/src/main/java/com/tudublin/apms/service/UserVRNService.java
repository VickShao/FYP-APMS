package com.tudublin.apms.service;

import com.tudublin.apms.entity.UserVRN;
import com.tudublin.apms.mapper.UserVRNMapper;

import java.util.List;

public class UserVRNService {
    private UserVRNMapper userVRNMapper = new UserVRNMapper();

    public Object insertUserVRN(UserVRN userVRN){return userVRNMapper.insertUserVRN(userVRN);}

    public List<UserVRN> selectByDid(Long detailsId){ return userVRNMapper.selectByDid(detailsId);}

    public Object deleteVRNByDvId(Long dvId){
        return userVRNMapper.deleteVRNByDvId(dvId);
    }

}
