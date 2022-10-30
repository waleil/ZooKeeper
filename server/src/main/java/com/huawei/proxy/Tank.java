package com.huawei.proxy;

import java.util.Random;

/**
 * @Auther: csx
 * @Date: 2022/3/8 21:20
 * @Description:
 */
public class Tank implements Moveable{
    @Override
    public void move()  {

        System.out.println("Tank Moving....");
        try {
            Thread.sleep(new Random().nextInt(10000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void stop() {
        System.out.println("Tank stop ...");
    }
}
