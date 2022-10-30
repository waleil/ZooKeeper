package com.cui.stu.design.builder;

/**
 * @Auther: csx
 * @Date: 2022/4/9 20:10
 * @Description:
 */
public class PingFangBuilder implements HouseBulider{
    House house = new House();
    @Override
    public void makeFloor() {
        house.setFloor("平房---地板");
    }

    @Override
    public void makeHousetop() {
        house.setHousetop("平房---房顶");
    }

    @Override
    public void makeWall() {
        house.setWall("平房---墙");
    }

    @Override
    public House getHouse() {
        return this.house;
    }
}
