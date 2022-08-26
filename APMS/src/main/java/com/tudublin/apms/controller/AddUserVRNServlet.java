package com.tudublin.apms.controller;

import com.tudublin.apms.entity.SpecialList;
import com.tudublin.apms.entity.UserVRN;
import com.tudublin.apms.service.UserVRNService;
import com.tudublin.apms.utils.ResponseUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/api/add_user_VRN")
public class AddUserVRNServlet extends HttpServlet {
    private UserVRNService userVRNService= new UserVRNService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json;charset=utf-8");

        String did = request.getParameter("did");
        String vehicleRegNum = request.getParameter("vehicleRegNum");
        String comment = request.getParameter("comment");

        ResponseUtils resp = null;

        try {

            UserVRN userVRN = new UserVRN();
            userVRN.setDetailsId(Long.parseLong(did));
            userVRN.setVehicleRegNo(vehicleRegNum);
            userVRN.setComment(comment);

            userVRNService.insertUserVRN(userVRN);

            resp = new ResponseUtils().put("message","add success");
        }catch (Exception e){
            e.printStackTrace();
            resp = new ResponseUtils(e.getClass().getSimpleName(),e.getMessage());
        }

        //返回JSON结果
        response.getWriter().println(resp.toJsonString());
    }
}
