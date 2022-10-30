package com.cui.stu.design.builder;

/**
 * @Auther: csx
 * @Date: 2022/4/9 20:07
 * @Description:
 */
public interface HouseBulider {
    public void makeFloor();

    public void makeHousetop();

    public void makeWall();

    public House getHouse();
}
