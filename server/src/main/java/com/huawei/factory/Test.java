package com.huawei.factory;

import com.huawei.factory.sonFactory.Food;
import com.huawei.factory.sonFactory.Vehicle;
import com.huawei.factory.sonFactory.Weapon;

/**
 * @Auther: csx
 * @Date: 2022/3/16 21:40
 * @Description:
 */
public class Test {
    public static void main(String[] args) {
       // DefaultFactory f = new DefaultFactory();
        AbstractFactory f = new DefaultFactory();
        Vehicle v = f.createVehicle();
        Weapon a = f.createWeapon();
        a.shoot();
        Food ap = f.CreateFood();
        ap.getName();
    }
}
