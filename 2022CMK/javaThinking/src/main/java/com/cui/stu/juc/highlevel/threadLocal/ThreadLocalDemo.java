package com.cui.stu.juc.highlevel.threadLocal;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @Auther: csx
 * @Date: 2022/9/4 10:18
 * @Description:
 */
public class ThreadLocalDemo {

    public static void main(String[] args) {
        House house = new House();

        for (int i = 1; i <= 5; i++) {
            new Thread(()->{
               int size = new Random().nextInt(5)+1;
                try {
                    for (int j = 1; j <= size; j++) {
                        house.saleHouse();
                        house.saleVolumeByThreadLocal();
                    }
                    System.out.println(Thread.currentThread().getName()+"\t 号销售卖出："+house.saleVolume.get());
                } finally {
                    house.saleVolume.remove();
                }
            },String.valueOf(i)).start();
        }
        try {
            TimeUnit.MILLISECONDS.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"\t 共计卖出多少套："+house.saleCount);
    }
}
