package com.cui.stu.juc.highlevel.completableFuture.thread03;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 *  * 计算结果计算结果
 */
public class CompletableFutureAPI2Demo {
    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(3);
        CompletableFuture.supplyAsync(()->{
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("111");
            return 1;
        },pool).thenApply(f->{
            System.out.println("222");
            return f+2;
        }).thenApply(f->{
            System.out.println("333");
            return f+2;
        }).whenComplete((v,e)->{
            if (e==null){
                System.out.println("---计算结果："+v);
            }
        }).exceptionally(e->{
            e.printStackTrace();
            System.out.println(e.getMessage());
            return null;
        });

        System.out.println(Thread.currentThread().getName()+"-----主线程");



        CompletableFuture.supplyAsync(()->{
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("111");
            return 1;
        },pool).handle((f,e)->{
            System.out.println("222");
            return f+2;
        }).thenApply(f->{
            System.out.println("333");
            return f+2;
        }).whenComplete((v,e)->{
            if (e==null){
                System.out.println("---计算结果："+v);
            }
        }).exceptionally(e->{
            e.printStackTrace();
            System.out.println(e.getMessage());
            return null;
        });
        pool.shutdown();
    }
}
