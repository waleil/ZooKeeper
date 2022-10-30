package com.cui.stu.design.factory.simpfactory;

/**
 * @Auther: csx
 * @Date: 2022/4/9 9:58
 * @Description:
 */
public class FruitFactory {
    public static Fruit getFruit(String type) throws Exception {
        Class fruit = Class.forName(type);
        return (Fruit) fruit.newInstance();
    }
}
