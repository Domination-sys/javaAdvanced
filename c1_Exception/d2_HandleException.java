package javaAdvanced.c1_Exception;

/*
 try catch finally throws
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class d2_HandleException {
    /*
    try catch
1.将可能抛出FileNotFoundException 文件不存在异常的代码放在try里
2.如果文件存在，就会顺序往下执行，并且不执行catch块中的代码
3. 如果文件不存在，try 里的代码会立即终止，程序流程会运行到对应的catch块中
4. e.printStackTrace(); 会打印出方法的调用痕迹，如此例，会打印出异常开始于TestException的第16行，这样就便于定位和分析到底哪里出了异常
     */
    public static void main(String[] args) {
        File file = new File("C:/苍老师.avi");

        //直接捕捉 FileNotFound的Excetion
        try{
            System.out.println("试图打开苍老师的学习资料");
            new FileInputStream(file);
            System.out.println("打开成功");
        } catch (FileNotFoundException e) {
            System.out.println("苍老师不存在");
            e.printStackTrace();
        }

        //各种异常都是继承的Exception类，所以可以不用区分异常种类，直接捕捉Excetion
        try{
            System.out.println("试图打开苍老师的学习资料");
            new FileInputStream(file);
            System.out.println("打开成功");
        } catch (Exception e) {//与上一段代码有区别的地方
            System.out.println("苍老师不存在");
            e.printStackTrace();
        }

        //也可以捕捉多种错误
        try {
            System.out.println("试图打开苍老师的学习资料");
            new FileInputStream(file);
            System.out.println("成功打开");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");//解析日期
            Date d = sdf.parse("2020-01-18");
        } catch (FileNotFoundException e) {
            System.out.println("苍老师不存在");
            e.printStackTrace();
        } catch (ParseException e) {//解析日期错误
            System.out.println("日期格式解析错误");
            e.printStackTrace();
        }

        //花式抓异常：把异常放一起，但是需要通过instanceof关键字来判断属于哪种
        try {
            System.out.println("试图打开苍老师的学习资料");
            new FileInputStream(file);
            System.out.println("成功打开");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");//解析日期
            Date d = sdf.parse("2020-01-18");
        }catch (FileNotFoundException|ParseException e){
            if(e instanceof FileNotFoundException)
                System.out.println("苍老师不存在");
            if(e instanceof ParseException)
                System.out.println("日期格式解析错误");

            e.printStackTrace();
        }

        //无论是否有异常，都会执行finally的内容
        try{
            System.out.println("试图打开苍老师的学习资料");
            new FileInputStream(file);
            System.out.println("打开成功");
        } catch (Exception e) {//与上一段代码有区别的地方
            System.out.println("苍老师不存在");
            e.printStackTrace();
        }finally {
            System.out.println("无论是否执行catch，都会执行finally");
        }

        //throws关键字：遇到了exception不处理，而是汇报给上级（父方法），上级收到Exception有两种办法：try、catch或者继续向上级trhows、
        //也就是throws只是告诉程序，你要监视着，一旦遇到exception就抛
        //throw后面讲，throw是只要程序执行到这一步一定抛出Exception，相当于你主动抛出去，而且可以自定义异常
    }
}
