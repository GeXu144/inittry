package cn.jdbc.demo03.demo01;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcDemo01 {
    public static void main(String[] args) {
        List<Stu> list=new JdbcDemo01().findAll();
        for (Stu stu : list) {
            System.out.println(stu);
        }

    }
    public List<Stu> findAll() {
        Connection conn =null;
        Statement stmt =null;
        ResultSet rs =null;
        List<Stu> list=null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //2.获取链接，调用drivermanager.getconnection方法
             conn = DriverManager.getConnection("jdbc:mysql:///db1", "root", "root");
            //3.定义SQL
            String sql = "select * from stu";
            //4.获取sql对象
           stmt = conn.createStatement();
            //5.执行SQL，调用返回结果集方法
            rs = stmt.executeQuery(sql);
            //6.遍历结果集，封装对象，装载集合
            Stu stu=null;
            list=new ArrayList<Stu>();
            while (rs.next()){
                //获取数据，调用get***,***代表数据类型。
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                double score = rs.getDouble("score");
                String address = rs.getString("address");
                //7.创建stu对象
                stu=new Stu();
                stu.setId(id);
                stu.setName(name);
                stu.setAge(age);
                stu.setScore(score);
                stu.setAddress(address);
                //8.装载集合
                list.add(stu);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
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
        return list;
    }
}
