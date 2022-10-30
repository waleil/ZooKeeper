package com.cui.stu.juc.highlevel.completableFuture.thread01;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Auther: csx
 * @Date: 2022/8/30 20:11
 * @Description:
 */
public class FutureDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<String> futureTask = new FutureTask<>(new MyThread2());
        Thread t1 = new Thread(futureTask,"t1");
        t1.start();
        System.out.println(futureTask.get());
    }
}
