package com.ser;

import com.db.MysqlUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "SearchServlet", value = "/search")
public class SearchSongServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/json;charset=utf-8");

//      user是1是管理员，user是0是用户；
        String user = request.getParameter("user");
//      System.out.println(user);
//      管理员查询显示
        if(user.equals("1")){
            String sql = "select * from songinform where tag = 1";
            String[] colums = {"id","typename","songname","singer","time","price"};
            String json = MysqlUtil.getJsonBySql(sql,colums);
            System.out.println(json);
            response.getWriter().write(json);
        }
        //普通用户查询显示
        else {

        }


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
