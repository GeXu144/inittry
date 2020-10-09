package cn.dao;

import cn.domain.Province;

import java.util.List;

public interface ProvinceDao {
    /**
     * 查询所有数据
     * @return
     */
    public List<Province> findAll();
}
