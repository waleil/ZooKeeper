package com.cui.stu.juc.highlevel.atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Auther: csx
 * @Date: 2022/9/3 9:46
 * @Description:
 */
public class MyNumber {
    AtomicInteger atomicInteger = new AtomicInteger();
    public void addPlus(){
        atomicInteger.getAndIncrement();
    }
}
