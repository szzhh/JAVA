package StrokeTest;

import java.awt.*;
import javax.swing.*;

public class StrokeTest extends JFrame {
    public StrokeTest() {
        super();
        initialize();// 调用初始化方法
    }

    private void initialize() { // 初始化方法
        this.setSize(300, 200); // 设置窗体大小
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 设置窗体关闭模式
        add(new CanvasTest()); // 设置窗体面板为绘图面板对象
        this.setTitle("设置画笔"); // 设置窗体标题
    }

    public static void main(String[] args) {
        new StrokeTest().setVisible(true);
    }

    class CanvasTest extends Canvas {// 创建画布
        public void paint(Graphics g) {
            super.paint(g);
            Graphics2D g2 = (Graphics2D) g;// 创建Graphics2D对象，用于画图
            // 创建画笔，宽度为8
            Stroke stroke = new BasicStroke(8);
            g2.setStroke(stroke);// 设置画笔
            g2.drawLine(20, 30, 120, 30);// 调用从Graphics类继承的drawLine方法绘制直线
            // 创建画笔，宽度为12，线端点的装饰为CAP_ROUND，应用在路径线段交汇处的装饰为JOIN_BEVEL
            Stroke roundStroke = new BasicStroke(12, BasicStroke.CAP_ROUND, BasicStroke.JOIN_BEVEL);
            g2.setStroke(roundStroke);
            g2.drawLine(20, 50, 120, 50);// 调用从Graphics类继承的drawLine方法绘制直线
        }
    }
}
