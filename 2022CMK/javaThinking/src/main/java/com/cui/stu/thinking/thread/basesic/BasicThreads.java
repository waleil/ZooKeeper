package com.cui.stu.thinking.thread.basesic;

/**
 * @Auther: csx
 * @Date: 2022/4/11 22:40
 * @Description:
 */
public class BasicThreads{
    public static void main(String[] args) {
        Thread t = new Thread(new LiftOff());
        t.start();
        System.out.println("Waiting for LiftOff");
    }
}