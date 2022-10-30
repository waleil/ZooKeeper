package com.cui.stu.juc.highlevel.atomic.longAdderAPI;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAccumulator;
import java.util.concurrent.atomic.LongAdder;

/**
 * @Auther: csx
 * @Date: 2022/9/3 21:08
 * @Description:
 */
public class ClickNumber {
    int number = 0;
    public synchronized void clickBySynchronized(){
        number++;
    }

    AtomicLong atomicLong = new AtomicLong(0);
    public void clickByAtomicLong(){
        atomicLong.getAndIncrement();
    }

    LongAdder longAdder = new LongAdder();
    public void clickByLongAdder(){
        longAdder.increment();
    }

    LongAccumulator longAccumulator = new LongAccumulator((x,y)->x+y,0);

    public void  clickByLongAccumulator(){
        longAccumulator.accumulate(1);
    }
}
