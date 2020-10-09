package cn.itcast.dao.impl;

import cn.itcast.dao.UserDao;
import cn.itcast.domain.User;
import cn.itcast.utils.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class UserDaoImpl implements UserDao {
   private JdbcTemplate template=new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public List<User> findAll() {
        //1.使用JDBC操作数据库
        String sql="select*from user";
        List<User> users = template.query(sql, new BeanPropertyRowMapper<User>(User.class));
        return users;
    }

    @Override
    public User login(User user) {
        try {
            //1.编写SQL
           String sql="select*from user where username=?AND password=?";
            //2.调用
            User loginuser = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class),user.getUsername()
                    ,user.getPassword());
            return loginuser;
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void addUser(User user) {
        String sql="insert into user values(null,?,?,?,?,?,?,null,null)";
        template.update(sql,user.getUsername(),user.getGender(),user.getAge(),user.getAddress(),user.getQq(),user.getEmail());
    }

    @Override
    public void deleteUser(int id) {
        String sql="delete from user where id=?";
        template.update(sql,id);
    }

    @Override
    public User findById(int id) {
        String sql="select*from user where id=?";
        return template.queryForObject(sql,new BeanPropertyRowMapper<User>(User.class),id);
    }

    @Override
    public void update(User user) {
        String sql="update user set name=?,gender=?,age=?,address=?,qq=?,email=? where id=?";
        template.update(sql,user.getUsername(),user.getGender(),user.getAge(),user.getAddress()
                ,user.getQq(),user.getEmail(),user.getId());
    }

    @Override
    public int findTotalCount(Map<String, String[]> condition) {
        //初始化sql,然后动态拼接
        String sql=" select count(*) from user where 1=1  ";
        StringBuilder sb=new StringBuilder(sql);
        List<Object> prams=new ArrayList<Object>();//参数的集合
        //遍历map
        Set<String> Keyset = condition.keySet();
        for (String key : Keyset) {
            if ("currentPage".equals(key)||"rows".equals(key)){
                continue;
            }
            //根据key获取value
            String value = condition.get(key)[0];
            if (value!=null||"".equals(value)){
                sb.append("   and  "+key+" like  ?  " );
                prams.add("%"+value+"%");
            }
        }
        return template.queryForObject(sb.toString(),Integer.class,prams.toArray());
    }

    @Override
    public List<User> findByPage(int start, int rows, Map<String, String[]> condition) {
        String sql=" select * from user where 1=1    ";
        StringBuilder sb=new StringBuilder(sql);
        List<Object> prams=new ArrayList<Object>();//参数的集合
        //遍历map
        Set<String> set = condition.keySet();
        for (String key : set) {
            if ("currentPage".equals(key)||"rows".equals(key)){
                continue;
            }
            //根据key获取value
            String value = condition.get(key)[0];
            if (value!=null||"".equals(value)){
                sb.append("   and  "+key+" like  ?  " );
                prams.add("%"+value+"%");
            }
        }
        sb.append("  limit ?,?  ");
        prams.add(start);
        prams.add(rows);
        sql=sb.toString();
        return template.query(sql,new BeanPropertyRowMapper<User>(User.class),prams.toArray());
    }
}
