package com.cui.stu.juc.highlevel.atomic;

/*
 * 多线程并发调用一个类的初始化方法，如果未被初始化过，将执行初始化工作
 * 要求只能被初始化一次，只能一个线程操作成功
 */
public class AtomicReferenceFieldUpdaterDemo {

    public static void main(String[] args) {
        MyVar myVar = new MyVar();
        for (int i = 1; i <= 5; i++) {
            new Thread(()->{
                myVar.init(myVar);
            }).start();
        }
    }
}
