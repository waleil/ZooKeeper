package com.cui.stu.juc.highlevel.cas.stamped;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @Auther: csx
 * @Date: 2022/9/1 23:33
 * @Description:
 */
public class ABADemo {
    static AtomicInteger atomicInteger = new AtomicInteger(100);
    static AtomicStampedReference stampedReference = new AtomicStampedReference(100,1);

    public static void main(String[] args) {

    }
}
