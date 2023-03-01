package keyboard;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.JTextField;

/**
 * 虚拟键盘(键盘的按下与释放)
 */
public class KeyBoard extends JFrame { //创建“键盘”类继承JFrame
    //声明窗体中的成员组件
    private JPanel contentPane;
    private JTextField textField;
    private JButton btnQ;
    private JButton btnW;
    private JButton btnE;
    private JButton btnR;
    private JButton btnT;
    private JButton btnY;
    private JButton btnU;
    private JButton btnI;
    private JButton btnO;
    private JButton btnP;
    private JButton btnA;
    private JButton btnS;
    private JButton btnD;
    private JButton btnF;
    private JButton btnG;
    private JButton btnH;
    private JButton btnJ;
    private JButton btnK;
    private JButton btnL;
    private JButton btnZ;
    private JButton btnX;
    private JButton btnC;
    private JButton btnV;
    private JButton btnB;
    private JButton btnN;
    private JButton btnM;
    Color green=Color.GREEN;//定义Color对象，用来表示按下键的颜色
    Color white=Color.WHITE;//定义Color对象，用来表示释放键的颜色

    ArrayList<JButton> btns=new ArrayList<JButton>();//定义一个集合，用来存储所有的按键ID
    //自定义一个方法，用来将容器中的所有JButton组件添加到集合中
    private void addButtons(){
        for(Component cmp :contentPane.getComponents()){//遍历面板中的所有组件
            if(cmp instanceof JButton){//判断组件的类型是否为JButton类型
                btns.add((JButton)cmp);//将JButton组件添加到集合中
            }
        }
    }

