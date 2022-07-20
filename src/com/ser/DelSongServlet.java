package com.ser;

import com.db.MysqlUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "DelSongServlet", value = "/del")
public class DelSongServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/json;charset=utf-8");
        String id = request.getParameter("id");
        System.out.println("下架歌曲的id是："+id);
        String sql = "update songinform set tag =0 where id = "+id;
        int count = MysqlUtil.update(sql);
        String json = "";

        if(count == 1){
            json ="{\"code\":1,\"message\":\"删除成功\"}";
        }else {
            json = "{\"code\":0,\"message\":\"删除失败\"}";
        }
        response.getWriter().write(json);
    }
}
