package cn.jdbc.demo03.demo04;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 使用工具类
 */
public class DruidUtilesText {
    public static void main(String[] args) {
        Connection conn =null;
        PreparedStatement ps =null;
        try {
            //1.获取连接
            conn = DruidUtils.getConnection();
            //2.定义SQL
            String sql="insert into person values(?,?)";
           ps = conn.prepareStatement(sql);
            //3.赋值
            ps.setInt(1,3);
            ps.setString(2,"李雅琪");
            //4.执行SQL,调用executeUpdate()执行
            int i = ps.executeUpdate();
            System.out.println(i);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
           //5.释放资源
            DruidUtils.close(conn,ps);
        }
    }
}
