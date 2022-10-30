package com.cui.stu.thinking.thread.basesic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 * @Auther: csx
 * @Date: 2022/4/19 19:58
 * @Description:
 */
public class ExceptionThread2 implements Runnable{
    @Override
    public void run() {
        Thread t = Thread.currentThread();
        System.out.println("run() by "+t);
        System.out.println(t.getUncaughtExceptionHandler());
        throw new RuntimeException();
    }
}

class MyUncaughtExceptionHander implements Thread.UncaughtExceptionHandler{

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println("caught "+e);
    }
}

class HandlerThreadFactory implements ThreadFactory{

    @Override
    public Thread newThread(Runnable r) {
        System.out.println(this+"  create new Thread");
        Thread t = new Thread(r);
        System.out.println("created "+t);
        t.setUncaughtExceptionHandler(new MyUncaughtExceptionHander());
        System.out.println(t.getUncaughtExceptionHandler());
        return t;
    }
}
class CaptureUncaughtException{
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool(new HandlerThreadFactory());
        exec.execute(new ExceptionThread2());
    }
}