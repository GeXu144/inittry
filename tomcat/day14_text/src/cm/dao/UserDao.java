package cm.dao;
import cm.daomain.User;
import cm.utils.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * 操作数据库的User类
 */
public class UserDao {
   //1.声明JdbcTemplate对象共用
    private JdbcTemplate template=new JdbcTemplate(JDBCUtils.getDataSource());


    /**
     * loginUser只包含用户的用户名和密码
     * 返回的User则包含用户的全部信息
     * @param loginUser
     * @return
     */
    public User login(User loginUser) {
        try {
            //1.编写SQL
            String sql = "select*from user where username=? and password=?";
            //2.调用
            User user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class),loginUser.getUsername()
                    ,loginUser.getPassword());
            return user;
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }
}
