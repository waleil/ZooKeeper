package com.huawei.factory;

import com.huawei.factory.sonFactory.Food;
import org.springframework.http.converter.json.GsonBuilderUtils;

/**
 * @Auther: csx
 * @Date: 2022/3/16 21:38
 * @Description:
 */
public class Apple extends Food {
    public void getName(){
        System.out.println("apple");
    }
}
