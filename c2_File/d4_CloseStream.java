package javaAdvanced.c2_File;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class d4_CloseStream {
    public static void main(String[] args) {
        /*
        在try的作用域里关闭文件输入流，在前面的示例中都是使用这种方式，这样做有一个弊端；
如果文件不存在，或者读取的时候出现问题而抛出异常，那么就不会执行这一行关闭流的代码，存在巨大的资源占用隐患。 不推荐使用

        这是标准的关闭流的方式
1. 首先把流的引用声明在try的外面，如果声明在try里面，其作用域无法抵达finally.
2. 在finally关闭之前，要先判断该引用是否为空
3. 关闭的时候，需要再一次进行try catch处理
这是标准的严谨的关闭流的方式，但是看上去很繁琐，所以写不重要的或者测试代码的时候，都会采用上面的有隐患try的方式，因为不麻烦~
         */

        //标准关闭方式
        File f = new File("/Users/wangbotao/Desktop/test.txt");
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(f);
            byte[] all = { 66,67 };
            fos.write(all);
        }catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(null != fos) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


        /*
        把流定义在try()里,try,catch或者finally结束的时候，会自动关闭
        这种编写代码的方式叫做 try-with-resources， 这是从JDK7开始支持的技术
         */
        try(FileInputStream fls = new FileInputStream(f)){
            byte[] all = new byte[(int)f.length()];
            fls.read(all);
            for(byte b : all)
                System.out.println(b);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
