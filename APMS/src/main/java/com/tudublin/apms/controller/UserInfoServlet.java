package com.tudublin.apms.controller;

import com.tudublin.apms.entity.Details;
import com.tudublin.apms.entity.Node;
import com.tudublin.apms.service.DetailsService;
import com.tudublin.apms.service.RbacService;
import com.tudublin.apms.utils.ResponseUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/api/user_info")
public class UserInfoServlet extends HttpServlet {
    private RbacService rbacService = new RbacService();
    private DetailsService detailsService = new DetailsService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uid = request.getParameter("uid");
        String did = request.getParameter("did");
//        rbacService.selectNodeByUserId(Long.parseLong(uid));
        List<Node> nodes = rbacService.selectNodeByUserId(Long.parseLong(uid));
        List<Map> treeList = new ArrayList<>();
        Map module = null;
        for(Node node:nodes){
            if(node.getNodeType() == 1){
                module = new LinkedHashMap();
                module.put("node",node);
                module.put("children", new ArrayList());
                treeList.add(module);
            }else if(node.getNodeType() == 2){
                List children = (List)module.get("children");
                children.add(node);
            }
        }
        Details details = detailsService.selectById(Long.parseLong(did));
        String json = new ResponseUtils().put("nodeList", treeList).put("details", details).toJsonString();
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().println(json);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
