package com.ser;

import com.db.MysqlUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "UregisterServlet", value = "/UregisterServlet")
public class UregisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/json;charset=utf-8");
        String nickname = request.getParameter("nickname");
        String password = request.getParameter("password");
        String name = request.getParameter("name");
        String idcard = request.getParameter("idcard");
        String phone = request.getParameter("phone");
        String birthday = request.getParameter("birthday");
        String address = request.getParameter("address");
        System.out.println(nickname + " " + password + " " + name + " " + idcard + " " + phone + " " + birthday + " " + address);
        String json = "";
        if (nickname.equals("admin") && password.equals("123456")) {
            json = "{\"code\":-1,\"message\":\"该用户名不允许被注册,请重新输入昵称\"}";
        } else {
            String sql = "insert into user (nickname,password,name,idcard,phone,birthday,address) VALUES(\"" + nickname + "\",\"" + password + "\",\"" + name + "\",\"" + idcard + "\",\"" + phone + "\",\"" + birthday + "\",\"" + address + "\")";
            int count = MysqlUtil.add(sql);
            if (count == 1) {
                json = "{\"code\":1,\"message\":\"成功\"}";
            } else {
                json = "{\"code\":0,\"message\":\"失败\"}";
            }
        }
        response.getWriter().write(json);
    }
}
