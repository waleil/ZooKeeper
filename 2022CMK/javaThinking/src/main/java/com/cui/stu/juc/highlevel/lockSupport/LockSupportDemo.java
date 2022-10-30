package com.cui.stu.juc.highlevel.lockSupport;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Auther: csx
 * @Date: 2022/8/31 22:48
 * @Description:
 */
public class LockSupportDemo {
    public static void main(String[] args) {
       // waitandnotify();
        //awaitandsignal();
        parkandunpark();
    }

    private static void parkandunpark() {

        Thread t1 = new Thread(() -> {

            try {
                System.out.println(Thread.currentThread().getName() + "\t ------come in");
                LockSupport.park();
                System.out.println(Thread.currentThread().getName() + "\t ------被唤醒");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "t1");
        t1.start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(()->{

            try {
                LockSupport.unpark(t1);
                System.out.println(Thread.currentThread().getName()+"\t ------发出通知");
            } catch (Exception e) {
                e.printStackTrace();
            }

        },"t2").start();
    }
     private static void awaitandsignal() {
        Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        new Thread(()->{
            lock.lock();
                try {
                    System.out.println(Thread.currentThread().getName()+"\t ------come in");
                    condition.await();
                    System.out.println(Thread.currentThread().getName()+"\t ------被唤醒");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    lock.unlock();
                }

        },"t1").start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(()->{
           lock.lock();
            try {
                condition.signal();
                System.out.println(Thread.currentThread().getName()+"\t ------发出通知");
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }

        },"t2").start();
    }

    private static void waitandnotify() {
        Object objectLock = new Object();
        new Thread(()->{
            synchronized (objectLock){
                System.out.println(Thread.currentThread().getName()+"\t ------come in");
                try {
                    objectLock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"\t ------被唤醒");
            }
        },"t1").start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(()->{
            synchronized (objectLock) {
                objectLock.notify();
                System.out.println(Thread.currentThread().getName()+"\t ------发出通知");
            }
        },"t2").start();
    }


}
