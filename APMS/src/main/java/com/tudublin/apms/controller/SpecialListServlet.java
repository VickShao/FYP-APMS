package com.tudublin.apms.controller;

import com.tudublin.apms.entity.ParkingRecord;
import com.tudublin.apms.entity.SpecialList;
import com.tudublin.apms.service.SpecialListService;
import com.tudublin.apms.utils.ResponseUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/api/special_list")
public class SpecialListServlet extends HttpServlet {
    private SpecialListService specialListService = new SpecialListService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json;charset=utf-8");

        String options = request.getParameter("options");

        ResponseUtils resp = null;

        try {
            List<SpecialList> specialList = null;
            if (options.equals("white")) {
                specialList = specialListService.selectSpecialListWhite();
            }
            if (options.equals("black")) {
                specialList = specialListService.selectSpecialListBlack();
            }

            //处理结果编码，0代表处理成功，非0代表处理失败
            resp = new ResponseUtils().put("specialList",specialList);

        }catch (Exception e){
            e.printStackTrace();
            resp = new ResponseUtils(e.getClass().getSimpleName(),e.getMessage());
        }

        //返回JSON结果

        response.getWriter().println(resp.toJsonStringWithNull());
    }
}
