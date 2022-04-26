package jwtt;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

public class GameK extends JFrame implements KeyListener
{
    // TODO 1.声明变量在此



    // ------------------------------------
    JMenuBar  menubar;
    JMenu     menu;
    JMenuItem start;
    JMenuItem stop;
    JMenuItem exit;
    面板        mb;
    定时器       ds1;
    定时器       ds2;

    public GameK()
    {
        // TODO 2.初始化在此


        // ---------------------------------------------------
        ds1 = new 定时器("rk", 100);
        ds2 = new 定时器("my", 200);
        ds1.start();
        ds2.start();
        menubar = new JMenuBar();
        menu = new JMenu("游戏");
        start = new JMenuItem("开始");
        stop = new JMenuItem("暂停");
        exit = new JMenuItem("退出");
        this.setJMenuBar(menubar);
        menubar.add(menu);
        menu.add(start);
        menu.add(stop);
        menu.add(exit);
        this.addKeyListener(this);
        this.setBounds(200, 100, 822 + 20, 660 + 12);
        this.setTitle("飞机大战游戏");
        mb = new 面板();
        this.add(mb);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args)
    {
        new GameK();
    }

    @Override
    public void keyPressed(KeyEvent e)
    {
        // TODO 4.键盘处理
        int key = e.getKeyCode();// 按键的ASCII值
        switch (key)
        {
            case KeyEvent.VK_LEFT:

                break;
            case KeyEvent.VK_UP:

                break;
            case KeyEvent.VK_RIGHT:

                break;
            case KeyEvent.VK_DOWN:

                break;
            case KeyEvent.VK_SPACE:

                break;
        }
        repaint();
    }

    class 面板 extends JPanel
    {

        @Override
        public void paint(Graphics g)
        {
            // 1.画图片
            Image tu1=(new ImageIcon( "URL" )).getImage();
            // 路径：图片-右键-属性-路径src/
            g.drawImage(tu1,200,400,null);
            // 2.设定颜色：RED GREEN BLUE ORANGE WHITE GRAY BLACK PINK
            g.setColor(Color.BLUE);
            // 3.划竖线
            //g.drawLine(300, 200, 300, 400);
            // 横线
            //g.drawLine(200, 300, 400, 300);
            // 4. 画矩形： g.drawRect(左,上,宽,高);
            // 5.画实心矩形：g.fillRect(左,上,宽,高);
            // 6.画椭圆：
            // 眼睛
            g.fillOval(280,188,5,5);
            g.fillOval(313,188,5,5);
            // 头
            g.drawOval(280,180,40,40);
            // 前肢
            g.drawOval(220,200,30,30);
            g.drawOval(350,200,30,30);
            // 身体
            g.fillOval(200,200,200,200);
            // 后肢
            g.drawOval(220,380,30,30);
            g.drawOval(350,380,30,30);
            // 尾巴
            g.drawOval(290,380,10,40);
            // 7.画实心椭圆：g.fillOval(左,上,宽,高);
            // 8.Font font=new Font("宋体",Font.BOLD,30);
            // g.setFont(font);
            // g.setColor(Color.yellow);
            // 绘制文本： g.drawString(文本, 左, 上);

            // TODO 3.绘图在此

            // --------------------------------------
            repaint();
        }
    }

    class 定时器 extends Thread
    {
        String name;
        long   jg;

        public 定时器(String name, long jg)
        {
            this.name = name;
            this.jg = jg;
        }

        @Override
        public void run()
        {
            while (true)
            {
                if (this == ds1)
                {
                    // TODO 5.定时在此


                }
                else
                {

                }
                try
                {
                    Thread.sleep(jg);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
        }

    }

    @Override
    public void keyTyped(KeyEvent e)
    {

    }

    @Override
    public void keyReleased(KeyEvent e)
    {

    }
}
