package javaAdvanced.c6_GUI;

import javax.swing.*;

/*
JFrame是最常用的窗体型容器，默认情况下，在右上角有最大化最小化按钮
JDialog也是窗体型容器，右上角没有最大和最小化按钮
 */
public class d3_Container {
    public static void main(String[] args) {
        JFrame f = new JFrame("外部窗体");
        f.setSize(800, 600);
        f.setLocation(100, 100);

        // 根据外部窗体实例化JDialog
        JDialog d = new JDialog(f);
        //当一个对话框被设置为模态的时候，其背后的父窗体，是不能被激活的，除非该对话框被关闭
        // 设置为模态
        d.setModal(true);

        d.setTitle("模态的对话框");
        d.setSize(400, 300);
        d.setLocation(200, 200);
        d.setLayout(null);
        JButton b = new JButton("允公允能");
        b.setBounds(50, 50, 280, 30);
        d.add(b);

        // 窗体大小不可变化
        d.setResizable(false);

        f.setVisible(true);
        d.setVisible(true);
    }
}
