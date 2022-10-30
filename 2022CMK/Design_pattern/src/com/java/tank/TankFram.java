package com.java.tank;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @Auther: csx
 * @Date: 2022/3/27 10:24
 * @Description:
 */
public class TankFram extends Frame {
    int x = 200;
    int y = 200;

    public TankFram() throws HeadlessException {
        // 设置窗口的大小
        setSize(800, 600);
        //设置窗口不可以改变
        setResizable(false);
        //设置窗口标题
        setTitle("Tank war");
        setVisible(true);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    @Override
    public void paint(Graphics g) {
        g.fillRect(x, y, 50, 50);
        x += 10;
        y += 10;
    }
    class MyKeyListerner extends KeyAdapter{

    }
}
