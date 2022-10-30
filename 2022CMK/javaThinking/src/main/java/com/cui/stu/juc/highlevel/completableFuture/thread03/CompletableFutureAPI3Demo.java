package com.cui.stu.juc.highlevel.completableFuture.thread03;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * 1.thenRun   任务A执行完执行任务B,任务B执行不需要任务A的结果。
 * 2.thenApply  任务A执行完执行任务B，任务B需要任务A的执行结果，且任务B执行完有返回值
 * 3.thenAccept  任务A执行完执行任务B，任务B执行需要任务A的执行结果，但B执行完没有返回值
 */
public class CompletableFutureAPI3Demo {
    public static void main(String[] args) {
        CompletableFuture.supplyAsync(()->{
            System.out.println("111");
            return 1;
        }).handle((f,e)->{
            System.out.println("222");
            return f+2;
        }).thenApply(f->{
            System.out.println("333");
            return f+2;
        }).thenAccept(r->{
            System.out.println(r);
        });
    }
}
