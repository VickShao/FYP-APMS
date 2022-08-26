package com.tudublin.apms.service;

import com.tudublin.apms.entity.Node;
import org.junit.Test;

import java.util.List;

public class RbacServiceTest {
    private RbacService rbacService = new RbacService();
    @Test
    public void selectNodeByUserId1() {
        List<Node> nodes = rbacService.selectNodeByUserId(1l);
        for(Node n:nodes){
            System.out.println(n.getNodeName());
        }
    }
}