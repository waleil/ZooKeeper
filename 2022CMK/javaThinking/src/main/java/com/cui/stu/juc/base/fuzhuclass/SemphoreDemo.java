package com.cui.stu.juc.base.fuzhuclass;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/*
 * 信号灯
 */
public class SemphoreDemo {
    public static void main(String[] args) {
        //创建semphore，设置许可数量
        Semaphore semaphore = new Semaphore(3);
        for (int i = 1; i <= 6; i++) {
            new Thread(()->{
            try {
                //抢占车位
                semaphore.acquire();
                System.out.println(Thread.currentThread().getName()+"抢到了车位");

                //设置随机停车时间
                TimeUnit.SECONDS.sleep(new Random().nextInt(5));

                System.out.println(Thread.currentThread().getName()+"----离开了车位");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                //释放车位
                semaphore.release();
            }},String.valueOf(i)).start();
        }
    }
}
