package com.cui.stu.design.decorator;

/**
 * @Auther: csx
 * @Date: 2022/4/9 21:11
 * @Description:
 */
public class SwimCar implements Car{
    @Override
    public void show() {
        this.run();
        this.swim();
    }

    @Override
    public void run() {
        System.out.println("可以跑");
    }
    public void swim(){
        System.out.println("可以游");
    }
}
