package com.cui.stu.design.observer1;

import java.util.Observable;
import java.util.Observer;

/**
 * @Auther: csx
 * @Date: 2022/4/10 9:46
 * @Description:
 */
public class MyObserver implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        System.out.println("对象发生变化");
    }
}
