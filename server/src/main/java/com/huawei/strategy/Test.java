package com.huawei.strategy;



/**
 * @Auther: csx
 * @Date: 2022/3/9 20:59
 * @Description:
 */
public class Test {
    public static void main(String[] args) {
        //int[] a = {9,5,3,7,1};


       Cat[] a = {new Cat(5,5),new Cat(3,3),new Cat(1,1)};
       // Dog[] a = {new Dog(5), new Dog(3), new Dog(1)};
        DataSource.sot(a);
        DataSource.P(a);
    }
}
