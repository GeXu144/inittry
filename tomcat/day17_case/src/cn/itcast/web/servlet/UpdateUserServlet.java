package cn.itcast.web.servlet;

import cn.itcast.domain.User;
import cn.itcast.service.UserService;
import cn.itcast.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/updateUserServlet")
public class UpdateUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.设置编码
        request.setCharacterEncoding("utf-8");
        //获取数据
        User user=new User();
        String id = request.getParameter("id");
        user.setId(Integer.parseInt(id));
        String name = request.getParameter("name");
        user.setUsername(name);
        String age = request.getParameter("age");
        user.setAge(age);
        String gender = request.getParameter("gender");
        user.setGender(gender);
        String address = request.getParameter("address");
        user.setAddress(address);
        String qq = request.getParameter("qq");
        user.setQq(qq);
        String email = request.getParameter("email");
        user.setEmail(email);
        //调用service修改
        UserService service=new UserServiceImpl();
        service.updateUser(user);
        //跳转到查询所有数据的Servlet
        //request.getRequestDispatcher("/userListServlet").forward(request,response);
        response.sendRedirect(request.getContextPath()+"/findUserByPageServlet");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
