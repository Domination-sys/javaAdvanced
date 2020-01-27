package javaAdvanced.c3_Set;

import java.util.ArrayList;
import java.util.Iterator;

public class d1_ArrayList {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();

        //放五个student进入arrayList
        for(int i=0;i<5;i++)
            students.add(new Student(i+"号学生"));

        //使用迭代器
        Iterator<Student> studentIterator = students.iterator();
        while (studentIterator.hasNext()){
            Student s = studentIterator.next();
            System.out.println(s.name);
        }
    }
}
