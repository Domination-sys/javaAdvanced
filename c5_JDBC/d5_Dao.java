package javaAdvanced.c5_JDBC;

import java.util.List;
/*
DAO=DataAccess Object
数据访问对象
实际上就是运用了ORM中的思路(Object Relationship Database Mapping对象和关系数据库的映射,简单说，一个对象，对应数据库里的一条记录)，
把数据库相关的操作都封装在这个类里面，其他地方看不到JDBC的代码
 */
public interface d5_Dao {
    //增加
    public void add(Student student);
    //修改
    public void update(Student student);
    //删除
    public void delete(int id);
    //获取
    public Student get(int id);
    //查询
    public List<Student> list();
    //分页查询
    public List<Student> list(int start, int count);
}
class Student{
    int id;
    String name;
}
