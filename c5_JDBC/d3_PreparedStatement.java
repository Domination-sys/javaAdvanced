package javaAdvanced.c5_JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
/*
和 Statement一样，PreparedStatement也是用来执行sql语句的
与创建Statement不同的是，需要根据sql语句创建PreparedStatement
除此之外，还能够通过设置参数，指定相应的值，而不是Statement那样使用字符串拼接

Statement 需要进行字符串拼接，可读性和维护性比较差
String sql = "insert into student values(null,"+"'王柏韬'"+")";
PreparedStatement 使用参数设置，可读性好，不易犯错
String sql = "insert into student values(null,?)";

PreparedStatement有预编译机制，性能比Statement更快
Statement执行10次，需要10次把SQL语句传输到数据库端
数据库要对每一次来的SQL语句进行编译处理
PreparedStatement 执行10次，只需要1次把SQL语句传输到数据库端
数据库对带?的SQL进行预编译
每次执行，只需要传输参数到数据库端
    1. 网络传输量比Statement更小
    2. 数据库不需要再进行编译，响应更快

PreparedStatement的优点3-防止SQL注入式攻击
String name = "'王柏韬' OR 1=1";
使用Statement就需要进行字符串拼接
拼接出来的语句是：
select * from hero where name = '王柏韬' OR 1=1
因为有OR 1=1，这是恒成立的
那么就会把所有记录都查出来，而不只是王柏韬
如果Student表里的数据是海量的，比如几百万条，把这个表里的数据全部查出来
会让数据库负载变高，CPU100%，内存消耗光，响应变得极其缓慢
而PreparedStatement使用的是参数设置，就不会有这个问题
 */
public class d3_PreparedStatement {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String sql = "insert into student values(null,?)";
        try (Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8","root", "12345678");
             // 根据sql语句创建PreparedStatement
             PreparedStatement ps = c.prepareStatement(sql);
        ) {
            // 设置参数
            ps.setString(1, "王柏韬");
            ps.execute();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
