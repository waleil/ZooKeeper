package com.cui.stu.design.observer1;


import lombok.Data;

import java.util.Observable;
import java.util.Observer;

/**
 * @Auther: csx
 * @Date: 2022/4/10 9:40
 * @Description:
 */

public class OPerson extends Observable {
    private String name;

    private int age;

    private  String sex;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        this.setChanged();
        this.notifyObservers();
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
        this.setChanged();
        this.notifyObservers();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
        this.setChanged();
        this.notifyObservers();
    }
}
