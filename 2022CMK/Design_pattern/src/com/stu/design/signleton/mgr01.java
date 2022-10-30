package com.stu.design.signleton;

/**
 * 饿汉式
 *
 * 类加载到内存后，就实力化一个单例，static是在类loader到内存时就开始初始化，也保证只new一次
 */
public class mgr01 {
    public static final mgr01 INSTANCE= new mgr01();

    private mgr01(){}

    public static mgr01 getInstance(){
        return INSTANCE;
    }
}
