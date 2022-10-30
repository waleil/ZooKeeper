package com.cui.stu.design.factory.AbstractFactory;

/**
 * @Auther: csx
 * @Date: 2022/4/9 11:25
 * @Description:
 */
public class SouthFruitFactory implements FruitFactory2{
    @Override
    public Fruit2 getApple() {
        return new SouthApple();
    }

    @Override
    public Fruit2 getBanana() {
        return new SouthBanana();
    }
}
