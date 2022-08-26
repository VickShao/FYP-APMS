package com.tudublin.apms.controller;

import com.tudublin.apms.service.UserPaymentService;
import com.tudublin.apms.utils.ResponseUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/api/delete_user_payment")
public class DeleteUserPaymentServlet extends HttpServlet {
    private UserPaymentService userPaymentService = new UserPaymentService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json;charset=utf-8");
        String dpId = request.getParameter("dpId");

        ResponseUtils resp = null;

        try {
            userPaymentService.deletePaymentByDpId(Long.parseLong(dpId));

            resp = new ResponseUtils().put("message","delete success");

        }catch (Exception e){
            e.printStackTrace();
            resp = new ResponseUtils(e.getClass().getSimpleName(),e.getMessage());
        }

        //返回JSON结果
        response.getWriter().println(resp.toJsonString());

    }
}
