package com.cui.stu.design.bridge.bnew;

import sun.rmi.transport.Endpoint;

/**
 * @Auther: csx
 * @Date: 2022/4/10 20:29
 * @Description:
 */
public class Engine2000 implements Engine {
    @Override
    public void installEngine() {
        System.out.println("安装2000cc发动机");
    }
}
