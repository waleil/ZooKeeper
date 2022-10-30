package com.huawei.factory;

import com.huawei.factory.sonFactory.Weapon;

/**
 * @Auther: csx
 * @Date: 2022/3/16 21:52
 * @Description:
 */
public class MagicStick extends Weapon {
    @Override
    public void shoot() {
        System.out.println("fire hu hu hu ....");
    }
}
