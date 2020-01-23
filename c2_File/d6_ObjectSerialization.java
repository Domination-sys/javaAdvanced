package javaAdvanced.c2_File;

import java.io.*;

public class d6_ObjectSerialization {
    public static void main(String[] args) {
        Student[] nkcs = new Student[10];
        File file = new File("/Users/wangbotao/Desktop/fuck.cnm");
        float i = 0f;
        try(
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            ) {
            for(Student s:nkcs){
                s = new Student();
                s.GPA = i++;
                s.name = String.valueOf(i);
                oos.writeObject(s);
                Student student = (Student)ois.readObject();
                System.out.println(student.GPA);
                System.out.println(student.name);
                System.out.println();
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
class Student implements Serializable {
    public static final long Version = 1L;
    float GPA;
    String name;
}
