package com.cui.stu.juc.base;

/**
 * @Auther: csx
 * @Date: 2022/8/28 20:02
 * @Description:
 */
public class ProducerThread extends Thread{
    private Product p;

    public ProducerThread(Product p){
        this.p = p;
    }
    @Override
    public void run(){
        for (int i = 0; i < 10; i++) {
            synchronized (p) {
                if (i%2 == 0){
                    try {
                        p.setBrand("费列罗");
                        Thread.sleep(100);
                        p.setName("巧克力");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }else {
                    try {
                        p.setBrand("哈尔滨");
                        Thread.sleep(100);
                        p.setName("啤酒");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                System.out.println("生产者生产了："+p.getBrand()+"------"+p.getName());
            }
        }
    }
}
