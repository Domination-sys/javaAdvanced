package javaAdvanced.c1_Exception;

/*
分为三类：可查异常（在编译阶段就报告）、运行时异常（在运行阶段报告）、错误
* 可查异常：必须进行处理的异常，要么try catch住,要么往外抛，谁调用，谁处理，比如 FileNotFoundException如果不处理，编译器，就不让你通过
* RuntimeException指： 不是必须进行try catch的异常，常见的有：
    除数不能为0异常:ArithmeticException
    下标越界异常:ArrayIndexOutOfBoundsException
    空指针异常:NullPointerException
说明：在编写代码的时候，依然可以使用try catch throws进行处理，与可查异常不同之处在于，即便不进行try catch，也不会有编译错误
    Java之所以会设计运行时异常的原因之一，是因为下标越界，空指针这些运行时异常太过于普遍，如果都需要进行捕捉，代码的可读性就会变得很糟糕。
* 错误Error，指的是系统级别的异常，通常是内存用光了，与运行时异常一样，错误也是不要求强制捕捉的

提问：
    运行时异常 RuntimeException，能否被捕捉？错误Error，能否被捕捉？
    异常错误有何区别？
 答：运行时异常是不可查异常，不需要进行显式的捕捉；非运行时异常是可查异常，必须进行显式的捕捉，或者抛出。
 */

public class d4_ExceptionKinds {



    public static void main(String[] args) {

    //一、可查异常在HandleExceptionExample里面有

    //二、常见运行时异常
        //任何除数不能为0:ArithmeticException
        int k = 5/0;
        //下标越界异常：ArrayIndexOutOfBoundsException
        int j[] = new int[5];
        j[10] = 10;
        //空指针异常：NullPointerException
        String str = null;
        str.length();

    //三、错误
        //在默认设置下，一般java程序启动的时候，最大可以使用16m的内存
        //如例不停的给StringBuffer追加字符，很快就把内存使用光了。抛出OutOfMemoryError
        StringBuffer sb =new StringBuffer();
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            sb.append('a');
        }
    }
}
