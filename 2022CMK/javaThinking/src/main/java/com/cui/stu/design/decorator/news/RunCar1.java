package com.cui.stu.design.decorator.news;

/**
 * @Auther: csx
 * @Date: 2022/4/9 21:08
 * @Description:
 */
public class RunCar1 implements Car1 {
    @Override
    public void show() {
        this.run();
    }
    public void run(){
        System.out.println("可以跑");
    }
}
