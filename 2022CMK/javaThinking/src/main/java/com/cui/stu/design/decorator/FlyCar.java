package com.cui.stu.design.decorator;

/**
 * @Auther: csx
 * @Date: 2022/4/9 21:10
 * @Description:
 */
public class FlyCar implements Car{
    @Override
    public void show() {
        this.fly();
        this.run();
    }
    public void run(){
        System.out.println("可以跑");
    }
    public void fly(){
        System.out.println("可以飞");
    }
}
