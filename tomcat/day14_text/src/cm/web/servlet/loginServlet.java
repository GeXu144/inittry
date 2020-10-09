package cm.web.servlet;

import cm.dao.UserDao;
import cm.daomain.User;
import org.apache.commons.beanutils.BeanUtils;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.设置编码
        request.setCharacterEncoding("utf-8");
        /*String username = request.getParameter("username");
        String password = request.getParameter("password");
        User loginuser=new User();
        loginuser.setUsername(username);
        loginuser.setPassword(password);*/
       //2.获取所有请求参数
        Map<String, String[]> map = request.getParameterMap();
        //3.设置空User
        User loginuser=new User();
        //4.使用BeanUtils封装对象
        try {
            BeanUtils.populate(loginuser,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        //4.调用login方法
        UserDao dao=new UserDao();
        User user = dao.login(loginuser);
        //5.判断
        if (user!=null){
            //登录成功，储存数据然后转发到successServlet
            request.setAttribute("user",user);
            request.getRequestDispatcher("/successServlet").forward(request,response);
            //登录失败，转到failServlet
            request.getRequestDispatcher("/failServlet").forward(request,response);
        }else {
            //登录失败，转到failServlet
            request.getRequestDispatcher("/failServlet").forward(request,response);

        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
