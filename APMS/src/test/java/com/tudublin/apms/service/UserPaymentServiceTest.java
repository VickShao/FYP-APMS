package com.tudublin.apms.service;

import com.tudublin.apms.entity.UserPayment;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class UserPaymentServiceTest {

    @Test
    public void insertUserPayment() {
    }

    @Test
    public void selectByDid() {
        UserPaymentService userPaymentService = new UserPaymentService();
        List<UserPayment> list = userPaymentService.selectByDid(20l);
        System.out.println(list);
    }

    @Test
    public void deletePaymentByDvId() {
    }
}