package Combox;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class JComboBoxTest extends JFrame {
    public JComboBoxTest() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("下拉列表框的使用");
        setBounds(100, 100, 317, 147);
        getContentPane().setLayout(null);//设置绝对布局

        JLabel lblNewLabel = new JLabel("请选择证件：");
        lblNewLabel.setBounds(28, 14, 80, 15);
        getContentPane().add(lblNewLabel);

        JComboBox<String> comboBox = new JComboBox<String>();//创建一个下拉列表框
        comboBox.setBounds(110, 11, 80, 21);//设置坐标
        comboBox.addItem("身份证");//为下拉列表中添加项
        comboBox.addItem("军人证");
        comboBox.addItem("学生证");
        comboBox.addItem("工作证");
        comboBox.addItem("残疾证");
        comboBox.setEditable(true);
        getContentPane().add(comboBox);//将下拉列表添加到容器中

        JLabel lblResult = new JLabel("");
        lblResult.setBounds(0, 57, 146, 15);
        getContentPane().add(lblResult);

        JButton btnNewButton = new JButton("确定");
        btnNewButton.setBounds(200, 10, 67, 23);
        getContentPane().add(btnNewButton);
        btnNewButton.addActionListener(new ActionListener() {//为按钮添加监听事件
            @Override
            public void actionPerformed(ActionEvent arg0) {
                lblResult.setText("您选择的是："+comboBox.getSelectedItem());//获取下拉列表中的选中项
            }
        });
    }
    public static void main(String[] args) {
        JComboBoxTest frame = new JComboBoxTest();//创建窗体对象
        frame.setVisible(true);//使窗体可见
    }
}