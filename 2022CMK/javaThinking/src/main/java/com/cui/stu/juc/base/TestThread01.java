package com.cui.stu.juc.base;

/**
 * @Auther: csx
 * @Date: 2022/8/28 11:07
 * @Description:
 */
public class TestThread01 extends Thread{
    @Override
    public void run(){
        for (int i = 0; i <=10; i++) {
            System.out.println(i);
        }
    }
}
class TestThread02 extends Thread{
    @Override
    public void run(){
        for (int i = 11; i <=20; i++) {
            System.out.println(i);
        }
    }
}

class Test01{
    public static void main(String[] args) {
        TestThread01 t1 = new TestThread01();
        TestThread02 t2 = new TestThread02();
        t1.start();
        t2.start();

    }
}
