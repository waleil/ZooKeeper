package com.cui.stu.juc.highlevel.cas.atomic;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @Auther: csx
 * @Date: 2022/9/1 22:58
 * @Description:
 */
public class AtomicReferenceDemo {
    public static void main(String[] args) {
        AtomicReference<User> atomicReference = new AtomicReference<>();
        User u3 = new User("u3", 22);
        User u4 = new User("u4", 28);

        atomicReference.set(u3);

        System.out.println(atomicReference.compareAndSet(u3, u4)+"\t"+atomicReference.get().toString());
        System.out.println(atomicReference.compareAndSet(u3, u4)+"\t"+atomicReference.get().toString());
    }
}
