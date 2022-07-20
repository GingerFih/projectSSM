package com.ser;

import com.db.MysqlUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "UloginServlet", value = "/UloginServlet")
public class UloginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/json:charset=utf-8");

        String name = request.getParameter("name");
        String password = request.getParameter("password");
//        System.out.println(name + " " + password);

        //创建和获取session
        HttpSession session = request.getSession();
        session.setAttribute("username","username");
        

        String sql = "SELECT * FROM user WHERE nickname  = \"" + name + "\" and password = \"" + password + "\"";
        String[] colums = {"id", "nickname", "password"};
        ArrayList<String[]> arrayList = MysqlUtil.showUtil(sql, colums);
//        System.out.println(arrayList.get(0)[0]);
//        System.out.println(arrayList.get(0)[1]);
//        System.out.println(arrayList.get(0)[2]);

        String json = "";
        if (arrayList.get(0)[1].equals("admin") && arrayList.get(0)[2].equals("123456")) {
            json = "{\"code\":666,\"message\":\"管理员\"}";
        } else {

            if (arrayList.size() == 0) {
                json = "{\"code\":0,\"message\":\"查无此人\"}";
            } else if (arrayList.size() == 1) {
                json = "{\"code\":1,\"message\":\"查询成功\"}";
                String id = arrayList.get(0)[0];
                Cookie cookie = new Cookie("userId", id);
                cookie.setMaxAge(60 * 60);
                response.addCookie(cookie);
            } else {
                json = "{\"code\":-1,\"message\":\"数据库错误\"}";
            }
        }
        response.getWriter().write(json);
    }
}
