package javaAdvanced.c3_Set;

/*
Set中的元素，不能重复
Set中的元素，没有顺序。
严格的说，是没有按照元素的插入顺序排列
Set不提供get()来获取指定位置的元素
所以遍历需要用到迭代器，或者增强型for循环
 */

/*
原理：
通过观察HashSet的源代码
可以发现HashSet自身并没有独立的实现，而是在里面封装了一个Map.
HashSet是作为Map的key而存在的
而value是一个命名为PRESENT的static的Object对象，因为是一个类属性，所以只会有一个。
private static final Object PRESENT = new Object();
 */

import java.util.HashSet;
import java.util.Iterator;

public class d5_HashSet {
    public static void main(String[] args) {
        HashSet<Integer> numbers = new HashSet<Integer>();

        for (int i = 0; i < 20; i++) {
            numbers.add(i);
        }

        //Set不提供get方法来获取指定位置的元素
        //numbers.get(0)

        //遍历Set可以采用迭代器iterator
        for (Iterator<Integer> iterator = numbers.iterator(); iterator.hasNext();) {
            Integer i = (Integer) iterator.next();
            System.out.println(i);
        }

        //或者采用增强型for循环
        for (Integer i : numbers) {
            System.out.println(i);
        }

    }
}
