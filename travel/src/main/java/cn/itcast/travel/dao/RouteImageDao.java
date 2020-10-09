package cn.itcast.travel.dao;

import cn.itcast.travel.domain.RouteImg;

import java.util.List;

public interface RouteImageDao {
    /**
     * 根据rid查询图片信息然后整理为集合
     * @return
     */
    public List<RouteImg> findByRid(int rid);
}
