package com.cui.stu.juc.highlevel.atomic;

import com.cui.stu.juc.base.fuzhuclass.CountDownLatchDemo;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Condition;

/**
 * @Auther: csx
 * @Date: 2022/9/3 9:46
 * @Description:
 */
public class AtomicIntegerDemo {
    private static final int SIZE = 50;

    public static void main(String[] args) throws InterruptedException {
        MyNumber myNumber = new MyNumber();
        CountDownLatch countDownLatch = new CountDownLatch(SIZE);
        for (int i = 1; i <= SIZE; i++) {
                new Thread(()->{
                    try {
                        for (int j = 1; j <= 1000; j++) {
                            myNumber.addPlus();
                        }
                    } finally {
                        countDownLatch.countDown();
                    }
                }).start();

        }

        countDownLatch.await();
        System.out.println(myNumber.atomicInteger.get());
    }
}
