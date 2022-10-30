package com.huawei.proxy;

/**
 * @Auther: csx
 * @Date: 2022/3/8 22:23
 * @Description:
 */
public class Tank3 implements Moveable{
    Tank t;
    public Tank3(Tank t){
        super();
        this.t = t;
    }


    @Override
    public void move() {
        t.move();
    }

    @Override
    public void stop() {

    }
}
