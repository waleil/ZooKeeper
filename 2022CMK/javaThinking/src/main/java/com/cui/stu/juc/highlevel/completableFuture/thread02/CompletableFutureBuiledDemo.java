package com.cui.stu.juc.highlevel.completableFuture.thread02;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @Auther: csx
 * @Date: 2022/8/30 21:08
 * @Description:
 */
public class CompletableFutureBuiledDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(() -> {
//            System.out.println(Thread.currentThread().getName());
//            try {
//                TimeUnit.SECONDS.sleep(1);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        });
//        System.out.println(completableFuture.get());

        CompletableFuture<String> completableFuture2 = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName());
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "hello supplyAsync";
        });
        System.out.println(completableFuture2.get());
    }
}
