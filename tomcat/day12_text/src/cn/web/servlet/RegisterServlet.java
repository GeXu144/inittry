package cn.web.servlet;
import cn.daomain.User;
import cn.utils.JDBCUtils;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/registerServlet")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.设置编码
        request.setCharacterEncoding("utf-8");
        //2.获取所有请求参数
        Map<String, String[]> map = request.getParameterMap();
        //3.设置空User对象
        User registeruser=new User();
        //4.使用BeanUtils封装对象
        try {
            BeanUtils.populate(registeruser,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        //4.调用register方法
        int i = register(registeruser);
        if (i==1){
           //进入数据库，发送注册成功
           request.setAttribute("msg",i);//保存数据
           request.getRequestDispatcher("/successServlet1").forward(request,response);

       }else{
           request.getRequestDispatcher("/failServlet1").forward(request,response);
       }
    }
    public int register(User registerUser) {

        String sql="INSERT INTO USER (username,PASSWORD) VALUE(?,?)";
        JdbcTemplate template=new JdbcTemplate(JDBCUtils.getDataSource());
        int update = template.update(sql,registerUser.getUsername(),registerUser.getPassword());
        return update;

    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
