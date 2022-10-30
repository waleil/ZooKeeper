package com.cui.stu.juc.base;

/*
 * 线程类交：TestThread
 * 继承Thread类，才具备争抢资源的能力
 */
public class TestThread extends Thread{
    /***
     * 一会线程对象就要开始争抢资源，这个线程要执行的任务到底是啥？这个任务 要放在方法中
     * 这个方法必须是重写Thread类中的run方法。线程的任务/逻辑写在run方法中
     */
    @Override
    public void run(){
      for (int i=1;i<10;i++){
          System.out.println("线程打印"+i);
      }
    }

}