package com.cui.stu.juc.highlevel.atomic;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**
 * @Auther: csx
 * @Date: 2022/9/3 18:16
 * @Description:
 */
public class BankAccount {
    String bankName = "CCB";
    public volatile int  money = 0;
    public void add(){
        money++;
    }

    AtomicIntegerFieldUpdater<BankAccount> fieldUpdater = AtomicIntegerFieldUpdater.newUpdater(BankAccount.class, "money");
    //不加synchronized 保证高性能原子性，局部微创小手术
    public void transMoney(BankAccount bankAccount){
        fieldUpdater.getAndIncrement(bankAccount);
    }
}
