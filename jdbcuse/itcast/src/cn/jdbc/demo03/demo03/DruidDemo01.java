package cn.jdbc.demo03.demo03;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

/**
 * Druid连接池的使用
 */
public class DruidDemo01 {
    public static void main(String[] args) throws Exception {
        //1.导包，跟配置文件
        //2.定义配置文件
        //3.加载配置文件
        Properties pro=new Properties();
        //利用源地址流加载文件
        InputStream resource = DruidDemo01.class.getClassLoader().getResourceAsStream("druid.properties");
        pro.load(resource);
        //获取连接池对象调用DruidDataSourceFactory.createDataSource()
        DataSource ds = DruidDataSourceFactory.createDataSource(pro);
        Connection conn = ds.getConnection();
        System.out.println(conn);
    }
}
