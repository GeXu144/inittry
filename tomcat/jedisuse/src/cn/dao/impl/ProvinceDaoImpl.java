package cn.dao.impl;

import cn.dao.ProvinceDao;
import cn.domain.Province;
import cn.utils.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class ProvinceDaoImpl implements ProvinceDao {
   private JdbcTemplate template=new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public List<Province> findAll() {
        String sql="select*from province";
        return template.query(sql, new BeanPropertyRowMapper<Province>(Province.class));
    }
}
