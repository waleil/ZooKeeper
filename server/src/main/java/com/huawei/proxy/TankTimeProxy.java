package com.huawei.proxy;

/**
 * @Auther: csx
 * @Date: 2022/3/8 22:29
 * @Description:
 */
public class TankTimeProxy implements Moveable {
    Moveable t;

    public TankTimeProxy(Moveable t) {
        super();
        this.t = t;
    }


    @Override
    public void move() {
        Long start = System.currentTimeMillis();
        System.out.println("开始");
        t.move();
        System.out.println("结束");
        Long end = System.currentTimeMillis();
        System.out.println("time:"+(end-start));
    }

    @Override
    public void stop() {
        Long start = System.currentTimeMillis();
        System.out.println("开始");
        t.stop();
        System.out.println("结束");
        Long end = System.currentTimeMillis();
        System.out.println("time:"+(end-start));
    }
}
