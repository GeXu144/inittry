package cn.service;

import cn.domain.Province;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;

public interface ProvinceService {
    /**
     * 查询所有数据
     * @return
     */
    public List<Province> findAll();

    public String findAllJson();
}
