package com.tudublin.apms.controller;

import com.tudublin.apms.entity.SpecialList;
import com.tudublin.apms.entity.User;
import com.tudublin.apms.service.SpecialListService;
import com.tudublin.apms.utils.ResponseUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/api/add_user_SL")
public class AddUserSLServlet extends HttpServlet {
    private SpecialListService specialListService = new SpecialListService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json;charset=utf-8");

        String userName = request.getParameter("userName");
        String vehicleRegNum = request.getParameter("vehicleRegNum");
        String comment = request.getParameter("comment");
        int status = Integer.parseInt(request.getParameter("status"));
        Boolean s = status!=0;

        ResponseUtils resp = null;
        try {
            specialListService.checkUser(userName, vehicleRegNum);
            SpecialList specialList = new SpecialList();
            specialList.setUserName(userName);
            specialList.setVehicleRegNum(vehicleRegNum);
            specialList.setComment(comment);
            specialList.setStatus(s);
            specialListService.insertUserSpecialList(specialList);
            resp = new ResponseUtils().put("message","add success");
        }catch (Exception e){
            e.printStackTrace();
            resp = new ResponseUtils(e.getClass().getSimpleName(),e.getMessage());
        }

        //返回JSON结果
        response.getWriter().println(resp.toJsonString());
    }

}
