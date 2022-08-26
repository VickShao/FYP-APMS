package com.tudublin.apms.controller;

import com.tudublin.apms.entity.ParkingRecord;
import com.tudublin.apms.entity.SpecialList;
import com.tudublin.apms.entity.UserVRN;
import com.tudublin.apms.service.ParkingRecordService;
import com.tudublin.apms.service.UserVRNService;
import com.tudublin.apms.utils.ResponseUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/api/driver_parking_history_unpaid")
public class DriverParkingHistoryUnpaid extends HttpServlet {
    private ParkingRecordService parkingRecordService = new ParkingRecordService();
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
        String vrninput = request.getParameter("vrn");
        ResponseUtils resp = null;

        try {
            List<ParkingRecord> parkingRecords = new ArrayList<ParkingRecord>();

            if(vrninput==null){
                List<UserVRN> userVRNList = userVRNService.selectByDid(Long.parseLong(did));

                for (UserVRN u:userVRNList) {
                    String vrn = u.getVehicleRegNo();
                    List<ParkingRecord> parkingRecordList = parkingRecordService.selectUnpaidParkingRecordByVRN(vrn);
                    parkingRecords.addAll(parkingRecordList);
                }
            }else{

                parkingRecords = parkingRecordService.selectUnpaidParkingRecordByVRN(vrninput);
            }


            //处理结果编码，0代表处理成功，非0代表处理失败
            resp = new ResponseUtils().put("parkingHistoryList",parkingRecords);

        }catch (Exception e){
            e.printStackTrace();
            resp = new ResponseUtils(e.getClass().getSimpleName(),e.getMessage());
        }

        //返回JSON结果

        response.getWriter().println(resp.toJsonStringWithNull());






    }

}
