package com.cui.stu.juc.highlevel.atomic.longAdderAPI;

import java.util.concurrent.CountDownLatch;

/**
 * @Auther: csx
 * @Date: 2022/9/3 21:15
 * @Description:
 */
public class AccumulatorCompareDemo {
    public static final int _1W = 10000;
    public static final int threadNumber = 50;

    public static void main(String[] args) throws InterruptedException {
        ClickNumber clickNumber = new ClickNumber();
        CountDownLatch countDownLatch1 = new CountDownLatch(threadNumber);
        CountDownLatch countDownLatch2 = new CountDownLatch(threadNumber);
        CountDownLatch countDownLatch3 = new CountDownLatch(threadNumber);
        CountDownLatch countDownLatch4 = new CountDownLatch(threadNumber);
        long startTime;
        long endTime;
        startTime = System.currentTimeMillis();
        for (int i = 1; i <= threadNumber; i++) {
            new Thread(()->{
                try {
                    for (int j = 1; j <= 100*_1W; j++) {
                        clickNumber.clickBySynchronized();
                    }
                } finally {
                    countDownLatch1.countDown();
                }
            },String.valueOf(i)).start();
        }
        countDownLatch1.await();
        endTime = System.currentTimeMillis();
        System.out.println("---costTime:"+(endTime-startTime)+"毫秒"+"\t number:"+clickNumber.number);
        startTime = System.currentTimeMillis();
        for (int i = 1; i <= threadNumber; i++) {
            new Thread(()->{
                try {
                    for (int j = 1; j <= 100*_1W; j++) {
                        clickNumber.clickByAtomicLong();
                    }
                } finally {
                    countDownLatch2.countDown();
                }
            },String.valueOf(i)).start();
        }
        countDownLatch2.await();
        endTime = System.currentTimeMillis();
        System.out.println("---costTime:"+(endTime-startTime)+"毫秒"+"\t number:"+clickNumber.atomicLong.get());
        startTime = System.currentTimeMillis();
        for (int i = 1; i <= threadNumber; i++) {
            new Thread(()->{
                try {
                    for (int j = 1; j <= 100*_1W; j++) {
                        clickNumber.clickByLongAdder();

                    }
                } finally {
                    countDownLatch3.countDown();
                }
            },String.valueOf(i)).start();
        }
        countDownLatch3.await();
        endTime = System.currentTimeMillis();
        System.out.println("---costTime:"+(endTime-startTime)+"毫秒"+"\t number:"+clickNumber.longAdder.sum());

        startTime = System.currentTimeMillis();
        for (int i = 1; i <= threadNumber; i++) {
            new Thread(()->{
                try {
                    for (int j = 1; j <= 100*_1W; j++) {
                       clickNumber.clickByLongAccumulator();
                    }
                } finally {
                    countDownLatch4.countDown();
                }
            },String.valueOf(i)).start();
        }
        countDownLatch4.await();
        endTime = System.currentTimeMillis();
        System.out.println("---costTime:"+(endTime-startTime)+"毫秒"+"\t number:"+clickNumber.longAccumulator.get());


    }
}
