package javaAdvanced.c4_Thread;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/*
与synchronized类似的，lock也能够达到同步的效果
当一个线程占用 synchronized 同步对象，其他线程就不能占用了，直到释放这个同步对象为止

与 synchronized (someObject) 类似的，lock()方法，表示当前线程占用lock对象，一旦占用，其他线程就不能占用了。
与 synchronized 不同的是，一旦synchronized 块结束，就会自动释放对someObject的占用。 lock却必须调用unlock方法进行手动释放，为了保证释放的执行，往往会把unlock() 放在finally中进行。

Lock是一个接口，为了使用一个Lock对象，需要用到
Lock lock = new ReentrantLock();
 */
public class d7_Lock {
    public static String now(){
        return new SimpleDateFormat("HH:mm:ss").format(new Date());
    }
    public static void log(String msg){
        System.out.println(now() +" "+ Thread.currentThread().getName() +" "+ msg);
    }

    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        Thread t1 = new Thread(){
            public void run(){
                try {
                    log("线程启动");
                    log("试图占用资源：lock");
                    lock.lock();
                    log("成功占用资源：lock");
                    log("进行5秒业务操作");
                    sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    log("释放对象");
                    lock.unlock();
                }
                log("线程结束");
            }
        };
        Thread t2 = new Thread(){
            public void run(){
                try {
                    log("线程启动");
                    log("试图占用资源：lock");
                    lock.lock();
                    log("成功占用资源：lock");
                    log("进行5秒业务操作");
                    sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    log("释放对象");
                    lock.unlock();
                }
                log("线程结束");
            }
        };

        t1.setName("t1");
        t2.setName("t2");
        t1.start();
        t2.start();
    }

/*
*******else**********
* lock还有trylock的用法，懒得写了
* lock与synchronized区别
1. Lock是一个接口，而synchronized是Java中的关键字，synchronized是内置的语言实现，Lock是代码层面的实现。

2. Lock可以选择性的获取锁，如果一段时间获取不到，可以放弃。synchronized不行，会一根筋一直获取下去。 借助Lock的这个特性，就能够规避死锁，synchronized必须通过谨慎和良好的设计，才能减少死锁的发生。

3. synchronized在发生异常和同步块结束的时候，会自动释放锁。而Lock必须手动释放， 所以如果忘记了释放锁，一样会造成死锁。
 */
}
