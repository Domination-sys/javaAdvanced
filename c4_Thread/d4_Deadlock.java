package javaAdvanced.c4_Thread;

/*
1. 线程1 首先占有对象1，接着试图占有对象2
2. 线程2 首先占有对象2，接着试图占有对象1
3. 线程1 等待线程2释放对象2
4. 与此同时，线程2等待线程1释放对象1
就会。。。一直等待下去，直到天荒地老，海枯石烂，山无棱 ，天地合。。。
下面是三个对象的死锁演示
 */
public class d4_Deadlock {
    public static void main(String[] args) {
        Object a = new Object();
        Object b = new Object();
        Object c = new Object();

        Thread t1 = new Thread(){
            public void run(){
                synchronized (a){
                    try {
                        sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (b){
                        synchronized (c){
                            System.out.println("t1线程成功获取三个对象锁");
                        }
                    }
                }
            }
        };

        Thread t2 = new Thread(){
            public void run(){
                synchronized (c){
                    try {
                        sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (b){
                        synchronized (a){
                            System.out.println("t2线程成功获取三个对象锁");
                        }
                    }
                }
            }
        };

        Thread t3 = new Thread(){
            public void run(){
                synchronized (b){
                    try {
                        sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (a){
                        synchronized (c){
                            System.out.println("t3线程成功获取三个对象锁");
                        }
                    }
                }
            }
        };

        t1.start();
        t2.start();
        t3.start();
    }
}
