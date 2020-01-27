package javaAdvanced.c3_Set;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
Collections是一个类，容器的工具类,就如同Arrays是数组的工具类
 */
public class d6_Collections {
    public static void main(String[] args) {
        //初始化集合numbers
        List<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            numbers.add(i);
        }

        System.out.println("集合中的数据:");
        System.out.println(numbers);

        Collections.shuffle(numbers);
        System.out.println("混淆后集合中的数据:");
        System.out.println(numbers);

        Collections.sort(numbers);
        System.out.println("排序后集合中的数据:");
        System.out.println(numbers);

        Collections.swap(numbers,0,5);
        System.out.println("交换0和5下标的数据后，集合中的数据:");
        System.out.println(numbers);

        Collections.rotate(numbers,2);
        System.out.println("把集合向右滚动2个单位，标的数据后，集合中的数据:");
        System.out.println(numbers);

    }
}
