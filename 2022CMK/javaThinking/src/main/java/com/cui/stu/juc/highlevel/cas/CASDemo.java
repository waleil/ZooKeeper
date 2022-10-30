package com.cui.stu.juc.highlevel.cas;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Auther: csx
 * @Date: 2022/9/1 22:35
 * @Description:
 */
public class CASDemo {
    public static void main(String[] args) {
        AtomicInteger atomicInteger =  new AtomicInteger(5);
        System.out.println(atomicInteger.compareAndSet(5, 2022)+"\t"+atomicInteger.get());
        System.out.println(atomicInteger.compareAndSet(5, 2022)+"\t"+atomicInteger.get());
    }
}
