package cn.itcast.travel.web.servlet;

import cn.itcast.travel.domain.PageBean;
import cn.itcast.travel.domain.Route;
import cn.itcast.travel.domain.User;
import cn.itcast.travel.service.FavoriteService;
import cn.itcast.travel.service.RouteService;
import cn.itcast.travel.service.impl.FavoriteServiceImpl;
import cn.itcast.travel.service.impl.RouteServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/route/*")
public class RoutServlet extends BaseServlet {
    private RouteService service=new RouteServiceImpl();
    private FavoriteService fservice=new FavoriteServiceImpl();
    /**
     * 分页查询
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void pageQuery(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.接受参数
        String currentPagetr = request.getParameter("currentPage");
        String pageSizetr = request.getParameter("pageSize");
        String cidtr = request.getParameter("cid");
        String rname = request.getParameter("rname");
        rname= new String(rname.getBytes("iso-8859-1"),"utf-8");

        //2.处理参数
        int cid=0;//类别id
        if (cidtr!=null&&cidtr.length()>0){
            cid=Integer.parseInt(cidtr);
        }
        int currentPage=0;
        if (currentPagetr!=null&&currentPagetr.length()>0){
           currentPage=Integer.parseInt(currentPagetr);
        }else {
            currentPage=1;//不传参数默认当前页码第一页
        }
        int pageSize=0;
        if (pageSizetr!=null&&pageSizetr.length()>0){
            pageSize=Integer.parseInt(pageSizetr);
        }else {
            pageSize = 5;//不传参数默认每页五条记录
        }
        //调用service
        PageBean<Route> routePageBean = service.pageQuery(cid, currentPage, pageSize,rname);
        writeValue(routePageBean,response);
    }

    /**
     * 根据id查询一个旅游线路
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void findOne(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //接受参数
        String ridstr = request.getParameter("rid");
        int rid = Integer.parseInt(ridstr);
        //调用service
        Route route=service.findOne(rid);
        //转为json
        writeValue(route,response);
    }

    /**
     * 判断当前登录用户是否收藏线路
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void isFavorite(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取线路id
        String rid = request.getParameter("rid");
        //获取当前登录的用户id
       User login_user = (User) request.getSession().getAttribute("login_user");
       int uid;//用户id
       if(login_user==null){
            //用户未登录
           uid=0;
       }else {
           //用户登录了
           uid = login_user.getUid();
       }

       //调用service调用查询是否收藏
        boolean flag = fservice.isFavorite(rid, uid);
       writeValue(flag,response);
    }

    /**
     * 添加收藏
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void addFavorite(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取线路id
        String rid = request.getParameter("rid");
        //获取当前登录的用户id
        User login_user = (User) request.getSession().getAttribute("login_user");
        int uid;//用户id
        if(login_user==null){
            //用户未登录
           return;
        }else {
            //用户登录了
            uid = login_user.getUid();
        }
        //调用service
        fservice.add(rid,uid);
    }
}
