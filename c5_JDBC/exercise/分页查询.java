package javaAdvanced.c5_JDBC.exercise;

import java.sql.*;

public class 分页查询 {
    /*
    start 表示开始页数，count表示一页显示的总数
    list(0,5) 表示第零页，一共显示5条数据,即第0-4条记录,共5条记录；
    list(2,5) 表示第二页，一共显示5条数据，即第10-14条记录，共5条记录；
    进行分页查询用到的SQL语句参考 ： 查询数据
     */
    public static void list(int start,int count) throws ClassNotFoundException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try(Connection conn = DriverManager.getConnection(
                "jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8","root","12345678");
            Statement stmt = conn.createStatement();
        ) {
            String select = "select * from student limit "+count*start+", "+ count +";";
            ResultSet rs = stmt.executeQuery(select);
            System.out.println(select);
            while(rs.next())
                System.out.println(rs.getInt(1)+"号学生名字为"+rs.getString(2)+"。");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws ClassNotFoundException {
        list(2,5);
    }
}
