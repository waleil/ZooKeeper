package com.cui.stu.design.strategy;

/**
 * @Auther: csx
 * @Date: 2022/4/9 22:17
 * @Description:
 */
public class Context {
    private Stategy stategy;
    public Context(Stategy stategy){
        this.stategy = stategy;
    }
    public void encrypt(){
        this.stategy.encrypt();
    }
}
