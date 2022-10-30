package com.cui.stu.juc.base;

/**
 * @Auther: csx
 * @Date: 2022/8/28 20:09
 * @Description:
 */
public class CustomerThread extends Thread{
    private Product p;
    public CustomerThread(Product p){
        this.p = p;
    }

    @Override
    public void run(){
        for (int i = 0; i < 10; i++) {
            synchronized (p) {
                System.out.println("消费者消费了："+p.getBrand()+"-------"+p.getName());
            }
        }
    }
}
