package javaAdvanced.c4_Thread;

public class d2_Method {

    /*
    ***当前线程暂停***
    Thread.sleep(1000); 表示当前线程暂停1000毫秒 ，其他线程不受影响
Thread.sleep(1000); 会抛出InterruptedException 中断异常，因为当前线程sleep的时候，有可能被停止，这时就会抛出 InterruptedException
     */
    public static void SleepShow(){
        Thread t = new Thread(){
            public void run(){
                int number = 0;
                while (true){
                    try {
                        Thread.sleep(300);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("又掉了一根头发，现在掉了"+(++number)+"根头发了");
                }
            }
        };
        t.start();
    }

    /*
    ***加入到当前线程中***
    首先解释一下主线程的概念
所有进程，至少会有一个线程即主线程，即main方法开始执行，就会有一个看不见的主线程存在。
在42行执行t.join，即表明在主线程中加入该线程。
主线程会等待该线程结束完毕， 才会往下运行。
     */
    public static void JoinShow() throws InterruptedException {

        Thread t1 = new Thread(){
            public void run(){
                int number = 0;
                while (true){
                    try {
                        Thread.sleep(300);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("又掉了一根头发，现在掉了"+(++number)+"根头发了");
                }
            }
        };
        t1.start();

        /*
        如果没有下面join这一句代码，得到的效果是t1，t2同时进行，即边敲代码，边掉头发
        但t1加上了join，t1线程加入到main线程中来，只有t1线程运行结束，才会继续往下走
        即掉完头发才会去写代码（可是掉头发的while条件是true，所以永远不会写代码,只是一直掉头发)
         */
        //t1.join();

        Thread t2 = new Thread(){
            public void run(){
                while (true){
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("敲一会儿代码");
                }
            }
        };
        t2.start();
    }

    /*
    ***线程优先级***
    当线程处于竞争关系的时候，优先级高的线程会有更大的几率获得CPU资源
     */
    public static void PriorityShow(){
        //h,l只是个计数用的变量，没别的意思
        final int[] h = {0};
        final int[] l = {0};
        Thread t1 = new Thread(){
            public void run(){
                while (true){
                    h[0]++;
                    System.out.println("高优先级的线程循环了"+ h[0] +"次");
                }
            }
        };
        Thread t2 = new Thread(){
            public void run(){
                while (true){
                    l[0]++;
                    System.out.println("低优先级的线程循环了"+ l[0] +"次");
                }
            }
        };
        t1.setPriority(Thread.MAX_PRIORITY);
        t2.setPriority(Thread.MIN_PRIORITY);
        t1.start();
        t2.start();

    }
    public static void main(String[] args) throws InterruptedException {
        //SleepShow();
        //JoinShow();
        PriorityShow();
    }
}
