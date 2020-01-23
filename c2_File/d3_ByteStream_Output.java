package javaAdvanced.c2_File;

import java.io.*;

public class d3_ByteStream_Output {
    public static void main(String[] args) {
        File f = new File("/Users/wangbotao/Desktop/test.txt");

        try {
            FileOutputStream fos = new FileOutputStream(f);
            byte[] all = { 66,67 };
            fos.write(all);
            fos.close();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
