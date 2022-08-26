package com.tudublin.apms.controller;



import com.tudublin.apms.entity.Details;
import com.tudublin.apms.entity.User;
import com.tudublin.apms.entity.UserVRN;
import com.tudublin.apms.service.DetailsService;
import com.tudublin.apms.service.UserService;
import com.tudublin.apms.service.UserVRNService;
import com.tudublin.apms.utils.Md5Utils;
import com.tudublin.apms.utils.ResponseUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import java.util.Random;

@WebServlet("/api/register")
public class RegisterServlet extends HttpServlet {
    private UserService userService = new UserService();
    private DetailsService detailsService = new DetailsService();
    private UserVRNService userVRNService = new UserVRNService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json;charset=utf-8");

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String password2 = request.getParameter("password2");
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String number = request.getParameter("number");
        String vrn = request.getParameter("vrn");

        ResponseUtils resp = null;
        try {
            userService.checkRegister(username, password, password2, email, number);

            User user = new User();
            Details details = new Details();
            UserVRN userVRN = new UserVRN();

            details.setEmail(email);
            details.setName(name);
            details.setPhone(number);

            detailsService.insertUserDetails(details);
            Long detailsId = details.getDetailsId();

            Integer salt = (int)(Math.random()*200+1);
            String password_md5 =  Md5Utils.md5Digest(password,salt);

            user.setPassword(password_md5);
            user.setSalt(salt);
            user.setUsername(username);
            user.setDetailsId(detailsId);

            userService.insertSysUser(user);
            Long userId = user.getUserId();

            userService.insertUserRole(userId);

            userVRN.setDetailsId(detailsId);
            userVRN.setVehicleRegNo(vrn);

            userVRNService.insertUserVRN(userVRN);

            //处理结果编码，0代表处理成功，非0代表处理失败
//            resp = new ResponseUtils().put("user",user);
            resp = new ResponseUtils().put("message","add success");

        }catch (Exception e){
            e.printStackTrace();
            resp = new ResponseUtils(e.getClass().getSimpleName(),e.getMessage());
        }
        //返回JSON结果

        response.getWriter().println(resp.toJsonString());




    }
}
