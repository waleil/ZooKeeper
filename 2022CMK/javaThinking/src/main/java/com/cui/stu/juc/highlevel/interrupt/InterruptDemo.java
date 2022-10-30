package com.cui.stu.juc.highlevel.interrupt;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @Auther: csx
 * @Date: 2022/8/31 21:10
 * @Description:
 */
public class InterruptDemo {
    private static volatile boolean isStop = false;

    private static AtomicBoolean atomicBoolean = new AtomicBoolean(false);
    public static void main(String[] args) {
        //m1();
        //m2();
        m3();
    }
    private static void m3(){
        Thread t1 = new Thread(() -> {
            while (true) {
                if (Thread.currentThread().isInterrupted()) {
                    System.out.println(Thread.currentThread().getName() + "\t isInterrupted(),程序停止");
                    break;
                }
                System.out.println("t1 -----hello interrupt API");
            }
        }, "t1");
        t1.start();

        try {
            TimeUnit.MILLISECONDS.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(()->{
            t1.interrupt();
        },"t2").start();
    }
     private static void m2(){
        new Thread(()->{
            while (true){
                if (atomicBoolean.get()){
                    System.out.println(Thread.currentThread().getName()+"\t atomicBoolean被修改为true,程序停止");
                    break;
                }
                System.out.println("t1 -----hello atomicBoolean");
            }
        },"t1").start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(()->{
            atomicBoolean.set(true);
        },"t2").start();
    }

    private static void m1() {
        new Thread(()->{
            while (true){
                if (isStop){
                    System.out.println(Thread.currentThread().getName()+"\t isStop被修改为true,程序停止");
                    break;
                }
                System.out.println("t1 -----hello volatile");
            }
        },"t1").start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(()->{
            isStop = true;
        },"t2").start();
    }
}
