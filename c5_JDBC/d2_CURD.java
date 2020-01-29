package javaAdvanced.c5_JDBC;

/*
CRUD是最常见的数据库操作，即增删改查
C 增加(Create)
R 读取查询(Retrieve)
U 更新(Update)
D 删除(Delete)
在JDBC中增加，删除，修改的操作都很类似，只是传递不同的SQL语句就行了。
 */

import java.sql.*;

public class d2_CURD {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        //ShowCUD();
        ShowR();
    }
    //增删改
    public static void ShowCUD(){
        String create = "insert into student values(null,"+"'王柏韬'"+");";
        String delete = "delete from student where name = 'wangbotao';";
        String update = "update student set name = 'wangbotao' where name = '王柏韬';";
        execute(create);
        execute(update);
        execute(delete);
    }
    //查
    public static void ShowR() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection(
                "jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8","root","12345678");
        Statement stmt = conn.createStatement();
        String select = "select * from student;";
        //结果集是新知识
        ResultSet rs = stmt.executeQuery(select);
        while (rs.next()){
            System.out.println(rs.getInt(1)+"号学生名字为"+rs.getString(2)+"。");
        }
        String count = "select count(*) from student;";
        rs = stmt.executeQuery(count);
        while (rs.next()){
            System.out.println("共有"+rs.getInt(1)+"条记录。");
        }
        rs.close();
        stmt.close();
        conn.close();
    }
    public static void execute(String sql){
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try(Connection conn = DriverManager.getConnection(
                "jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8","root","12345678");
            Statement stmt = conn.createStatement();
        ) {
            stmt.execute(sql);
            System.out.println("已执行语句"+sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
