package com.cui.stu.design.decorator.news;

/**
 * @Auther: csx
 * @Date: 2022/4/9 21:24
 * @Description:
 */
public class FlyCarDecorator extends CarDecorator{
    public FlyCarDecorator(Car1 car) {
        super(car);
    }

    @Override
    public void show() {
        this.getCar().show();
        this.fly();
    }

    public void fly(){
        System.out.println("可以飞");
    }
}
