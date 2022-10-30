package com.cui.stu.design.decorator.news;

import com.cui.stu.design.decorator.Car;

/**
 * @Auther: csx
 * @Date: 2022/4/9 21:02
 * @Description:
 */
public class MainDecorator1 {
    public static void main(String[] args) {
        Car1 bus = new RunCar1();
        CarDecorator carDecorator = new FlyCarDecorator(bus);
        carDecorator.show();
    }
}
