package com.cui.stu.design.factory.AbstractFactory;

/**
 * @Auther: csx
 * @Date: 2022/4/9 11:08
 * @Description:
 */
public class NorthApple extends Apple2{
    @Override
    public void get() {
        System.out.println("采集北方苹果");
    }
}
