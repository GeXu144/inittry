package cn.jdbc.demo03.demo04;

import cn.jdbc.demo03.demo03.DruidDemo01;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * 数据连接池工具类使用
 *
 */

public class DruidUtils {
    private static DataSource ds ;

    static {

        try {
            Properties pro=new Properties();
            //利用源地址流加载文件
            InputStream resource = DruidDemo01.class.getClassLoader().getResourceAsStream("druid.properties");
            pro.load(resource);
            //获取连接池对象
            ds = DruidDataSourceFactory.createDataSource(pro);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取连接
     */
    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }
    /**
     * 归还资源
     * @param conn
     * @param stmt
     */
    public static void close( Connection conn, Statement stmt){
        close(null,conn,stmt);
    }
    public static void close(ResultSet rs, Connection conn, Statement stmt){
        if (rs!=null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn!=null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (stmt!=null){
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 获取连接池方法
     * @return
     */
    public static DataSource getDataSource(){
        return ds;
    }
}
