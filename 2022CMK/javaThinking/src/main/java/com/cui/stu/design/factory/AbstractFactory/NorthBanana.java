package com.cui.stu.design.factory.AbstractFactory;

/**
 * @Auther: csx
 * @Date: 2022/4/9 11:20
 * @Description:
 */
public class NorthBanana extends Banana2{
    @Override
    public void get() {
        System.out.println("采集北方苹果");
    }
}
