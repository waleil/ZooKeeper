package com.huawei.factory;

import com.huawei.factory.sonFactory.Food;
import com.huawei.factory.sonFactory.Vehicle;
import com.huawei.factory.sonFactory.Weapon;

/**
 * @Auther: csx
 * @Date: 2022/3/16 21:42
 * @Description:
 */
public class DefaultFactory extends AbstractFactory{


    @Override
    public Vehicle createVehicle() {
        return new Car();
    }

    @Override
    public Weapon createWeapon() {
        return new AK47();
    }

    @Override
    public Food CreateFood() {
        return new Apple();
    }
}
