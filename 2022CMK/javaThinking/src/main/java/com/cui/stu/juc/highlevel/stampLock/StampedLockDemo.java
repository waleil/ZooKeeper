package com.cui.stu.juc.highlevel.stampLock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.StampedLock;

/**
 * @Auther: csx
 * @Date: 2022/9/4 22:39
 * @Description:
 */
public class StampedLockDemo {
    static int number = 37;
    static StampedLock stampedLock = new StampedLock();
    public void write(){
        long stamp = stampedLock.writeLock();
        System.out.println(Thread.currentThread().getName()+"\t"+"写线程准备修改");

        try {
            number = number + 13;
        } finally {
            stampedLock.unlockWrite(stamp);
        }
        System.out.println(Thread.currentThread().getName()+"\t"+"写线程结束修改");
    }

    public void read(){
        long stamp = stampedLock.readLock();
        System.out.println(Thread.currentThread().getName()+"\t"+"come in 4 seconds ");

        for (int i = 0; i < 4; i++) {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"\t"+"读取中。。。");
        }
        try {
            int result = number;
            System.out.println(Thread.currentThread().getName()+"\t"+"获得成员变量result:"+result);
            System.out.println(Thread.currentThread().getName()+"\t"+"读写互斥");
        } finally {
            stampedLock.unlockRead(stamp);
        }
    }
     public void readHappy(){
        long stamp = stampedLock.tryOptimisticRead();
        int result = number;
        //故意间隔4秒，很乐观认为读取中没有其他线程修改number。
        System.out.println("4秒前stampedLock.validate方法值（true无修改，false有修改）"+"\t"+stampedLock.validate(stamp));

        for (int i = 0; i < 4; i++) {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"\t"+"读取中。。。"+stampedLock.validate(stamp));
        }
        if (!stampedLock.validate(stamp)){
            System.out.println("有修改");
            stamp = stampedLock.readLock();
            try {
                result = number;
                System.out.println(Thread.currentThread().getName()+"\t"+"获得成员变量result:"+result);

            } finally {
                stampedLock.unlockRead(stamp);
            }
        }

         System.out.println(Thread.currentThread().getName()+"\t"+"获得成员变量result:"+result);

    }


    public static void main(String[] args) {
        StampedLockDemo resourse = new StampedLockDemo();

//        new Thread(()->{
//            resourse.read();
//        },"read").start();
//
//        try {
//            TimeUnit.SECONDS.sleep(1);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        new Thread(()->{
//            System.out.println(Thread.currentThread().getName()+"\t"+"------come in");
//            resourse.write();
//        },"write").start();
        new Thread(()->{
            resourse.readHappy();
        },"read").start();

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"\t"+"------come in");
            resourse.write();
        },"write").start();

    }
}
