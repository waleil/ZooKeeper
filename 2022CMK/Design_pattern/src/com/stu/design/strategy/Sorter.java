package com.stu.design.strategy;

/**
 * @Auther: csx
 * @Date: 2022/3/20 18:40
 * @Description:
 */
public class Sorter {

    public void sort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length - i; j++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
    }
}
