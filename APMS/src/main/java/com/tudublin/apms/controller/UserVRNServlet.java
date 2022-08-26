package com.tudublin.apms.controller;

import com.tudublin.apms.entity.SpecialList;
import com.tudublin.apms.entity.UserVRN;
import com.tudublin.apms.service.SpecialListService;
import com.tudublin.apms.service.UserVRNService;
import com.tudublin.apms.utils.ResponseUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/api/user_vrn")
public class UserVRNServlet extends HttpServlet {
    private UserVRNService userVRNService = new UserVRNService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json;charset=utf-8");

        String uid = request.getParameter("uid");
        String did = request.getParameter("did");

        ResponseUtils resp = null;

        try {
            List<UserVRN> userVRNList = userVRNService.selectByDid(Long.parseLong(did));

            //处理结果编码，0代表处理成功，非0代表处理失败
            resp = new ResponseUtils().put("userVRNList",userVRNList);

        }catch (Exception e){
            e.printStackTrace();
            resp = new ResponseUtils(e.getClass().getSimpleName(),e.getMessage());
        }

        response.getWriter().println(resp.toJsonStringWithNull());
    }
}
