package com.huawei.proxy;

/**
 * @Auther: csx
 * @Date: 2022/3/11 22:33
 * @Description:
 */
public class Client {
    public static void main(String[] args) {
        Tank t = new Tank();

        Moveable m = (Moveable)Proxy.newProxyInstance();

        m.move();
    }
}
