package javaAdvanced.c1_Exception;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class d1_Example {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("C:/苍老师.avi");//试图打开此文件
        new FileInputStream(file); //不存在此文件，所以会在程序崩溃前，抛出异常、
        /*
        开玩笑，我的电脑里怎么会有这些东西
         */

        /*
        其他异常：
ParseException 解析异常，日期字符串转换为日期对象的时候，有可能抛出的异常

OutOfIndexException 数组下标越界异常
OutOfMemoryError 内存不足
ClassCastException 类型转换异常
ArithmeticException 除数为零
NullPointerException 空指针异常
    这些后面还会提到，现在不用记
         */
    }
}
