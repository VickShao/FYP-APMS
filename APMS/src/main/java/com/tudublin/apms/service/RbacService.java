package com.tudublin.apms.service;

import com.tudublin.apms.entity.Node;
import com.tudublin.apms.mapper.RbacMapper;

import java.util.List;

public class RbacService {
    private RbacMapper rbacMapper = new RbacMapper();
    public List<Node> selectNodeByUserId(Long userId){
        return rbacMapper.selectNodeByUserId(userId);
    }
}
