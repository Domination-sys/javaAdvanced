package javaAdvanced.c1_Exception;

/*
如果老师要挂掉一个学生的时候，发现这个学生是重修状态，就会发出梅开二度警告
创建一个类梅开二度警告，并继承Exception
提供两个构造方法
1. 无参的构造方法
2. 带参的构造方法，并调用父类的对应的构造方法
 */
class 梅开二度Warning extends Exception{
    public 梅开二度Warning(){
        //无参构造
    }
    public 梅开二度Warning(String msg){
        super(msg);
        //带参构造
    }
}
class Student{
    Boolean isretake;
}

class Teacher{
    public void 挂人(Student student)throws 梅开二度Warning{
        if(student.isretake)
            throw new 梅开二度Warning("老师，他已经挂了一次，求求您不要让他三战了，他经常梦到挂科被吓醒！");
    }
}

public class d6_CustomException {
    public static void main(String[] args) {
        Teacher 铁杠 = new Teacher();

        Student 王柏韬 = new Student();
        王柏韬.isretake = true;
        try {
            铁杠.挂人(王柏韬);
        } catch (javaAdvanced.c1_Exception.梅开二度Warning warning) {
            System.out.println("异常的具体原因:"+warning.getMessage());
            warning.printStackTrace();
        }
    }

}
