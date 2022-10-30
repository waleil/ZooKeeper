package com.cui.stu.juc.highlevel.completableFuture.thread02;

import java.util.concurrent.*;

/**
 * @Auther: csx
 * @Date: 2022/8/30 21:17
 * @Description:
 */
public class CompletableFutureUseDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService pool = Executors.newFixedThreadPool(3);
        try {
            CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(() -> {
                System.out.println(Thread.currentThread().getName());
                int result = ThreadLocalRandom.current().nextInt(10);
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return result;
            },pool).whenComplete((v,e)->{
                if (e == null){
                    System.out.println("=====计算完成:"+v);
                }
            }).exceptionally(e->{
                System.out.println(e.getMessage());
                return null;
            });
        } finally {
            pool.shutdown();
        }

        System.out.println(Thread.currentThread().getName()+"线程先去忙其他任务");
       // System.out.println(completableFuture.get());
    }
}
