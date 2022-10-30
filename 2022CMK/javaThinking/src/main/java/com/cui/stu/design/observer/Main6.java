package com.cui.stu.design.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: csx
 * @Date: 2022/3/27 20:42
 * @Description:
 */
public class Main6 {
}

class Child6{
    private boolean cry = false;
    private List<Observer6> observers = new ArrayList<Observer6>();
    {
        observers.add(new Dad6());
        observers.add(new Mum6() );
        observers.add(new Dog6());
    }

    public boolean isCry() {
        return cry;
    }
    public void wakeUp(){
        cry = true;
        wakeUpEvent event = new wakeUpEvent(System.currentTimeMillis(), "bed");
        for (Observer6 o:observers){
            o .actionOnWakeUP(event);
        }
    }
}

//事件类，更具fire情况,具体动作
class wakeUpEvent{
    long timestamp;
    String loc;
    public wakeUpEvent(long timestamp,String loc){
        this.timestamp= timestamp;
        this.loc= loc;
    }
}

interface Observer6{
    void actionOnWakeUP(wakeUpEvent event);
}

class Dad6 implements Observer6{

    public void feed(){
        System.out.println("dad feed....");
    }

    @Override
    public void actionOnWakeUP(wakeUpEvent event) {
        feed();
    }
}

class Mum6 implements Observer6{
    public void hug() {
        System.out.println("mum hugging.....");
    }

    @Override
    public void actionOnWakeUP(wakeUpEvent event) {
        hug();
    }
}

class Dog6 implements Observer6{
    public void wang() {
        System.out.println("dog wang ...");
    }

    @Override
    public void actionOnWakeUP(wakeUpEvent event) {
        wang();
    }
}