package javaAdvanced.c6_GUI;

import org.w3c.dom.ls.LSOutput;

import java.awt.event.*;
import java.io.File;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
public class d2_Listener {
    public static void main(String[] args) throws IOException {
        JFrame f = new JFrame("南开大学");
        f.setSize(400, 300);
        f.setLocation(580, 200);
        f.setLayout(null);
        final JLabel l = new JLabel();

        //获取当前文件夹路径，并组合成1.jpg的绝对路径
        String s = System.getProperty("user.dir")+"/1.jpg";
        System.out.println(s);
        ImageIcon i = new ImageIcon(s);
        l.setIcon(i);
        l.setBounds(80, 20, i.getIconWidth(), i.getIconHeight());
        JButton b = new JButton("隐藏图片");
        b.setBounds(150, 200, 100, 30);

/*
创建一个匿名类实现ActionListener接口，当按钮被点击时，actionPerformed方法就会被调用
 */
        // 给按钮增加事件监听
        b.addActionListener(new ActionListener() {
            // 当按钮被点击时，就会触发 ActionEvent事件
            // actionPerformed 方法就会被执行
            public void actionPerformed(ActionEvent e) {
                if(l.isVisible()){
                    l.setVisible(false);
                    b.setText("显示图片");
                }else{
                    l.setVisible(true);
                    b.setText("隐藏图片");
                }
            }
        });

/*
键盘监听器： KeyListener
keyPressed 代表 键被按下
keyReleased 代表 键被弹起
keyTyped 代表 一个按下弹起的组合动作
KeyEvent.getKeyCode() 可以获取当前点下了哪个键
 */
        // 增加键盘监听
        f.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent keyEvent) {
            }
            @Override
            public void keyPressed(KeyEvent keyEvent) {
            }
            @Override
            public void keyReleased(KeyEvent e) {
                //keyCode与方向的对应关系
                //38 上
                //40 下
                //37 左
                //39 右
                int step = 10;
                if (e.getKeyCode() == 38) {
                    // 图片向上移动 （x坐标不变，y坐标减少）
                    l.setLocation(l.getX() , l.getY()- step);
                }
                if (e.getKeyCode() == 40) {
                    // 图片向下移动 （x坐标不变，y坐标增加）
                    l.setLocation(l.getX() , l.getY()+ step);
                }
                if (e.getKeyCode() == 37) {
                    // 图片向左移动 （y坐标不变，x坐标减少）
                    l.setLocation(l.getX() - step, l.getY());
                }
                if (e.getKeyCode() == 39) {
                    // 图片向右移动 （y坐标不变，x坐标增加）
                    l.setLocation(l.getX() + step, l.getY());
                }
            }
        });

/*
MouseListener 鼠标监听器
mouseReleased 鼠标释放
mousePressed 鼠标按下
mouseExited 鼠标退出
mouseEntered 鼠标进入
mouseClicked 鼠标点击
在本例中，使用mouseEntered，当鼠标进入图片的时候，图片就移动位置
 */
        // 增加键盘监听
        l.addMouseListener(new MouseListener(){
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
            }
            @Override
            public void mousePressed(MouseEvent mouseEvent) {
            }
            @Override
            public void mouseReleased(MouseEvent mouseEvent) {
            }
            @Override
            public void mouseEntered(MouseEvent mouseEvent) {
                l.setLocation(f.getWidth()-l.getWidth(),f.getHeight() - l.getHeight());
            }
            @Override
            public void mouseExited(MouseEvent mouseEvent) {
            }
        });
        f.add(l);
        f.add(b);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        f.setVisible(true);
    }
}
