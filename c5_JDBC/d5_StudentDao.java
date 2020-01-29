package javaAdvanced.c5_JDBC;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class d5_StudentDao implements d5_Dao{
    // 1。根据类的加载机制，每次调用类或者类的静态方法时自动调用生成函数
    // 因为驱动初始化只需要执行一次，所以放在这里更合适，其他方法里也不需要写了，代码更简洁
    public d5_StudentDao(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    //2。提供了一个getConnection方法返回连接
    //所有的数据库操作都需要事先拿到一个数据库连接Connection，以前的做法每个方法里都会写一个，如果要改动密码，那么每个地方都需要修改。 通过这种方式，只需要修改这一个地方就可以了。 代码变得更容易维护，而且也更加简洁。
    public Connection getConnection() throws SQLException {
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8","root","12345678");
            return conn;
    }

    public int getTotal() {
        int total = 0;
        try (Connection c = getConnection(); Statement s = c.createStatement();) {

            String sql = "select count(*) from hero";

            ResultSet rs = s.executeQuery(sql);
            while (rs.next()) {
                total = rs.getInt(1);
            }

            System.out.println("total:" + total);

        } catch (SQLException e) {

            e.printStackTrace();
        }
        return total;
    }

    public void add(Student student) {

        String sql = "insert into student values(null,?";
        try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {

            ps.setString(1, student.name);
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt(1);
                student.id = id;
            }
        } catch (SQLException e) {

            e.printStackTrace();
        }
    }

    public void update(Student student) {

        String sql = "update student set name= ? where id = ?";
        try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
            ps.setString(1, student.name);
            ps.setInt(2, student.id);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        try (Connection c = getConnection(); Statement s = c.createStatement();) {
            String sql = "delete from student where id = " + id;
            s.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Student get(int id) {
        Student student = null;
        try (Connection c = getConnection(); Statement s = c.createStatement();) {
            String sql = "select * from student where id = " + id;
            ResultSet rs = s.executeQuery(sql);
            if (rs.next()) {
                student = new Student();
                String name = rs.getString(2);
                student.name = name;
                student.id = id;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return student;
    }

    public List<Student> list() {
        return list(0, Short.MAX_VALUE);
    }

    public List<Student> list(int start, int count) {
        List<Student> students = new ArrayList<Student>();
        String sql = "select * from student order by id desc limit ?,? ";
        try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
            ps.setInt(1, start);
            ps.setInt(2, count);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Student student = new Student();
                int id = rs.getInt(1);
                String name = rs.getString(2);
                student.id = id;
                student.name = name;
                students.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }
}
