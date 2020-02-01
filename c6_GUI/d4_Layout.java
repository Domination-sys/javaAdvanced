package javaAdvanced.c6_GUI;

import javax.swing.*;
import java.awt.*;

/*
布局器是用在容器上的。 用来决定容器上的组件摆放的位置和大小
1. 绝对定位就是指不使用布局器，组件的位置和大小需要单独指定
    比如设定了布局器为null，即进行绝对定位，容器上的组件都需要指定位置和大小
    frame.setLayout(null);
    button.setBounds(250, 50, 80, 30);
2.FlowLayout,顺序布局器
    容器上的组件水平摆放
    加入到容器即可，无需单独指定大小和位置
3. BorderLayout，边框布局
    容器上的组件按照上北 下南 左西 右东 中的顺序摆放
4. GridLayout，即网格布局器
5.  即便 使用 布局器 ，也可以 通过setPreferredSize，向布局器建议该组件显示的大小.
 */
public class d4_Layout {
    public static void main(String[] args) {
        JFrame f_flow = new JFrame("顺序布局");
        JFrame f_border = new JFrame("边框布局");
        JFrame f_grid = new JFrame("网格布局");

        f_flow.setSize(400, 300);
        f_flow.setLocation(200, 200);
        f_border.setSize(400, 300);
        f_border.setLocation(600, 200);
        f_grid.setSize(400, 300);
        f_grid.setLocation(1000, 200);

        f_flow.setLayout(new FlowLayout());
        f_border.setLayout(new BorderLayout());
        f_grid.setLayout(new GridLayout(2, 3));//二行三列

        for(int i=0;i<6;i++){
            JButton b = new JButton(String.valueOf(i));
            f_flow.add(b);
        }

        JButton b1 = new JButton(String.valueOf(1));
        JButton b2 = new JButton(String.valueOf(2));
        JButton b3 = new JButton(String.valueOf(3));
        JButton b4 = new JButton(String.valueOf(4));
        JButton b5 = new JButton(String.valueOf(5));
        f_border.add(b1,BorderLayout.CENTER);
        f_border.add(b2,BorderLayout.EAST);
        f_border.add(b3,BorderLayout.WEST);
        f_border.add(b4,BorderLayout.NORTH);
        f_border.add(b5,BorderLayout.SOUTH);

        for(int i=0;i<6;i++){
            JButton b = new JButton(String.valueOf(i));
            f_grid.add(b);
        }

        f_flow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f_flow.setVisible(true);
        f_border.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f_border.setVisible(true);
        f_grid.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f_grid.setVisible(true);
    }
}
