package MyJDialog;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

class MyJDialog extends JDialog { // 创建自定义对话框类，并继承JDialog类
    public MyJDialog(MyFrame frame) {
        // 实例化一个JDialog类对象，指定对话框的父窗体、窗体标题和类型
        super(frame, "第一个JDialog窗体", true);
        Container container = getContentPane(); // 创建一个容器
        container.add(new JLabel("这是一个对话框")); // 在容器中添加标签
        setBounds(120, 120, 100, 100); // 设置对话框窗体在桌面显示的坐标和大小
    }
}

public class MyFrame extends JFrame { // 创建父窗体类
    public MyFrame() {
        Container container = getContentPane(); // 获得窗体容器
        container.setLayout(null); // 容器使用null布局
        JButton bl = new JButton("弹出对话框"); // 定义一个按钮
        bl.setBounds(10, 10, 100, 21); // 定义按钮在容器中的坐标和大小
        bl.addActionListener(new ActionListener() { // 为按钮添加点击事件
            public void actionPerformed(ActionEvent e) {
                // 创建MyJDialo对话框
                MyJDialog dialog = new MyJDialog(MyFrame.this);
                dialog.setVisible(true); // 使MyJDialog窗体可见
            }
        });
        container.add(bl); // 将按钮添加到容器中
        container.setBackground(Color.WHITE); // 容器背景色为白色
        setSize(200, 200); // 窗口大小
        // 窗口关闭后结束程序
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true); // 使窗口可见
    }

    public static void main(String args[]) {
        new MyFrame(); // 实例化MyFrame类对象
    }
}
