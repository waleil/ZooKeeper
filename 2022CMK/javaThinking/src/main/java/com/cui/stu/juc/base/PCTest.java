package com.cui.stu.juc.base;

/**
 * @Auther: csx
 * @Date: 2022/8/28 20:12
 * @Description:
 */
public class PCTest {
    public static void main(String[] args) {
        Product p = new Product();
        ProducerThread pt = new ProducerThread(p);
        CustomerThread ct = new CustomerThread(p);
        pt.start();
        ct.start();

    }
}
