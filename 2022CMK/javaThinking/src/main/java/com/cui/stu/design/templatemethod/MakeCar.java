package com.cui.stu.design.templatemethod;

/**
 * @Auther: csx
 * @Date: 2022/4/11 6:55
 * @Description:
 */
public abstract class MakeCar {
    public abstract void makeBody();

    public abstract void makeHead();

    public abstract void makeTail();

    public void make(){
        this.makeHead();
        this.makeBody();
        this.makeTail();
    }

}
