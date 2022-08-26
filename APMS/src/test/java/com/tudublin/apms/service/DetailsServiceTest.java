package com.tudublin.apms.service;

import com.tudublin.apms.entity.Details;
import org.junit.Test;

import static org.junit.Assert.*;

public class DetailsServiceTest {

    @Test
    public void selectById() {
        DetailsService detailsService = new DetailsService();
        Details details = detailsService.selectById(1l);
        System.out.println(details);
    }
}