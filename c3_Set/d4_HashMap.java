package javaAdvanced.c3_Set;

import java.util.HashMap;

public class d4_HashMap {
    public static void main(String[] args) {
        //HashMap储存数据的方式是—— 键值对（键：key，值：value）
        HashMap<Integer,Student> hs = new HashMap<>();
        hs.put(1712933,new Student("王百韬"));
        hs.put(17129333,new Student("王千韬"));
        hs.put(171293333,new Student("王万韬"));
        System.out.println(hs);
        //通过key找value
        System.out.println(hs.get(1712933));
        //清空
        hs.clear();
        //value可以相同，但是key不能重复
        hs.put(1712933,new Student("王百韬"));
        hs.put(17129333,new Student("王百韬"));
        System.out.println(hs);
    }
}
