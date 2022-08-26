package com.tudublin.apms.controller;

import com.tudublin.apms.entity.ParkingRecord;
import com.tudublin.apms.service.ParkingRecordService;
import com.tudublin.apms.service.UserPaymentService;
import com.tudublin.apms.utils.ResponseUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/api/payfee")
public class PayFeeServlet extends HttpServlet {
    ParkingRecordService parkingRecordService = new ParkingRecordService();
    UserPaymentService userPaymentService = new UserPaymentService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json;charset=utf-8");

        String dp_id = request.getParameter("dpId");
        String fee = request.getParameter("fee");
        String recordId = request.getParameter("recordId");
        String cardNo = request.getParameter("cardNo");
        String cardName = request.getParameter("cardName");
        String expiredDate = request.getParameter("expiredDate");
        String cvv = request.getParameter("cvv");

        //调用业务逻辑

        ResponseUtils resp = null;


        try {
            if(dp_id==null){
                userPaymentService.checkPaymentInfo(cardNo,cardName,expiredDate,cvv);
            }
            ParkingRecord parkingRecord = new ParkingRecord();
            parkingRecord.setPkRecordId(Long.parseLong(recordId));
            parkingRecord.setPayment(Float.parseFloat(fee));

            parkingRecordService.updateOneParkingRecord(parkingRecord);
            //处理结果编码，0代表处理成功，非0代表处理失败
            resp = new ResponseUtils().put("message","paid success");

        }catch (Exception e){
            e.printStackTrace();
            resp = new ResponseUtils(e.getClass().getSimpleName(),e.getMessage());
        }
        //返回JSON结果

        response.getWriter().println(resp.toJsonStringWithNull());

    }
}
