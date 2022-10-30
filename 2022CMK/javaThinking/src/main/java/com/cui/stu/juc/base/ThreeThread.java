package com.cui.stu.juc.base;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ThreadPoolExecutor;

/*
 * 解决前两种问题：
 * 1.没有返回值
 * 2.不能抛出异常
 */
public class ThreeThread implements Callable {
    /*
     1.实现Callable接口，可以不带泛型，如果不带泛型，那么call方式的返回值就是object类型
     2，如果带泛型，那么call的返回值就是泛型对应的类型
     3.从call方法看到：方法的返回值，可以跑出异常
     * */
    @Override
    public Object call() throws Exception {
        return new Random().nextInt(10);
    }
}


class Test{
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ThreeThread td = new ThreeThread();
        FutureTask ft = new FutureTask(td);
        Thread t = new Thread(ft);
        t.start();
        //获取线程得到的返回值
        Object obj = ft.get();
        System.out.println(obj);
    }
}