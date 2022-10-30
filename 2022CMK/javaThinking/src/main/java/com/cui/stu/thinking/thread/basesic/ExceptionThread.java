package com.cui.stu.thinking.thread.basesic;

import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Auther: csx
 * @Date: 2022/4/19 19:54
 * @Description:
 */
public class ExceptionThread implements Runnable{

    @Override
    public void run() {
        throw new RuntimeException();
    }

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new ExceptionThread());
    }
}


