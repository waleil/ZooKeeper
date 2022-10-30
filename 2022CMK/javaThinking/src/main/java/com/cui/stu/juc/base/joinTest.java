package com.cui.stu.juc.base;

/**
 * @Auther: csx
 * @Date: 2022/8/28 11:19
 * @Description:
 */
public class joinTest extends Thread{

    @Override
    public void run(){
        for (int i = 1; i < 10; i++) {
            System.out.println(this.getName()+"-----"+i);
        }
    }
}
class TestJoin{
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            if (i==6){
                joinTest t = new joinTest();
                t.start();
                t.join();
            }
            System.out.println("main------"+i);
        }
    }
}
