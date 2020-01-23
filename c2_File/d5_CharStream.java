package javaAdvanced.c2_File;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class d5_CharStream {
    public static void main(String[] args) {

        /*
        Reader字符输入流
        Writer字符输出流
        专门用于字符的形式读取和写入数据
         */
        //之前输入输出的是ascii，现在是字符
        File f = new File("/Users/wangbotao/Desktop/d.md");

        //读文件
        char[] all = new char[(int)f.length()];
        try(FileReader fr = new FileReader(f)) {
            fr.read(all);
            for(char c:all)
                System.out.print(c);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //写文件
        String s = "允公允能，日新月异";
        try(FileWriter fw = new FileWriter(f)){
            fw.write(s.toCharArray());
        }catch (IOException e) {
            e.printStackTrace();
        }

    }
}
