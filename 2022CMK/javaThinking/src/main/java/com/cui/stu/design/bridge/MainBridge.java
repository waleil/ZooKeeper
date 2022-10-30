package com.cui.stu.design.bridge;

/**
 * @Auther: csx
 * @Date: 2022/4/10 20:02
 * @Description:
 */
public class MainBridge {
    public static void main(String[] args) {
        Carb carb = new Bus2000();
        carb.installEngine();
    }
}
