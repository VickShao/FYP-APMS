package com.tudublin.apms.service;

import com.tudublin.apms.entity.SpecialList;
import org.junit.Test;
import java.util.List;

public class SpecialListServiceTest {
    SpecialListService specialListService = new SpecialListService();
    @Test
    public void selectSpecialListWhite() {
        List<SpecialList> specialLists = specialListService.selectSpecialListWhite();
        for(SpecialList n:specialLists){
            System.out.println(n.getVehicleRegNum());
        }
    }

    @Test
    public void selectSpecialListBlack() {
        List<SpecialList> specialLists = specialListService.selectSpecialListBlack();
        for(SpecialList n:specialLists){
            System.out.println(n.getComment());
        }
    }

    @Test
    public void insertUserSpecialList() {
        SpecialList specialList = new SpecialList();
        specialList.setUserName("1");
        specialList.setComment("1");
        specialList.setVehicleRegNum("1");
        Object num = specialListService.insertUserSpecialList(specialList);

            System.out.println(specialList.getSlId());

    }
    @Test
    public void deleteUserSpecialList() {

        Object num = specialListService.deleteUserSpecialList("aaaaaaaa");

        System.out.println(num);

    }
}