package com.cui.stu.JVM.ClassLoader;

/**
 * @Auther: csx
 * @Date: 2022/6/19 22:38
 * @Description:
 */
public class HeapDemo1 {
    public static void main(String[] args) {
        System.out.println("start...");
        try {
            Thread.sleep(100000);
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("end...");
    }
}
