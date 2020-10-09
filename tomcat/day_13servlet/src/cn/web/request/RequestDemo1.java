package cn.web.request;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * request对象获取请求行数据
 *
 */
@WebServlet( "/requestDemo1")
public class RequestDemo1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取请求方式，GET，调用getMethod()方法
        String method = request.getMethod();
        System.out.println(method);

        //2.获取虚拟目录，调用getContextPath()方法
        String contextPath = request.getContextPath();
        System.out.println(contextPath);

        //3.获取Servlet路径,调用getServletPath()方法
        String servletPath = request.getServletPath();
        System.out.println(servletPath);

        //4.获取get请求的参数
        String queryString = request.getQueryString();
        System.out.println(queryString);

        //5.获取URI,getRequestURI()
        String requestURI = request.getRequestURI();
        StringBuffer requestURL = request.getRequestURL();
        System.out.println(requestURI);
        System.out.println(requestURL);

        //6.获取协议版本
        String protocol = request.getProtocol();
        System.out.println(protocol);

        //7.获取IP
        String remoteAddr = request.getRemoteAddr();
        System.out.println(remoteAddr);
    }
}
