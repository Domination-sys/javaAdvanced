package javaAdvanced.c2_File;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class d3_ByteStream_Input {
    public static void main(String[] args) {
        File f = new File("/Users/wangbotao/Desktop/d.md");
        try{
            FileInputStream fs = new FileInputStream(f);
            byte[] all = new byte[(int)f.length()];
            fs.read(all);
            //输出的全是 Ascii
            for(Byte b : all){
                System.out.println(b);
            }
            //每次使用完流，都应该进行关闭
            fs.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
