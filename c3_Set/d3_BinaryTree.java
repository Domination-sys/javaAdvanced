package javaAdvanced.c3_Set;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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
        List<Object> values = new ArrayList<>();
        if(null!=ln)
            values.addAll(ln.values());
        values.add(v);
        if(null!=rn)
            values.addAll(rn.values());
        return values;

    }
}

public class d3_BinaryTree {

    //效果测试
    public static void main(String[] args) {
        Node root = new Node();
        for(int i=0;i<10;i++){
            int temp = (int)(Math.random()*1000);
            root.insertElement(temp);
            System.out.print(temp);
            System.out.print(" ");
        }

        System.out.println();
        //得到中序遍历二叉树后的顺序表
        List<Object> values = root.values();
        Iterator<Object> it = values.iterator();
        while (it.hasNext()){
            System.out.print(it.next());
            System.out.print(" ");
        }

        //关于
    }
}

