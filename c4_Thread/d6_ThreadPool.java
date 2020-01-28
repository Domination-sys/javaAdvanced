package javaAdvanced.c4_Thread;
/*
每一个线程的启动和结束都是比较消耗时间和占用资源的。
如果在系统中用到了很多的线程，大量的启动和结束动作会导致系统的性能变卡，响应变慢。
为了解决这个问题，引入线程池这种设计思想。

线程池的思路和生产者消费者模型是很接近的。
1. 准备一个任务容器
2. 一次性启动10个 消费者线程
3. 刚开始任务容器是空的，所以线程都wait在上面。
4. 直到一个外部线程往这个任务容器中扔了一个“任务”，就会有一个消费者线程被唤醒notify
5. 这个消费者线程取出“任务”，并且执行这个任务，执行完毕后，继续等待下一次任务的到来。
6. 如果短时间内，有较多的任务加入，那么就会有多个线程被唤醒，去执行这些任务。

在整个过程中，都不需要创建新的线程，而是循环使用这些已经存在的线程
 */

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class d6_ThreadPool {
    public static void main(String[] args) throws InterruptedException {

        ThreadPoolExecutor threadPool= new ThreadPoolExecutor(10, 15, 60, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());
/*
第一个参数10 表示这个线程池初始化了10个线程在里面工作
第二个参数15 表示如果10个线程不够用了，就会自动增加到最多15个线程
第三个参数60 结合第四个参数TimeUnit.SECONDS，表示经过60秒，多出来的线程还没有接到活儿，就会回收，最后保持池子里就10个
第四个参数TimeUnit.SECONDS 如上
第五个参数 new LinkedBlockingQueue() 用来放任务的集合

execute方法用于添加新的任务
 */
        threadPool.execute(new Runnable(){
            @Override
            public void run() {
                // TODO Auto-generated method stub
                System.out.println("任务1");
            }
        });
    }
}
