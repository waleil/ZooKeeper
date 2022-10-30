package com.cui.stu.juc.highlevel.syncup;

import org.openjdk.jol.info.ClassLayout;

/**
 * @Auther: csx
 * @Date: 2022/9/4 18:38
 * @Description:
 */
public class SynchronizedUpDemo {
    public static void main(String[] args) {
        Object o = new Object();
        System.out.println(ClassLayout.parseInstance(o).toPrintable());
    }
}
