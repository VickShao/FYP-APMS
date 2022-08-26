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

@WebServlet("/api/add_user_payment")
public class AddUserPaymentServlet extends HttpServlet {
    private UserPaymentService userPaymentService = new UserPaymentService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json;charset=utf-8");

        String did = request.getParameter("did");
        String cardNo = request.getParameter("cardNo");
        String cardName = request.getParameter("cardName");
        String expiredDate = request.getParameter("expiredDate");
        String cvv = request.getParameter("cvv");

        ResponseUtils resp = null;

        try {
            userPaymentService.checkPaymentInfo(cardNo,cardName,expiredDate,cvv);

            UserPayment userPayment = new UserPayment();

            userPayment.setCardNo(cardNo);
            userPayment.setCvv(cvv);
            userPayment.setDetailsId(Long.parseLong(did));
            userPayment.setExpiredDate(expiredDate);
            userPayment.setCardName(cardName);

            userPaymentService.insertUserPayment(userPayment);

            resp = new ResponseUtils().put("message","add success");
        }catch (Exception e){
            e.printStackTrace();
            resp = new ResponseUtils(e.getClass().getSimpleName(),e.getMessage());
        }

        //返回JSON结果
        response.getWriter().println(resp.toJsonString());



    }
}
