package com.huawei.factory;

import com.huawei.factory.sonFactory.Food;
import com.huawei.factory.sonFactory.Vehicle;
import com.huawei.factory.sonFactory.Weapon;

/**
 * @Auther: csx
 * @Date: 2022/3/16 21:46
 * @Description:
 */
public class MagicFactory extends AbstractFactory{


    @Override
    public Vehicle createVehicle() {
        return new Broom();
    }

    @Override
    public Weapon createWeapon() {
        return new MagicStick();
    }

    @Override
    public Food CreateFood() {
        return new MushRoom();
    }
}
