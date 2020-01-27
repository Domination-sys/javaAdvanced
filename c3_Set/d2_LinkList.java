package javaAdvanced.c3_Set;

/*
序列分先进先出FIFO,先进后出FILO
FIFO在Java中又叫Queue 队列
FILO在Java中又叫Stack 栈
LinkedList还实现了双向链表结构Deque，可以很方便的在头尾插入删除数据
 */

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class d2_LinkList {
    //LinkList实现了List，所以也有add,remove,contains等等方法
    //链表略
    //双向链表
    public static void DequeShow(){
        Deque<Student> ll = new LinkedList<>();

        //在最前面插入元素
        ll.addFirst(new Student("最前面"));
        //在最后面插入元素
        ll.addLast(new Student("最后面"));

        //查看头尾的元素
        ll.getFirst();
        ll.getLast();

        //取出头尾的元素（查看+删除）
        ll.removeFirst();
        ll.removeLast();
    }

    //队列
    //队列是用LinkedList实现的，所以右侧是new一个LinkedList（期末会考）
    public static void QueueShow(){
        Queue<Student> q = new LinkedList<>();
        //放入队列
        q.offer(new Student("example1"));
        //取出
        q.poll();
        //查看
        q.peek();
    }

    //栈
    //栈不是通过LinkedList实现的，所以右侧是new一个Stack
    public static void StackShow(){
        Stack<Student> s = new Stack<Student>();
        //压入栈中
        s.push(new Student("example"));
        //查看栈顶元素
        s.peek();
        //弹出栈顶元素
        s.pop();
    }
}
