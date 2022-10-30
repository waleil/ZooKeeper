package com.cui.stu.juc.highlevel.atomic.longAdderAPI;

import java.util.concurrent.atomic.LongAccumulator;
import java.util.concurrent.atomic.LongAdder;

/**
 * @Auther: csx
 * @Date: 2022/9/3 20:58
 * @Description:
 */
public class LongAdderAPIDemo {
    public static void main(String[] args) {
        LongAdder longAdder = new LongAdder();
        longAdder.increment();
        longAdder.increment();
        longAdder.increment();
        System.out.println(longAdder.sum());

        LongAccumulator longAccumulator = new LongAccumulator((x,y)->x+y,0);

        longAccumulator.accumulate(1);
        longAccumulator.accumulate(3);
        System.out.println(longAccumulator.get());
    }
}
