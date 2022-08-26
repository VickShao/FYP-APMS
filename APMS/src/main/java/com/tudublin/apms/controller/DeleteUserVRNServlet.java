package com.tudublin.apms.controller;

import com.tudublin.apms.entity.UserVRN;
import com.tudublin.apms.service.UserVRNService;
import com.tudublin.apms.utils.ResponseUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/api/delete_user_VRN")
public class DeleteUserVRNServlet extends HttpServlet {
    private UserVRNService userVRNService = new UserVRNService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json;charset=utf-8");

        String dvId = request.getParameter("dvId");

        ResponseUtils resp = null;

        try {
            userVRNService.deleteVRNByDvId(Long.parseLong(dvId));

            resp = new ResponseUtils().put("message","delete success");

        }catch (Exception e){
            e.printStackTrace();
            resp = new ResponseUtils(e.getClass().getSimpleName(),e.getMessage());
        }

        //返回JSON结果
        response.getWriter().println(resp.toJsonString());
    }
}
