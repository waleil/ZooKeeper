package com.cui.stu.design.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: csx
 * 很多时候，观察者需要根据事件的具体情况来处理大多数时候，我们处理事情
 * 的时候，需要事件源对象
 */
public class Main7 {
}

class Child7{
    private boolean cry = false;
    private List<Observer7> observers = new ArrayList<Observer7>();
    {
        observers.add(new Dad7());
        observers.add(new Mum7() );
        observers.add(new Dog7());
    }

    public boolean isCry() {
        return cry;
    }
    public void wakeUp(){
        cry = true;
        wakeUpEvent7 event = new wakeUpEvent7(System.currentTimeMillis(), "bed",this);
        for (Observer7 o:observers){
            o .actionOnWakeUP(event);
        }
    }
}

//事件类，更具fire情况,具体动作
class wakeUpEvent7{
    long timestamp;
    String loc;
    Child7 source;
    public wakeUpEvent7(long timestamp,String loc,Child7 source){
        this.timestamp= timestamp;
        this.loc= loc;
        this.source = source;
    }
}

interface Observer7{
    void actionOnWakeUP(wakeUpEvent7 event);
}

class Dad7 implements Observer7{

    public void feed(){
        System.out.println("dad feed....");
    }

    @Override
    public void actionOnWakeUP(wakeUpEvent7 event) {
        feed();
    }
}

class Mum7 implements Observer7{
    public void hug() {
        System.out.println("mum hugging.....");
    }

    @Override
    public void actionOnWakeUP(wakeUpEvent7 event) {
        hug();
    }
}

class Dog7 implements Observer7{
    public void wang() {
        System.out.println("dog wang ...");
    }

    @Override
    public void actionOnWakeUP(wakeUpEvent7 event) {
        wang();
    }
}