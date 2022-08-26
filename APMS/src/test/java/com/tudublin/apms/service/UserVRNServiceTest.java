package com.tudublin.apms.service;

import com.tudublin.apms.entity.UserVRN;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class UserVRNServiceTest {

    @Test
    public void selectByDid() {
        UserVRNService userVRNService = new UserVRNService();

        List<UserVRN> userVRN = userVRNService.selectByDid(21l);

        System.out.println(userVRN);

    }

    @Test
    public  void deleteBydvId() {
        UserVRNService userVRNService = new UserVRNService();

        userVRNService.deleteVRNByDvId(2l);
    }
}