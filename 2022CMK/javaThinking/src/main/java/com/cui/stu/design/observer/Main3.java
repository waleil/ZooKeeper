package com.cui.stu.design.observer;

/**
 * @Auther: csx
 * @Date: 2022/3/27 19:25
 * @Description:
 */
public class Main3 {



    public static void main(String[] args) {
        Child child = new Child();
        child.wakeUp();

    }
}

class Dad{
    public void feed(){
        System.out.println("dad feeding   ...");
    }
}

class Child{
    private boolean cry = false;
    private Dad d = new Dad();

    public boolean isCry(){return cry;}
    public void wakeUp(){
        cry = true;
        d.feed();
    }
}