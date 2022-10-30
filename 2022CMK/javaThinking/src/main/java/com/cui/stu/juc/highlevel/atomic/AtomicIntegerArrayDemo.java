package com.cui.stu.juc.highlevel.atomic;

import java.util.concurrent.atomic.AtomicIntegerArray;

/**
 * @Auther: csx
 * @Date: 2022/9/3 9:57
 * @Description:
 */
public class AtomicIntegerArrayDemo {
    public static void main(String[] args) {
        AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(new int[5]);
        //AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(5);
        //AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(new int[]{1,2,3,4,5});

        for (int i = 0; i < atomicIntegerArray.length(); i++) {
            System.out.println(atomicIntegerArray.get(i));
        }

        System.out.println();

        int tmpInt = 0;
        tmpInt = atomicIntegerArray.getAndSet(0, 1122);
        System.out.println(tmpInt+"\t"+atomicIntegerArray.get(0));

        tmpInt = atomicIntegerArray.getAndIncrement(0);
        System.out.println(tmpInt+"\t"+atomicIntegerArray.get(0));
    }
}
