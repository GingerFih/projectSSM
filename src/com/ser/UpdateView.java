package com.ser;

import com.db.MysqlUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "UpdateView", value = "/view")
public class UpdateView extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/json;charset=utf-8");
        String id =request.getParameter("id");
        String sql = "select * from songinform where id = "+id;
        String[] colums ={"typename","songname","singer","time","price"};
        String json= MysqlUtil.getJsonBySql(sql,colums);
        response.getWriter().write(json);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
