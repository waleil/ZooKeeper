package com.stu.design.signleton;

/**
 * @Auther: csx
 * @Date: 2022/3/20 10:34
 * @Description:
 */
public class mgr02 {
    public static final mgr02 INSTANCE;

    static {
        INSTANCE = new mgr02();
    }
    private mgr02(){}

    public static mgr02 getInstance(){
        return INSTANCE;
    }
}
