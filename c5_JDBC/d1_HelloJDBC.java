package javaAdvanced.c5_JDBC;

import com.mysql.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class d1_HelloJDBC {
    public static void example(){
        //0.为项目导入mysql-connector的jar包
        Statement stmt =null;
        Connection conn = null;
        try {
        //1.导入mysql驱动
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("导入驱动成功");
        //2.与数据库建立链接
            //执行前要确保数据库how2java的存在
            // 建立与数据库的Connection连接
            // 这里需要提供：
            // 数据库所处于的ip:127.0.0.1 (本机)
            // 数据库的端口号： 3306 （mysql专用端口号）
            // 数据库名称 how2java
            // 编码方式 UTF-8
            // 账号 root
            // 密码 12345678
            conn = DriverManager.getConnection(
                    "jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8","root","12345678");
            System.out.println("链接成功");
        //3.建立statement语句
            // 注意：使用的是 java.sql.Statement,不要不小心使用到： com.mysql.jdbc.Statement;
            stmt = conn.createStatement();
            System.out.println("获取 Statement对象： " + stmt);
        //4.执行sql语句
            String sql = "CREATE TABLE IF NOT EXISTS student (" +
                    "  id int(11) AUTO_INCREMENT," +
                    "  name varchar(30) ," +
                    "  PRIMARY KEY (id)" +
                    ")  DEFAULT CHARSET=utf8;";
            stmt.execute(sql);
            System.out.println("建表成功");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }finally {
        //5.关闭链接
            if(null!=stmt) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(null!=conn) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //让它自动关闭链接的办法
    public static void main(String[] args){
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try(Connection conn = DriverManager.getConnection(
                "jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8","root","12345678");
            Statement stmt = conn.createStatement();
        ) {
            for(int i =0;i<100;i++){
                String sql = "insert into student values(null,"+"'王"+i+"韬'"+");";
                stmt.execute(sql);
                System.out.println(stmt.toString());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
