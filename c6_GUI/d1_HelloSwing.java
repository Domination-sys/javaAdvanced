package javaAdvanced.c6_GUI;

import javax.swing.*;

/*
GUI-Graphic User Interface 图形用户界面
JFrame是GUI中的容器
JButton是最常见的组件- 按钮
注意：f.setVisible(true); 会对所有的组件进行渲染，所以一定要放在最后面
 */
public class d1_HelloSwing {
    public static void main(String[] args) {
    //创建是主窗体，相当于幕布
        JFrame f = new JFrame("南开大学");
    //设置大小
        f.setSize(400,300);
    //设置位置
        f.setLocation(200,200);
    //很重要！把自动的布局样式取消，改为设定坐标的绝对布局，要是不写这行将会让下面的button充斥整个frame
        f.setLayout(null);

    //创建按钮组件，相当于在幕布上作画
        JButton b = new JButton("一键毕业");
    //设置大小和位置
        b.setBounds(50,50,280,30);

    // 把按钮加入到主窗体中
        f.add(b);
    // 关闭窗体的时候，退出程序
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // 让窗体变得可见
        f.setVisible(true);

    }
}
