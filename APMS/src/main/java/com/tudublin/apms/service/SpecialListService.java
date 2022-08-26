package com.tudublin.apms.service;

import com.tudublin.apms.entity.ParkingRecord;
import com.tudublin.apms.entity.SpecialList;
import com.tudublin.apms.entity.User;
import com.tudublin.apms.entity.UserVRN;
import com.tudublin.apms.mapper.SpecialListMapper;
import com.tudublin.apms.mapper.UserMapper;
import com.tudublin.apms.service.exception.CheckException;
import com.tudublin.apms.service.exception.LoginException;

import java.util.List;

public class SpecialListService {
    SpecialListMapper specialListMapper = new SpecialListMapper();
    UserService userService = new UserService();
    UserMapper userMapper = new UserMapper();
    UserVRNService userVRNService = new UserVRNService();
    public List<SpecialList> selectSpecialListWhite(){
        return specialListMapper.selectSpecialListWhite();
    }
    public List<SpecialList> selectSpecialListBlack(){
        return specialListMapper.selectSpecialListBlack();
    }
    public Object insertUserSpecialList(SpecialList specialList){
        return specialListMapper.insertUserSpecialList(specialList);
    }
    public Object deleteUserSpecialList(String slId){
        return specialListMapper.deleteUserSpecialList(slId);
    }


    public void checkUser(String userName,String VRN){
        if(userName.equals("")&&VRN.equals("")){
            throw new CheckException("Must input Username or Vehicle Reg No.");
        }

        if(!userName.equals("")){
            User user = userMapper.selectByUsername(userName);
            if(user == null){
                throw new CheckException("User not Exist");
            }
            SpecialList specialList = new SpecialListMapper().selectSpecialListByUserName(userName);
            if(specialList != null){
                throw new CheckException("User Exist in Special List");
            }
            if(!VRN.equals("")){
                User user1 = userService.selectByUsername(userName);
                Long did = user1.getDetailsId();
                List<UserVRN> userVRNList = userVRNService.selectByDid(did);
                int i = 0;
                for (UserVRN u:userVRNList) {
                    if(u.getVehicleRegNo().equals(VRN)){
                        i = i+1;
                    }
                }
                if(i==0){
                    throw new CheckException("This user didn't saved this vehicle reg No.");
                }
            }
        }
        if(!VRN.equals("")){
            SpecialList specialList2 = new SpecialListMapper().selectSpecialListByVRN(VRN);
            if(specialList2 != null){
                throw new CheckException("This vehcile Reg No. Exist in Special List");
            }
        }





    }
}
