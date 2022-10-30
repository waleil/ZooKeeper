package com.cui.stu.design.decorator.news;

import com.cui.stu.design.decorator.Car;
import lombok.Data;

/**
 * @Auther: csx
 * @Date: 2022/4/9 21:22
 * @Description:
 */
@Data
public abstract class CarDecorator {
    private Car1 car;
    public CarDecorator(Car1 car){
        this.car=car;
    }
    public abstract void show();
}
