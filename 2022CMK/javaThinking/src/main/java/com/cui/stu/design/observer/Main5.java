package com.cui.stu.design.observer;

import java.util.ArrayList;
import java.util.List;


/**
 * @Auther: csx
 * @Date: 2022/3/27 19:41
 * @Description:
 */
public class Main5 {
    public static void main(String[] args) {
        Child5 child5 = new Child5();
        child5.wakeUp();
    }
}

class Child5{
    private boolean cry = false;
    private List<Observer> observers = new ArrayList<Observer>();
    {
        observers.add(new Dad5());
        observers.add(new Mum5() );
        observers.add(new Dog5());
    }

    public boolean isCry() {
        return cry;
    }
    public void wakeUp(){
        cry = true;
        for (Observer o:observers){
            o.actionOnWakeUP();
        }
    }
}

interface Observer{
    void actionOnWakeUP();
}

class Dad5 implements Observer{

    public void feed(){
        System.out.println("dad feed....");
    }

    @Override
    public void actionOnWakeUP() {
         feed();
    }
}

class Mum5 implements Observer{
    public void hug() {
        System.out.println("mum hugging.....");
    }

    @Override
    public void actionOnWakeUP() {
         hug();
    }
}

class Dog5 implements Observer{
    public void wang() {
        System.out.println("dog wang ...");
    }

    @Override
    public void actionOnWakeUP() {
        wang();
    }
}