package com.cui.stu.thinking.thread.basesic;

/**
 * @Auther: csx
 * @Date: 2022/4/11 22:23
 * @Description:
 */
public class LiftOff implements Runnable {
    protected int CountDown = 10;
    private static int taskCount = 0;
    private final int id = taskCount++;

    public LiftOff() {
    }

    public LiftOff(int countDown) {
        this.CountDown = countDown;
    }
    public String status(){
        return "#"+id+"("+(CountDown>0?CountDown:"Liftoff!")+")";
    }


    @Override
    public void run() {
        while (CountDown-- >0){
            System.out.println(status());
            Thread.yield();
        }
    }
}
