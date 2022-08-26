package com.tudublin.apms.controller;

import com.tudublin.apms.entity.ParkingRecord;
import com.tudublin.apms.entity.User;
import com.tudublin.apms.service.ParkingRecordService;
import com.tudublin.apms.utils.ResponseUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/api/all_parking_record")
public class ParkingRecordServlet extends HttpServlet {
    private ParkingRecordService parkingRecordService = new ParkingRecordService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json;charset=utf-8");
        //接受输入
        int options = Integer.parseInt(request.getParameter("options"));//0-all 1-paid 2-unpaid

        //调用业务逻辑
        ResponseUtils resp = null;

        try {
            List<ParkingRecord> parkingRecord = null;
            if (options==0) {
                parkingRecord = parkingRecordService.selectAllParkingRecord();
            }
            if (options==1) {
                parkingRecord = parkingRecordService.selectPaidParkingRecord();
            }
            if (options==2) {
                parkingRecord = parkingRecordService.selectUnpaidParkingRecord();
            }

            //处理结果编码，0代表处理成功，非0代表处理失败
            resp = new ResponseUtils().put("parkingRecord",parkingRecord);

        }catch (Exception e){
            e.printStackTrace();
            resp = new ResponseUtils(e.getClass().getSimpleName(),e.getMessage());
        }
        //返回JSON结果

        response.getWriter().println(resp.toJsonStringWithNull());
    }

}
