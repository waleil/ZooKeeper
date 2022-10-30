package com.huawei.strategy;

/**
 * @Auther: csx
 * @Date: 2022/3/9 21:31
 * @Description:
 */
public class Dog implements Comparabl{
    public Dog(int food) {
        this.food = food;
    }

    public int getFood() {
        return food;
    }

    public void setFood(int food) {
        this.food = food;
    }

    private int food;

    @Override
    public int compareto(Object o) {
        Dog d = (Dog)o;
        if(this.food > d.getFood()) return 1;
        else if(this.food < d.getFood()) return -1;
        else return 0;
    }

    @Override
    public String toString() {
        return this.food + "";
    }
}
