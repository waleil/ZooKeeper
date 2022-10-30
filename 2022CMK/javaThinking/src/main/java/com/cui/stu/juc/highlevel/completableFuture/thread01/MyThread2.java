package com.cui.stu.juc.highlevel.completableFuture.thread01;

import java.util.concurrent.Callable;

/**
 * @Auther: csx
 * @Date: 2022/8/30 20:13
 * @Description:
 */
public class MyThread2 implements Callable<String> {
    @Override
    public String call() throws Exception {
        System.out.println("-----come in call()");
        return "hello";
    }
}
