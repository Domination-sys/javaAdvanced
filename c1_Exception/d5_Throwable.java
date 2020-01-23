package javaAdvanced.c1_Exception;

import java.io.File;
import java.io.FileInputStream;

public class d5_Throwable {

    /*
    Throwable是类，Exception和Error都继承了该类,
    所以在捕捉的时候，也可以使用Throwable进行捕捉
     */

    public static void main(String[] args) {
        File f = new File("C:/苍老师.avi");
        try {
            new FileInputStream(f);
            //使用Throwable进行异常捕捉
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }
}
