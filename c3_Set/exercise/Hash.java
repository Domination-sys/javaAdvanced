package javaAdvanced.c3_Set.exercise;

import javaAdvanced.c3_Set.Student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/*
准备一个ArrayList其中存放3000000(三百万个)Student对象，其名称是随机的,格式是student-[4位随机数]
student-3229
student-6232
student-9365
...
因为总数很大，所以几乎每种都有重复，把名字叫做 hero-5555的所有对象找出来
要求使用两种办法来寻找
1. 不使用HashMap，直接使用for循环找出来，并统计花费的时间
2. 借助HashMap，找出结果，并统计花费的时间
 */
public class Hash {
    public static void main(String[] args) {
        ArrayList<Student> s = new ArrayList<>();
        HashMap<String, List<Student>> hm = new HashMap<>();
        for(int i=0;i<4000000;i++){
            int rand = (int)(Math.random()*10000);
            Student tmp = new Student(String.valueOf(rand));
            s.add(tmp);
            List<Student> ls = hm.get(tmp.name);
            if(null==ls){
                ls = new LinkedList<>();
                hm.put(tmp.name,ls);
            }
            ls.add(tmp);
        }
        List<Student> result = new LinkedList<>();
        long startTime,endTime;
        /*******************初始化完成*****************/

        startTime =  System.currentTimeMillis();
        for(Student student:s){
            if(student.name.equals("5555"))
                result.add(student);
        }
        endTime =  System.currentTimeMillis();
        System.out.println("用循环消耗的时间为"+(endTime-startTime)+"毫秒");
        System.out.println("用循环查询处的结果为"+result.size()+"个");

        result.clear();

        startTime =  System.currentTimeMillis();
        result = hm.get("5555");
        endTime =  System.currentTimeMillis();
        System.out.println("借助哈希表消耗的时间为"+(endTime-startTime)+"毫秒");
        System.out.println("借助哈希表查询处的结果为"+result.size()+"个");




    }

}
