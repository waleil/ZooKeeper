package com.cui.stu.JVM.ClassLoader.test;

/**
 * @Auther: csx
 * @Date: 2022/6/11 10:48
 * @Description:
 */
public class test {
    public static void main(String[] args) {
        test t = new test();
        int i = 10;
        int j = 20;
        t.test1(i,j);
    }

    private void test1(int i, int j) {
        int k = i+j;
    }
}
