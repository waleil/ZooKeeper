package com.huawei.factory;

import com.huawei.factory.sonFactory.Food;
import com.huawei.factory.sonFactory.Vehicle;
import com.huawei.factory.sonFactory.Weapon;

/**
 * @Auther: csx
 * @Date: 2022/3/16 21:56
 * @Description:
 */
public abstract class AbstractFactory {
    public abstract Vehicle createVehicle();
    public abstract Weapon createWeapon();
    public abstract Food CreateFood();
}
