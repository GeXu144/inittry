package cn.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/cookieServlet2")
public class CookieServlet2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Date date=new Date();
        SimpleDateFormat sim=new SimpleDateFormat("yyyy年MM月dd日HH:mm:ss");
        String value = sim.format(date);
        Cookie cookie=new Cookie("lastTime",value);
        cookie.setMaxAge(30*24*60*60);//设置保存一个月
        response.addCookie(cookie);
        //设置编码格式
       response.setContentType("text/html;charset=utf-8");
        Cookie[] cookies = request.getCookies();
        boolean flag=false;//没有cookie为lastTime
        if (cookies!=null&& cookies.length>0){
            for (Cookie cookie1 : cookies) {
                String name = cookie1.getName();
                if ("lastTime".equals(name)){

                   flag=true;//有lastTime的cookie
                    String value1 = cookie1.getValue();
                    response.getWriter().write("<h1>欢迎回来，您上次访问的时间为："+value1+"</h1>");
                    break;
                }
            }
        }
        if (cookies==null && cookies.length==0 || flag==false){
            response.getWriter().write("<h1>欢迎您，第一次访问！</h1>");

        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
