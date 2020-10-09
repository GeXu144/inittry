package cn.itcast.web.filter;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * 验证是否登录，登录方可放行
 */
@WebFilter("/*")
public class LoginFilter implements Filter {

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
       //强制转换
        HttpServletRequest request= (HttpServletRequest) req;
        //1.获取请求资源路径
        String uri = request.getRequestURI();
        //2.判断是否包含登录相关资源
        if (uri.contains("/login.jsp")||uri.contains("/loginServlet")||uri.contains("/checkCodeServlet")||uri.contains("/css/")||uri.contains("/js/")||uri.contains("/fonts/")){
            //放行
            chain.doFilter(req, resp);
        }else {
            //验证登录，如果没有，跳转登录
            Object user = request.getSession().getAttribute("loginuser");
            if (user!=null){
                //登录了，放行
                chain.doFilter(req, resp);
            }else {
                //没有登录，跳转login.jsp
                request.setAttribute("login_mistake","您尚未登录，请先登录！");
                request.getRequestDispatcher("/login.jsp").forward(request,resp);
            }
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

    public void destroy() {
    }
}
