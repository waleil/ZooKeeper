package com.cui.stu.juc.highlevel.atomic;

import java.util.concurrent.CountDownLatch;

/*
 * 以一种线程安全的方式操作非线程安全对象的某些字段
 */
public class AtomicIntergerFiledUpdaterDemo {
    public static void main(String[] args) throws InterruptedException {
        BankAccount bankAccount = new BankAccount();
        CountDownLatch countDownLatch = new CountDownLatch(10);

        for (int i = 1; i <= 10; i++) {
            new Thread(()->{
                try {
                    for (int j = 1; j <= 1000; j++) {
                        bankAccount.transMoney(bankAccount);
                    }
                } finally {
                    countDownLatch.countDown();
                }
            }).start();
        }
        countDownLatch.await();

        System.out.println(Thread.currentThread().getName()+"\t  result:"+bankAccount.money);

    }
}
