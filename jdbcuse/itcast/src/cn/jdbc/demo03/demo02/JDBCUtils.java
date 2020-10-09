package cn.jdbc.demo03.demo02;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.Properties;

/**
 * JDBC工具类
 *
 */

/**
 * 连接只需要获取一次，所以可以使用静态代码块
 * 可以用配置文件进行动态设置
 */

public class JDBCUtils {
    private static String url;
    private static String user;
    private static String password;
    private static String driver;

    static {

        try {
            Properties pr=new Properties();
           //1.利用properties集合的load方法加载文件
            ClassLoader loader = JDBCUtils.class.getClassLoader();
            URL res = loader.getResource("jdbc.properties");
            String path = res.getPath();
            System.out.println(path);
            pr.load(new FileReader(path));
            //2.读取到文件的内容之后赋值
            url = pr.getProperty("url");
            user=pr.getProperty("user");
            password=pr.getProperty("password");
            driver=pr.getProperty("driver");
            //3.注册驱动
            Class.forName(driver);


        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url,user,password);
    }


    /**
     * 释放资源
     * @param conn
     * @param stmt
     */
    public static void close( Connection conn, Statement stmt){

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

}
