package com.cui.stu.design.factory.AbstractFactory;

import com.cui.stu.design.factory.simpfactory.FruitFactory;

/**
 * @Auther: csx
 * @Date: 2022/4/9 11:28
 * @Description:
 */
public class MainClass2 {
    public static void main(String[] args) {
        FruitFactory2 f = new NorthFruitFactory();
        Fruit2 apple = f.getApple();
        Fruit2 banana = f.getBanana();

        apple.get();
        banana.get();

        FruitFactory2 f2 = new SouthFruitFactory();

    }
}
