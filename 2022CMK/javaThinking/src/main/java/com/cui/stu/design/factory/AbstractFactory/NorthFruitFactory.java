package com.cui.stu.design.factory.AbstractFactory;

/**
 * @Auther: csx
 * @Date: 2022/4/9 11:24
 * @Description:
 */
public class NorthFruitFactory implements FruitFactory2{
    @Override
    public Fruit2 getApple() {
        return new NorthApple();
    }

    @Override
    public Fruit2 getBanana() {
        return new NorthBanana();
    }
}
