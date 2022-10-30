package com.cui.stu.JVM.ClassLoader;

import sun.util.calendar.LocalGregorianCalendar;

import java.util.Date;

/**
 * @Auther: csx
 * @Date: 2022/6/19 22:36
 * @Description:
 */
public class HeapDemo {
    public static void main(String[] args) {
        System.out.println("start...");
        Date birth = new Date();
        try {
            Thread.sleep(100000);
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("end...");
    }
}
    