    /**
     * 主方法
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() { //使得Runnable中的的run()方法在the system EventQueue的指派线程中被调用
            public void run() {
                try {
                    KeyBoard frame = new KeyBoard(); //创建KeyBoard对象
                    frame.setVisible(true); //使frame可视
                    frame.addButtons();//初始化存储所有按键的集合
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * 创建JFrame窗体
     */
    public KeyBoard() { //KeyBoard的构造方法
        setTitle("\u865A\u62DF\u952E\u76D8\uFF08\u6A21\u62DF\u952E\u76D8\u7684\u6309\u4E0B\u4E0E\u91CA\u653E\uFF09"); //设置窗体题目
        setResizable(false); //不可改变窗体宽高
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //设置窗体关闭的方式
        setBounds(100, 100, 548, 280); //设置窗体的位置和宽高
        /**
         * 创建JPanel面板contentPane置于JFrame窗体中，并设置面板的背景色、边距和布局
         */
        contentPane = new JPanel();
        contentPane.setBackground(Color.WHITE);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        /**
         * 创建按钮button置于面板contentPane中，设置按钮的背景色、位置、宽高以及按钮中的字体位置、内容、样式
         */
        btnQ = new JButton("Q");
        btnQ.setBackground(white);
        btnQ.setVerticalAlignment(SwingConstants.TOP);
        btnQ.setHorizontalAlignment(SwingConstants.LEADING);
        btnQ.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        btnQ.setBounds(0, 60, 47, 45);
        contentPane.add(btnQ);
        /**
         * 创建按钮button_2置于面板contentPane中，设置按钮的背景色、位置、宽高以及按钮中的字体位置、内容、样式
         */
        btnW = new JButton("W");
        btnW.setBackground(white);
        btnW.setVerticalAlignment(SwingConstants.TOP);
        btnW.setHorizontalAlignment(SwingConstants.LEADING);
        btnW.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        btnW.setBounds(55, 60, 49, 45);
        contentPane.add(btnW);
        /**
         * 创建按钮button_3置于面板contentPane中，设置按钮的背景色、位置、宽高以及按钮中的字体位置、内容、样式
         */
        btnE = new JButton("E");
        btnE.setBackground(white);
        btnE.setVerticalAlignment(SwingConstants.TOP);
        btnE.setHorizontalAlignment(SwingConstants.LEADING);
        btnE.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        btnE.setBounds(110, 60, 45, 45);
        contentPane.add(btnE);
        /**
         * 创建按钮button_4置于面板contentPane中，设置按钮的背景色、位置、宽高以及按钮中的字体位置、内容、样式
         */
        btnR = new JButton("R");
        btnR.setBackground(white);
        btnR.setVerticalAlignment(SwingConstants.TOP);
        btnR.setHorizontalAlignment(SwingConstants.LEADING);
        btnR.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        btnR.setBounds(165, 60, 45, 45);
        contentPane.add(btnR);
        /**
         * 创建按钮button_5置于面板contentPane中，设置按钮的背景色、位置、宽高以及按钮中的字体位置、内容、样式
         */
        btnF = new JButton("F");
        btnF.setBackground(white);
        btnF.setVerticalAlignment(SwingConstants.TOP);
        btnF.setHorizontalAlignment(SwingConstants.LEADING);
        btnF.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        btnF.setBounds(195, 125, 45, 45);
        contentPane.add(btnF);
        /**
         * 创建按钮button_6置于面板contentPane中，设置按钮的背景色、位置、宽高以及按钮中的字体位置、内容、样式
         */
        btnD = new JButton("D");
        btnD.setBackground(white);
        btnD.setVerticalAlignment(SwingConstants.TOP);
        btnD.setHorizontalAlignment(SwingConstants.LEADING);
        btnD.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        btnD.setBounds(137, 125, 45, 45);
        contentPane.add(btnD);

        btnT = new JButton("T");
        btnT.setVerticalAlignment(SwingConstants.TOP);
        btnT.setHorizontalAlignment(SwingConstants.LEADING);
        btnT.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        btnT.setBackground(white);
        btnT.setBounds(220, 60, 45, 45);
        contentPane.add(btnT);

        btnY = new JButton("Y");
        btnY.setVerticalAlignment(SwingConstants.TOP);
        btnY.setHorizontalAlignment(SwingConstants.LEADING);
        btnY.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        btnY.setBackground(white);
        btnY.setBounds(275, 60, 45, 45);
        contentPane.add(btnY);

        btnU = new JButton("U");
        btnU.setVerticalAlignment(SwingConstants.TOP);
        btnU.setHorizontalAlignment(SwingConstants.LEADING);
        btnU.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        btnU.setBackground(white);
        btnU.setBounds(330, 60, 45, 45);
        contentPane.add(btnU);

        btnI = new JButton("I");
        btnI.setVerticalAlignment(SwingConstants.TOP);
        btnI.setHorizontalAlignment(SwingConstants.LEADING);
        btnI.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        btnI.setBackground(white);
        btnI.setBounds(385, 60, 45, 45);
        contentPane.add(btnI);

        btnO = new JButton("O");
        btnO.setVerticalAlignment(SwingConstants.TOP);
        btnO.setHorizontalAlignment(SwingConstants.LEADING);
        btnO.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        btnO.setBackground(white);
        btnO.setBounds(440, 60, 46, 45);
        contentPane.add(btnO);

        btnP = new JButton("P");
        btnP.setVerticalAlignment(SwingConstants.TOP);
        btnP.setHorizontalAlignment(SwingConstants.LEADING);
        btnP.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        btnP.setBackground(white);
        btnP.setBounds(495, 60, 45, 45);
        contentPane.add(btnP);

        btnA = new JButton("A");
        btnA.setVerticalAlignment(SwingConstants.TOP);
        btnA.setHorizontalAlignment(SwingConstants.LEADING);
        btnA.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        btnA.setBackground(white);
        btnA.setBounds(23, 125, 45, 45);
        contentPane.add(btnA);

        btnS = new JButton("S");
        btnS.setVerticalAlignment(SwingConstants.TOP);
        btnS.setHorizontalAlignment(SwingConstants.LEADING);
        btnS.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        btnS.setBackground(white);
        btnS.setBounds(82, 125, 45, 45);
        contentPane.add(btnS);

        btnG = new JButton("G");
        btnG.setVerticalAlignment(SwingConstants.TOP);
        btnG.setHorizontalAlignment(SwingConstants.LEADING);
        btnG.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        btnG.setBackground(white);
        btnG.setBounds(251, 125, 45, 45);
        contentPane.add(btnG);

        btnH = new JButton("H");
        btnH.setVerticalAlignment(SwingConstants.TOP);
        btnH.setHorizontalAlignment(SwingConstants.LEADING);
        btnH.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        btnH.setBackground(white);
        btnH.setBounds(306, 125, 45, 45);
        contentPane.add(btnH);

        btnJ = new JButton("J");
        btnJ.setVerticalAlignment(SwingConstants.TOP);
        btnJ.setHorizontalAlignment(SwingConstants.LEADING);
        btnJ.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        btnJ.setBackground(white);
        btnJ.setBounds(361, 125, 45, 45);
        contentPane.add(btnJ);

        btnK = new JButton("K");
        btnK.setVerticalAlignment(SwingConstants.TOP);
        btnK.setHorizontalAlignment(SwingConstants.LEADING);
        btnK.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        btnK.setBackground(white);
        btnK.setBounds(416, 125, 47, 45);
        contentPane.add(btnK);

        btnL = new JButton("L");
        btnL.setVerticalAlignment(SwingConstants.TOP);
        btnL.setHorizontalAlignment(SwingConstants.LEADING);
        btnL.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        btnL.setBackground(white);
        btnL.setBounds(471, 125, 45, 45);
        contentPane.add(btnL);

        btnZ = new JButton("Z");
        btnZ.setVerticalAlignment(SwingConstants.TOP);
        btnZ.setHorizontalAlignment(SwingConstants.LEADING);
        btnZ.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        btnZ.setBackground(white);
        btnZ.setBounds(39, 190, 45, 45);
        contentPane.add(btnZ);

        btnX = new JButton("X");
        btnX.setVerticalAlignment(SwingConstants.TOP);
        btnX.setHorizontalAlignment(SwingConstants.LEADING);
        btnX.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        btnX.setBackground(white);
        btnX.setBounds(107, 190, 45, 45);
        contentPane.add(btnX);

        btnC = new JButton("C");
        btnC.setVerticalAlignment(SwingConstants.TOP);
        btnC.setHorizontalAlignment(SwingConstants.LEADING);
        btnC.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        btnC.setBackground(white);
        btnC.setBounds(178, 190, 45, 45);
        contentPane.add(btnC);

        btnV = new JButton("V");
        btnV.setVerticalAlignment(SwingConstants.TOP);
        btnV.setHorizontalAlignment(SwingConstants.LEADING);
        btnV.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        btnV.setBackground(white);
        btnV.setBounds(250, 190, 45, 45);
        contentPane.add(btnV);

        btnB = new JButton("B");
        btnB.setVerticalAlignment(SwingConstants.TOP);
        btnB.setHorizontalAlignment(SwingConstants.LEADING);
        btnB.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        btnB.setBackground(white);
        btnB.setBounds(315, 190, 45, 45);
        contentPane.add(btnB);

        btnN = new JButton("N");
        btnN.setVerticalAlignment(SwingConstants.TOP);
        btnN.setHorizontalAlignment(SwingConstants.LEADING);
        btnN.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        btnN.setBackground(white);
        btnN.setBounds(382, 190, 47, 45);
        contentPane.add(btnN);

        btnM = new JButton("M");
        btnM.setVerticalAlignment(SwingConstants.TOP);
        btnM.setHorizontalAlignment(SwingConstants.LEADING);
        btnM.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        btnM.setBackground(white);
        btnM.setBounds(449, 190, 48, 45);
        contentPane.add(btnM);
        /**
         * 创建面板panel置于面板contentPane中，设置面板panel的位置、宽高、TitledBorder、背景色以及布局方式（边界布局）
         */
        JPanel panel = new JPanel();
        panel.setBorder(new TitledBorder(null, "文本显示区", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panel.setBackground(Color.WHITE);
        panel.setBounds(0, 0, 540, 45);
        contentPane.add(panel);
        panel.setLayout(new BorderLayout(0, 0));


        /**
         * 创建文本框textField置于面板panel的中间
         */
        textField = new JTextField();
        textField.addKeyListener(new KeyAdapter() { //文本框添加键盘事件的监听
            char word;
            @Override
            public void keyPressed(KeyEvent e) { //按键被按下时被触发
                word=e.getKeyChar();//获取按下键表示的字符
                for(int i=0;i<btns.size();i++){//遍历存储按键ID的ArrayList集合
                    //判断按键是否与遍历到的按键的文本相同
                    if(String.valueOf(word).equalsIgnoreCase(btns.get(i).getText())){
                        btns.get(i).setBackground(green);//将指定按键颜色设置为绿色
                    }
                }
            }
            @Override
            public void keyReleased(KeyEvent e) { //按键被释放时被触发
                word=e.getKeyChar();//获取释放键表示的字符
                for(int i=0;i<btns.size();i++){//遍历存储按键ID的ArrayList集合
                    //判断按键是否与遍历到的按键的文本相同
                    if(String.valueOf(word).equalsIgnoreCase(btns.get(i).getText())){
                        btns.get(i).setBackground(white);//将指定按键颜色设置为白色
                    }
                }
            }
        });
        panel.add(textField, BorderLayout.CENTER);
        textField.setColumns(10);
    }
}
