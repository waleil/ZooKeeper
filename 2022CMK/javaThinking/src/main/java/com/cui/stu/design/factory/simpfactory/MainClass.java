package com.cui.stu.design.factory.simpfactory;

/**
 * @Auther: csx
 * @Date: 2022/4/9 10:02
 * @Description:
 */
public class MainClass {
    public static void main(String[] args) throws Exception {
        Fruit apple = FruitFactory.getFruit("com.cui.stu.design.factory.simpfactory.Apple");
        Fruit banana = FruitFactory.getFruit("com.cui.stu.design.factory.simpfactory.Banana");
        apple.get();
        banana.get();
    }
}
