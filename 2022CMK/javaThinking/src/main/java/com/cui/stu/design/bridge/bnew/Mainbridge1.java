package com.cui.stu.design.bridge.bnew;

/**
 * @Auther: csx
 * @Date: 2022/4/10 20:36
 * @Description:
 */
public class Mainbridge1 {
    public static void main(String[] args) {
        Engine engine2000 = new Engine2000();
        Engine engine2200 = new Engine2200();

        Carb1 carb1 = new Busb1(engine2000);
        carb1.installEngine();

    }
}
