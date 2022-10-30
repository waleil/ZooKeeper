package com.cui.stu.design.decorator;

/**
 * @Auther: csx
 * @Date: 2022/4/9 21:02
 * @Description:
 */
public class MainDecorator {
    public static void main(String[] args) {
        Car bus = new RunCar();
        bus.show();
    }
}
