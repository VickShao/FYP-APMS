package com.tudublin.apms.controller;

import com.tudublin.apms.entity.UserPayment;
import com.tudublin.apms.entity.UserVRN;
import com.tudublin.apms.service.UserPaymentService;
import com.tudublin.apms.utils.ResponseUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/api/user_payment")
public class UserPaymentServlet extends HttpServlet {
    private UserPaymentService userPaymentService = new UserPaymentService();

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
            List<UserPayment> userPaymentList = userPaymentService.selectByDid(Long.parseLong(did));
            for (UserPayment u:userPaymentList) {
                u.setCvv(null);
                u.setCardNo("****"+u.getCardNo().substring(u.getCardNo().length()-4));
            }
            //处理结果编码，0代表处理成功，非0代表处理失败
            resp = new ResponseUtils().put("userPaymentList",userPaymentList);

        }catch (Exception e){
            e.printStackTrace();
            resp = new ResponseUtils(e.getClass().getSimpleName(),e.getMessage());
        }

        response.getWriter().println(resp.toJsonStringWithNull());
    }
}
