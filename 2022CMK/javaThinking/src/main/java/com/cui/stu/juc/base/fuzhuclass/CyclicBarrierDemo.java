package com.cui.stu.juc.base.fuzhuclass;

import java.util.concurrent.CyclicBarrier;

/*
 * 循环栅栏
 */
public class CyclicBarrierDemo {
    private static final int NUM = 7;

    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(NUM,()->{
            System.out.println("集齐7颗龙珠就可以召唤神龙");
        });

        for (int i = 1; i <= 7; i++) {
            new Thread(()->{
                try {
                    System.out.println(Thread.currentThread().getName()+"星龙珠被收集到了");
                    //等待
                    cyclicBarrier.await();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            },String.valueOf(i)).start();
        }
    }
}
