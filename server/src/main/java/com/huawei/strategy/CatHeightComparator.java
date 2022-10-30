package com.huawei.strategy;

import org.springframework.stereotype.Component;

/**
 * @Auther: csx
 * @Date: 2022/3/9 21:54
 * @Description:
 */
public class CatHeightComparator implements Comparat {
    @Override
    public int compare(Object o1, Object o2) {
        Cat c1 = (Cat)o1;
        Cat c2 = (Cat)o2;
        if (c1.getHeight()>c2.getHeight()) return 1;
        else if (c1.getHeight()<c2.getHeight()) return -1;
        else return 0;
    }
}
