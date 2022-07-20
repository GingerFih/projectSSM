package com.lim;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "LimServlet", value = "/limit")
public class LimServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/json;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        String json = "";

        if(username != null){
            json="{\"code\":1,\"message\":\"成功\"}";
        }
        else {
            json="{\"code\":0,\"message\":\"失败\"}";
        }
        response.getWriter().write(json);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
