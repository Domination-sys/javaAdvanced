package javaAdvanced.c2_File;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class d2_FileSteam {
    public static void main(String[] args) {
        File f = new File("/User/苍老师.txt");
        //输入流
        try {
            FileInputStream fs = new FileInputStream(f);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        //输出流
        try {
            FileOutputStream fs = new FileOutputStream(f);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
