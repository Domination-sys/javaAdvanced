package javaAdvanced.c4_Thread;

/*
创建多线程有3种方式，分别是继承线程类,实现Runnable接口,匿名类
 */
//第一种方法
class Example extends Thread{
    public void run() {
        int i=0;
        while (i<10)
            System.out.print(i++);
    }
}
public class d1_Start implements Runnable{
    //第二种方法
    @Override
    public void run() {
        int i=0;
        while (i<10)
            System.out.print(i++);
    }

    public static void main(String[] args) {
        //第一种方法
        Example[] ee = new Example[5];
        for(Example e:ee){
            e = new Example();
            e.start();
        }

        System.out.println();

        //第二种方法
        d1_Start[] ss = new d1_Start[5];
        for(d1_Start s:ss){
            s = new d1_Start();
            new Thread(s).start();
        }

        System.out.println();

        //第三种方法
        Thread[] tt = new Thread[5];
        for(Thread t:tt){
            t = new Thread(){
                public void run(){
                    int i=0;
                    while (i<10)
                        System.out.print(i++);
                }
            };
            t.start();
        }
    }
}
