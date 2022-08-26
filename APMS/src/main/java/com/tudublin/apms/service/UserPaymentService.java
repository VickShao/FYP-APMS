package com.tudublin.apms.service;

import com.tudublin.apms.entity.UserPayment;
import com.tudublin.apms.entity.UserVRN;
import com.tudublin.apms.mapper.UserPaymentMapper;
import com.tudublin.apms.mapper.UserVRNMapper;
import com.tudublin.apms.service.exception.LoginException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserPaymentService {
    private UserPaymentMapper userPaymentMapper = new UserPaymentMapper();

    public Object insertUserPayment(UserPayment userPayment){return userPaymentMapper.insertUserPayment(userPayment);}

    public List<UserPayment> selectByDid(Long detailsId){ return userPaymentMapper.selectByDid(detailsId);}

    public Object deletePaymentByDpId(Long dpId){
        return userPaymentMapper.deletePaymentByDpId(dpId);
    }

    public void checkPaymentInfo(String cardNo, String cardName, String expiredDate, String cvv){

        cardNo = cardNo.replaceAll("[^0-9]", "");
        System.out.println(cardNo);
        Pattern p = Pattern.compile("[1-9]\\d{15}(?!\\d)");
        Matcher m = p.matcher(cardNo);
        if(!m.matches()){
            throw new LoginException("Card Number is not valid");
        }

        Pattern p3 = Pattern.compile("^((?:[A-Za-z]+ ?){1,3})$");
        Matcher m3 = p3.matcher(cardName);
        if(!m3.matches()){
            throw new LoginException("Card Name is not valid");
        }



        Pattern p1 = Pattern.compile("(?:0[1-9]|1[0-2])/[0-9]{2}");
        Matcher m1 = p1.matcher(expiredDate);

        if(!m1.matches()){
            throw new LoginException("Expired Date is not valid");
        }

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/yy");
        simpleDateFormat.setLenient(false);
        Date expiry = null;
        try {
            expiry = simpleDateFormat.parse(expiredDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        boolean expired = expiry.before(new Date());

        if(expired){
            throw new LoginException("Card is expired");
        }

        Pattern p2 = Pattern.compile("^[0-9]{3,4}$");
        Matcher m2 = p2.matcher(cvv);
        if(!m2.matches()){
            throw new LoginException("CVV is not valid");
        }
    }
}
