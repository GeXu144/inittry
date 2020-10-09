package cn.itcast.travel.service.impl;

import cn.itcast.travel.dao.FavoriteDao;
import cn.itcast.travel.dao.RouteDao;
import cn.itcast.travel.dao.RouteImageDao;
import cn.itcast.travel.dao.SellerDao;
import cn.itcast.travel.dao.impl.FavoriteDaoImpl;
import cn.itcast.travel.dao.impl.RouteDaoImpl;
import cn.itcast.travel.dao.impl.RouteImageDaoImpl;
import cn.itcast.travel.dao.impl.SellerDaoImpl;
import cn.itcast.travel.domain.PageBean;
import cn.itcast.travel.domain.Route;
import cn.itcast.travel.domain.RouteImg;
import cn.itcast.travel.domain.Seller;
import cn.itcast.travel.service.RouteService;

import java.util.List;


public class RouteServiceImpl implements RouteService {
   private RouteDao dao=new RouteDaoImpl();
   private RouteImageDao imageDao=new RouteImageDaoImpl();
   private SellerDao sellerDao=new SellerDaoImpl();
   private FavoriteDao favoriteDao=new FavoriteDaoImpl();

    /**
     * 分页查询
     * @param cid
     * @param currentPage
     * @param pageSize
     * @param rname
     * @return
     */
    @Override
    public PageBean<Route> pageQuery(int cid, int currentPage, int pageSize, String rname) {
       //封装PageBean
        PageBean<Route> pb=new PageBean<Route>();
        //设置参数
        pb.setCurrentPage(currentPage);
        pb.setPageSize(pageSize);
        int totalCount = dao.findTotalCount(cid,rname);
        pb.setTotalCount(totalCount);
        int start=(currentPage-1)*pageSize;
        List<Route> list = dao.findByPage(cid, start, pageSize,rname);
        pb.setList(list);
        int totalPage=totalCount%pageSize==0 ? totalCount/pageSize : (totalCount/pageSize)+1;
        pb.setTotalPage(totalPage);
        return pb;
    }

    /**
     * 根据根据id查询一个旅游线路
     * @param rid
     * @return
     */
    @Override
    public Route findOne(int rid) {
        //根据rid查询route对象
        Route route = dao.findOne(rid);
       //根据route里的rid查询图片信息
        List<RouteImg> list = imageDao.findByRid(route.getRid());
        route.setRouteImgList(list);

        //根据id查询商家信息
        Seller seller= sellerDao.findById(route.getSid());
        route.setSeller(seller);
        //根据rid查询收藏次数
        int count=favoriteDao.findCountByRid(route.getRid());
        route.setCount(count);
        return route;
    }
}
