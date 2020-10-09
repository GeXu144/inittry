package cn.itcast.travel.web.servlet;

import cn.itcast.travel.domain.ResultInfo;
import cn.itcast.travel.domain.User;
import cn.itcast.travel.service.UserService;
import cn.itcast.travel.service.impl.UserServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.beanutils.BeanUtils;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/user/*")
public class UserServlet extends BaseServlet {
    private  UserService service=new UserServiceImpl();

    /**
     * 用户注册
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void regist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String check = request.getParameter("check");
        String check_server = (String) request.getSession().getAttribute("CHECKCODE_SERVER");
        request.getSession().removeAttribute("CHECKCODE_SERVER");//保证验证码的时效性，只能使用一次。
        if (check_server==null||!check_server.equalsIgnoreCase(check)){
            //不区分大小写，验证码错误
            ResultInfo info=new ResultInfo();
            info.setFlag(false);
            info.setErrorMsg("验证码错误！");
            //序列化info为json对象，发送给前端
            String json = writeValueAsString(info);
            response.setContentType("application/json;charset=utf-8");
            response.getWriter().write(json);
        }
        //1.获取数据
        Map<String, String[]> map = request.getParameterMap();
        //2.封装对象
        User user=new User();
        try {
            BeanUtils.populate(user,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        //调用service完成注册
        boolean flag=service.regist(user);
        ResultInfo info=new ResultInfo();
        //响应结果
        if (flag){
            //注册成功
            info.setFlag(true);
        }else {
            //注册失败
            info.setFlag(false);
            info.setErrorMsg("注册失败！");
        }
        //序列化info为json对象，发送给前端
        String json = writeValueAsString(info);
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(json);
    }

    /**
     * 用户登录
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取数据
        Map<String, String[]> map = request.getParameterMap();
        //封装
        User user=new User();
        try {
            BeanUtils.populate(user,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        //调用service
        User login_user=service.login(user);
        request.getSession().setAttribute("login_user",login_user);
        ResultInfo info=new ResultInfo();
        //判断
        if (login_user==null){
            //登录失败
            info.setFlag(false);
            info.setErrorMsg("用户名或者密码错误！");
        }
        //判断用户是否激活
        if (login_user!=null&&"N".equals(login_user.getStatus())){
            //没有激活
            info.setFlag(false);
            info.setErrorMsg("您尚未激活，请激活！");
        }
        if (login_user!=null&&"Y".equals(login_user.getStatus())){
            //激活成功
            info.setFlag(true);
        }
        //响应数据
        writeValue(info,response);
    }

    /**
     * 用户激活
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
   public void active(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取激活码
        String code = request.getParameter("code");
        if (code!=null){
            //调用service
            boolean flag=service.active(code);

            //判断标记
            String msg;
            if (flag){
                //激活成功
                msg="激活成功！请<a href='login.html'>登录</a>";
            }else {
                //激活失败
                msg="激活失败，请联系管理员！";
            }
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().write(msg);
        }
    }
    /**
     * 查询登录用户
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void findOne(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Object login_user = request.getSession().getAttribute("login_user");
        String json = writeValueAsString(login_user);
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(json);
    }
}
