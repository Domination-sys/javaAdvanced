package javaAdvanced.c6_GUI.exercise;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
首先设计一个JFrame,上面有一个按钮，文字是 "打开一个模态窗口"。
点击该按钮后，随即打开一个模态窗口。
在这个模态窗口中有一个按钮，文本是 "锁定大小", 点击后，这个模态窗口的大小就被锁定住，不能改变。 再次点击，就回复能够改变大小
 */
public class e2_模态与大小变化 {
    public static void main(String[] args) {
        JFrame f = new JFrame("JFrame");
        f.setSize(400, 300);
        f.setLocation(580, 200);
        f.setLayout(null);
        JButton b = new JButton("打开一个模态窗口");
        b.setBounds(100, 200, 200, 30);
        f.add(b);
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JDialog d = new JDialog(f);
                d.setModal(true);
                d.setTitle("模态窗口");
                d.setSize(500, 500);
                d.setLocation(200, 200);
                d.setLayout(null);
                JButton bb = new JButton("锁定大小");
                bb.setBounds(100, 200, 200, 30);
                bb.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {
                        Boolean r = d.isResizable();
                        r = !r;
                        d.setResizable(r);
                        bb.setText(!r?"解锁大小":"锁定大小");
                    }
                });
                d.add(bb);
                d.setVisible(true);
            }
        });
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
}
