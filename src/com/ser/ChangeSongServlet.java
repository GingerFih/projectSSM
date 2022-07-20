package com.ser;

import com.db.MysqlUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ChangeServlet", value = "/add&update")
public class ChangeSongServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/json;charset=utf-8");
        String operation = request.getParameter("operation");
        String songType = request.getParameter("songType");
        String songName = request.getParameter("songName");
        String songAuthor = request.getParameter("songAuthor");
        String songTime = request.getParameter("songTime");
        String songPrice = request.getParameter("songPrice");
        String typeint =request.getParameter("typeint");
        System.out.println("类型数字是："+typeint);
        String json ="";
        //添加时执行下面语句
        if(operation.equals("add")){
            String sql = "insert into songinform(typename,songname,singer,time,price,typeint,tag)values(\""+songType+"\",\""+songName+"\",\""+songAuthor+"\",\""+songTime+"\",\""+songPrice+"\","+typeint+",1);";
            int count = MysqlUtil.add(sql);

            if(count ==1){
                json=" {\"code\":1,\"message\":\"上传成功\"}";
            }else {
                json =" {\"code\":0,\"message\":\"上传失败\"}";
            }
        }
        //修改数据时执行下面语句
        else {
            String id = request.getParameter("id");
            String sql ="update songinform set typename = '"+songType+"',songname ='"+songName+"',singer='"+songAuthor+"',time='"+songTime+"',price ='"+songPrice+"',typeint ="+typeint+",tag =1 WHERE id ="+id;
            int count = MysqlUtil.update(sql);
            if(count ==1){
                json=" {\"code\":1,\"message\":\"修改成功\"}";
            }else {
                json =" {\"code\":0,\"message\":\"修改失败\"}";
            }
        }
        response.getWriter().write(json);


    }
}
