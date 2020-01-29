package javaAdvanced.c3_Set.exercise;

import java.util.LinkedList;
import java.util.List;


public class 搜索性能比较 {
    public static void main(String[] args) {
        int[] arr1 = new int[40000];
        int[] arr2 = new int[40000];
        int[] arr3 = new int[40000];
        long startTime,endTime;
        for(int i=0;i<40000;i++){
            arr1[i] =(int)(Math.random()*40000);
            arr2[i] =(int)(Math.random()*40000);
            arr3[i] =(int)(Math.random()*40000);
        }

        System.out.println("用三种排序方式排序四万个数");

        startTime =  System.currentTimeMillis();
        Bubble.BubbleSort(arr1);
        endTime =  System.currentTimeMillis();
        System.out.println("泡泡排序消耗的时间为"+(endTime-startTime)+"毫秒");

        startTime =  System.currentTimeMillis();
        Select.SelectSort(arr2);
        endTime =  System.currentTimeMillis();
        System.out.println("选择排序消耗的时间为"+(endTime-startTime)+"毫秒");

        startTime =  System.currentTimeMillis();
        BinaryTree.BinaryTreeSort(arr3);
        endTime =  System.currentTimeMillis();
        System.out.println("二叉树排序消耗的时间为"+(endTime-startTime)+"毫秒");
    }
}

//冒泡
class Bubble {
    public static List<Object> BubbleSort(int[] sourceData){
        for(int i=0;i<sourceData.length;i++){
            for(int j=0;j<sourceData.length-i-1;j++){
                if(sourceData[j+1]<sourceData[j]){
                    sourceData[j+1]+=sourceData[j];
                    sourceData[j] = sourceData[j+1]-sourceData[j];
                    sourceData[j+1] -= sourceData[j];
                }
            }
        }
        List<Object> dstData = new LinkedList<>();
        for(int i:sourceData)
            dstData.add(i);
        return dstData;
    }
}

//选择
class Select {
    public static List<Object> SelectSort(int[] sourceData){
        for(int i=0;i<sourceData.length-1;i++){
            for(int j=i+1;j<sourceData.length;j++){
                if(sourceData[i]>sourceData[j]){
                    sourceData[i] += sourceData[j];
                    sourceData[j] = sourceData[i]-sourceData[j];
                    sourceData[i] -= sourceData[j];
                }
            }
        }
        LinkedList dstData = new LinkedList();
        for(int i:sourceData)
            dstData.add(i);
        return dstData;
    }
}

//二叉树
class BinaryTree {
    public static List<Object> BinaryTreeSort(int[] sourceData) {
        Node root = new Node();
        for(int i:sourceData)
            root.insertElement(i);
        List<Object> dstData = root.values();
        return dstData;
    }
}

class Node{
    public Node ln; //left node
    public Node rn; //right node
    public Object v;   //value

    //插入数字,如果小就插在左节点，如果大就插在右节点
    public void insertElement(Object value){
        if(null == v)
            v = value;
        else {
            if((Integer)value<=(Integer)v){
                if(null == ln)
                    ln = new Node();
                ln.insertElement(value);
            }
            else{
                if(null == rn)
                    rn = new Node();
                rn.insertElement(value);
            }
        }
    }

    //二叉树遍历
    public List<Object> values(){
        List<Object> values = new LinkedList<>();
        if(null!=ln)
            values.addAll(ln.values());
        values.add(v);
        if(null!=rn)
            values.addAll(rn.values());
        return values;

    }
}