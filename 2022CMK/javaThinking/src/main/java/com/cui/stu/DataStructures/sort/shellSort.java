package com.cui.stu.DataStructures.sort;

import java.util.Arrays;

/**
 * @Auther: csx
 * @Date: 2022/5/11 20:31
 * @Description:
 */
public class shellSort {
    public static void main(String[] args) {
        int[] arr = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};
        //shellSort1(arr); //交换式
        shellSort2(arr);//移位方式
        System.out.println(Arrays.toString(arr));
    }

    private static void shellSort2(int[] arr) {
        for (int gap = arr.length/2; gap >0 ; gap /=2) {
            for (int i = gap; i <arr.length ; i++) {
                int j = i;
                int temp = arr[j];
                if (arr[j]<arr[j-gap]){
                    while (j-gap>=0 && temp<arr[j-gap]){
                        arr[j] = arr[j-gap];
                        j -=gap;
                    }
                    arr[j] = temp;
                }
            }

        }
    }

    private static void shellSort1(int[] arr) {
        int temp = 0;
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                for (int j = i - gap; j >= 0; j -= gap) {
                    if (arr[j] > arr[j + gap]) {
                        temp = arr[j];
                        arr[j] = arr[j + gap];
                        arr[j + gap] = temp;
                    }
                }
            }

        }
    }

}
