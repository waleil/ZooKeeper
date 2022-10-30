package com.cui.stu.design.observer;

/**
 * @Auther: csx
 * @Date: 2022/3/27 19:18
 * @Description:
 */
public class Main2 {
    public static void main(String[] args) {
        Child child = new Child();
        while (!child.isCry()){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("observing...");
        }
    }

    static class Child{
    private boolean cry = false;
    private boolean isCry(){
        return cry;
    }
    private void wakeUp(){
        System.out.println("Waked Up ! Crying......");
        cry = true;
    }
    }
}
