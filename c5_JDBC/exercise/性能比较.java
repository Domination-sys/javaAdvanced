package javaAdvanced.c5_JDBC.exercise;

import java.sql.*;

public class 性能比较 {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String sql = "insert into student values(null,?)";
        try (Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8","root", "12345678");
             PreparedStatement ps = c.prepareStatement(sql);
             Statement stmt = c.createStatement();
        ) {
            long startTime,endTime;

            ps.setString(1, "王柏韬");
            startTime =  System.currentTimeMillis();
            for(int i=0;i<10000;i++){
                ps.execute();
            }
            endTime =  System.currentTimeMillis();
            System.out.println("预编译语句插入一万条记录消耗的时间为"+(endTime-startTime)+"毫秒");

            sql = "insert into student values(null,"+"'王柏韬'"+");";
            startTime =  System.currentTimeMillis();
            for(int i =0;i<10000;i++)
                stmt.execute(sql);
            endTime =  System.currentTimeMillis();
            System.out.println("普通编译语句插入一万条记录消耗的时间为"+(endTime-startTime)+"毫秒");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
