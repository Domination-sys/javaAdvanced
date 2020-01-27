package javaAdvanced.c3_Set;

public class Student {
    public String name;
    int girlfriend;
    public Student(String name){
        this.name = name;
    }
    public Student(String name,int n){
        this.name = name;
        this.girlfriend = n;
    }

    @Override
    public String toString() {
        return name+"同学有"+girlfriend+"个女朋友";
    }
}
