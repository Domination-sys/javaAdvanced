package javaAdvanced.c2_File.exercise;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class 比特流 {
    public static void main(String[] args) throws IOException {
        File f = new File("/Users/wangbotao/Desktop/w/b/t/t/t/t/t/t/t/t/t.txt");
        File parentFile = f.getParentFile();
        if(!parentFile.exists())
            parentFile.mkdirs();
        FileOutputStream fos = new FileOutputStream(f);
        byte[] love = {73,32,108,111,118,101,32,121,111,117};
        fos.write(love);
        fos.close();
    }
}
