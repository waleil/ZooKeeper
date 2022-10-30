package com.cui.stu.design.builder;

import lombok.AllArgsConstructor;

/**
 * @Auther: csx
 * @Date: 2022/4/9 20:31
 * @Description:
 */
@AllArgsConstructor
public class HouseDicrector {
    private HouseBulider houseBulider;
    public void makeHouse(){
        houseBulider.makeWall();
        houseBulider.makeHousetop();
        houseBulider.makeFloor();
    }
}
