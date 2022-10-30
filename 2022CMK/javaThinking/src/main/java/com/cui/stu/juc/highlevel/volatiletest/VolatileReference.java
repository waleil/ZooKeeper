package com.cui.stu.juc.highlevel.volatiletest;

/**
 * @Auther: csx
 * @Date: 2022/9/5 21:34
 * @Description:
 */
public class VolatileReference {
    private static class A{
        boolean running = true;
        void m(){
            System.out.println("m start");
            while (running){
                System.out.println("m end!");
            }
        }
    }

    private volatile static A a = new A();

    public static void main(String[] args) {
        new Thread(a::m,"t1").start();
        a.running = false;
    }
}
