package com.stu.com.JVM.outofmemoryerror;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @Auther: csx
 * @Date: 2022/4/24 21:15
 * @Description:
 */
public class DirectMemoryOOM {

    private static final int MB = 1024*1024;
    public static void main(String[] args) throws IllegalAccessException {
        Field unsafeField = Unsafe.class.getDeclaredFields()[0];
        unsafeField.setAccessible(true);
        Unsafe o = (Unsafe)unsafeField.get(null);
        while (true){
            o.allocateMemory(MB);
        }


    }
}
