package com.student.count.thread_yzy;

/**
 * @Auther: csx
 * @Date: 2021/10/27 21:36
 * @Description:
 */
public class Test1 implements Runnable{

    @Override
    public synchronized void run() {
        while (true) {
            System.out.println("线程运行了。。。");
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Test1 test1 = new Test1();
        Thread thread = new Thread(test1);
        thread.start();
        while (true) {
            synchronized (test1) {
                System.out.println("主线程运行了。。。");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                test1.notifyAll();
            }
        }
    }
}
