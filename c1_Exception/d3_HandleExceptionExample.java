package javaAdvanced.c1_Exception;

public class d3_HandleExceptionExample {
    public static int method(){
        try {
            System.out.println("返回1");
            return 1;
        }catch (Exception e){
            System.out.println("返回2");
            return 2;
        }finally {
            System.out.println("返回3");
            return 3;
        }
    }

    public static void main(String[] args) {
        int a =  method();
        System.out.println("执行结果是"+a);
    }
}
