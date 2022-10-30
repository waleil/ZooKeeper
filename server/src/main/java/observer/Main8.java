package observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: csx
 * @Date: 2022/3/27 21:08
 * @Description:
 */
public class Main8 {
    public static void main(String[] args) {
        Child8 child8 = new Child8();
        child8.wakeUp();
    }
}
class Child8{
    private boolean cry = false;
    private List<Observer8> observers = new ArrayList<>();
    {
        observers.add(new Dad8());
        observers.add(new Mum8() );
        observers.add(new Dog8());
    }

    public boolean isCry() {
        return cry;
    }
    public void wakeUp(){
        cry = true;
        wakeUpEvent8 event = new wakeUpEvent8(System.currentTimeMillis(), "bed",this);
        for (Observer8 o:observers){
            o .actionOnWakeUP(event);
        }
    }
}

abstract class Event<T>{
    abstract T getSource();
}
//事件类，更具fire情况,具体动作
class wakeUpEvent8 extends Event<Child8>{
    long timestamp;
    String loc;
    Child8 source;
    public wakeUpEvent8(long timestamp,String loc,Child8 source){
        this.timestamp= timestamp;
        this.loc= loc;
        this.source = source;
    }

    @Override
    Child8 getSource() {
        return source;
    }
}
interface Observer8{
    void actionOnWakeUP(wakeUpEvent8 event);
}
class Dad8 implements Observer8{

    public void feed(){
        System.out.println("dad feed....");
    }

    @Override
    public void actionOnWakeUP(wakeUpEvent8 event) {
        feed();
    }
}
class Mum8 implements Observer8{
    public void hug() {
        System.out.println("mum hugging.....");
    }

    @Override
    public void actionOnWakeUP(wakeUpEvent8 event) {
        hug();
    }
}

class Dog8 implements Observer8{
    public void wang() {
        System.out.println("dog wang ...");
    }

    @Override
    public void actionOnWakeUP(wakeUpEvent8 event) {
        wang();
    }
}