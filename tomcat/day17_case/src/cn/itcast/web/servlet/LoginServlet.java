package cn.itcast.web.servlet;

import cn.itcast.domain.User;
import cn.itcast.service.UserService;
import cn.itcast.service.impl.UserServiceImpl;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.设置编码
        request.setCharacterEncoding("utf-8");
        //2.获取数据
        //2.1获取用户填写的验证码
        String verifycode = request.getParameter("verifycode");
        //2.2.验证码校验
        HttpSession session = request.getSession();
        String checkCode_session = (String) session.getAttribute("checkCode_session");//程序生成的验证码
        session.removeAttribute("checkCode_session");//确保验证码一次性
        if (!checkCode_session.equals(verifycode)){
            //验证码错误
            //提示信息
           session.setAttribute("login_mistake","验证码错误！");
            //跳转到登录页面
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }else {
            User user=new User();
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            user.setUsername(username);
            user.setPassword(password);
            //5.调用service查询
            UserService service=new UserServiceImpl();
            User loginuser = service.login(user);
            //6.判断是否登录成功
            if (loginuser!=null){
                //登录成功
                //将user存入session
                session.setAttribute("loginuser",loginuser);
                //7.跳转到index.jsp
                response.sendRedirect(request.getContextPath()+"/index.jsp");
            }else {
                //失败
                request.getSession().setAttribute("login_mistake","用户名或者密码错误！");
                //跳转到登录页面
                request.getRequestDispatcher("/login.jsp").forward(request,response);
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
