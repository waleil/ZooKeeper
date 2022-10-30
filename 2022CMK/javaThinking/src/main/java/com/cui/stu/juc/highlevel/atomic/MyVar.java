package com.cui.stu.juc.highlevel.atomic;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/**
 * @Auther: csx
 * @Date: 2022/9/3 20:12
 * @Description:
 */
public class MyVar {
    public volatile Boolean isInit = Boolean.FALSE;

    AtomicReferenceFieldUpdater<MyVar,Boolean> referenceFieldUpdater =
            AtomicReferenceFieldUpdater.newUpdater(MyVar.class, Boolean.class, "isInit");
    public void init(MyVar myVar){
        if (referenceFieldUpdater.compareAndSet(myVar, Boolean.FALSE, Boolean.TRUE)) {
            System.out.println(Thread.currentThread().getName()+"   ------start init");
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"   ------over init");
        }else {
            System.out.println(Thread.currentThread().getName()+"   ------已经有线程在进行初始化工作");
        }
    }
}
