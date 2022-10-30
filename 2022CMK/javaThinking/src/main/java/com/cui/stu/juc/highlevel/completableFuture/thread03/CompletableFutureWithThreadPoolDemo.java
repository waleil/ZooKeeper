package com.cui.stu.juc.highlevel.completableFuture.thread03;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 计算结果速度
 */
public class CompletableFutureWithThreadPoolDemo {
    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(5);
        try {
            CompletableFuture<String> palyA = CompletableFuture.supplyAsync(() -> {
                System.out.println("1号任务" + "\t" + Thread.currentThread().getName());
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return "A";
            }, pool);
            CompletableFuture<String> palyB = CompletableFuture.supplyAsync(() -> {
                System.out.println("2号任务" + "\t" + Thread.currentThread().getName());
                return "B";
            }, pool);

            CompletableFuture<String> result = palyA.applyToEither(palyB, f -> {
                return f + " is winer";
            });
            System.out.println(result.join());

            CompletableFuture<String> result2 = palyA.thenCombine(palyB, (x, y) -> {
                System.out.println("----开始合并结果");
                return x + y;
            });
            System.out.println(result2.join());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            pool.shutdown();
        }

    }
}
