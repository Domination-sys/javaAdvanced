package javaAdvanced.c6_GUI.exercise;

import javax.swing.*;
import java.io.*;

/*
比如这次使用这个窗口，导致窗口被移动到了右下角。 关闭这个窗口，下一次再启动的时候，就会自动出现在右下角。
 */
public class e1_在上次关闭位置启动窗口 {
    public static void main(String[] args) {
        File file = new File("/Users/wangbotao/Desktop/窗体位置.txt");
        int x = 200,y=200;
            try (FileInputStream fis = new FileInputStream(file);DataInputStream dis = new DataInputStream(fis)){
                x = dis.readInt();
                y = dis.readInt();
                System.out.println("读出的位置为"+x+" "+y);
            } catch (IOException e) {
                e.printStackTrace();
            }

        JFrame f = new JFrame("南开大学无敌修改器");
        f.setSize(400,300);
        f.setLayout(null);
        f.setLocation(x,y);
        JButton b1 = new JButton("一键满绩");
        JButton b2 = new JButton("一键毕业");
        b1.setBounds(85,70,230,40);
        b2.setBounds(85,140,230,40);
        f.add(b1);
        f.add(b2);
        f.setDefaultCloseOperation(3);
        f.setVisible(true);

        Thread t = new Thread(){
            @Override
            public void run() {
                while (true){
                    try (FileOutputStream fos = new FileOutputStream(file);DataOutputStream dos = new DataOutputStream(fos)){
                        dos.writeInt(f.getX());
                        dos.writeInt(f.getY());
                        System.out.println("写入位置"+f.getX()+" "+f.getY());
                        sleep(1000);
                    } catch (IOException | InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        t.start();
    }

}
