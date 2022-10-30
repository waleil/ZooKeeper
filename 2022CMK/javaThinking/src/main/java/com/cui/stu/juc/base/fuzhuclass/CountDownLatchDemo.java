package com.cui.stu.juc.base.fuzhuclass;

import java.util.concurrent.CountDownLatch;

/**
 * @Auther: csx
 * @Date: 2022/8/29 22:08
 * @Description:
 */
public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {

        CountDownLatch countDownLatch = new CountDownLatch(6);
        for (int i = 1; i <= 6; i++) {
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"号同学离开了教师");
                countDownLatch.countDown();
            },String.valueOf(i)).start();
        }
        countDownLatch.await();
        System.out.println(Thread.currentThread().getName()+"班长锁门走人");
    }
}
