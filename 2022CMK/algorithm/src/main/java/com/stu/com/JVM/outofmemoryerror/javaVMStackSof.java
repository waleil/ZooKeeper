package com.stu.com.JVM.outofmemoryerror;

/**
 * @Auther: csx
 * @Date: 2022/4/24 20:24
 * @Description:
 */
public class javaVMStackSof {
    private int stackLeng = 1;
    public void stackLeak(){
        stackLeng ++;
        stackLeak();
    }

    public static void main(String[] args) {
        javaVMStackSof oom = new javaVMStackSof();
        try {
            oom.stackLeak();
        }catch (Throwable e){
            System.out.println(oom.stackLeng);
            throw e;
        }

    }
}
