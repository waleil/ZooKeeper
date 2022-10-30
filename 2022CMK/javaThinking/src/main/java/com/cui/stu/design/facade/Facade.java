package com.cui.stu.design.facade;

/**
 * @Auther: csx
 * @Date: 2022/4/10 11:16
 * @Description:
 */
public class Facade {
    private SystemA systemA;
    private SystemB systemB;

    public Facade(){
        systemA = new SystemA();
        systemB = new SystemB();
    }
    public void doSomething(){
        this.systemA.doSomething();
        this.systemB.doSomething();
    }
}
