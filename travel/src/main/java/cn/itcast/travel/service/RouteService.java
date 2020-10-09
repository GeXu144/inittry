package cn.itcast.travel.service;

import cn.itcast.travel.domain.PageBean;
import cn.itcast.travel.domain.Route;


public interface RouteService {
    /**
     * 根据三个参数分页查询
     * @param cid
     * @param currentPage
     * @param pageSize
     * @param rname
     * @return
     */
    public PageBean<Route> pageQuery(int cid, int currentPage, int pageSize, String rname);

    /**
     * 根据根据id查询一个旅游线路
     * @param rid
     * @return
     */
    Route findOne(int rid);
}
