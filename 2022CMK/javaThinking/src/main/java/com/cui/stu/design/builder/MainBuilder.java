package com.cui.stu.design.builder;

/**
 * @Auther: csx
 * @Date: 2022/4/9 20:04
 * @Description:
 */
public class MainBuilder {
    public static void main(String[] args) {
        //工程队修房子
        HouseBulider hb = new PingFangBuilder();
        HouseDicrector dicrector = new HouseDicrector(hb);
        dicrector.makeHouse();
        House house = hb.getHouse();
        System.out.println(house);
    }
}
