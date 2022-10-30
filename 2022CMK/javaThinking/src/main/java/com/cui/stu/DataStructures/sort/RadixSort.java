package com.cui.stu.DataStructures.sort;

import java.util.Arrays;

/**
 * @Auther: csx
 * @Date: 2022/5/11 22:31
 * @Description:
 */
public class RadixSort {
    public static void main(String[] args) {
        int arr[] = { 53, 3, 542, 748, 14, 214};
        radixSort(arr);
        System.out.println("基数排序后 " + Arrays.toString(arr));
    }

    private static void radixSort(int[] arr) {
        int max = arr[0];
        for (int i = 1; i <arr.length ; i++) {
            if (arr[i]>max){
                max = arr[i];
            }
        }
        int[][] bucket = new int[10][arr.length];
        int maxLength = (max + "").length();
        int[] bucketElementCount = new int[10];
        for (int i = 0 ,n = 1; i <maxLength ; i++,n *=10) {
            for (int j = 0; j < arr.length; j++) {
                int digitofElement = arr[j] / n %10;
                bucket[digitofElement][bucketElementCount[digitofElement]] = arr[j];
                bucketElementCount[digitofElement]++;
            }
            int index = 0;
            for (int k= 0;k<bucketElementCount.length;k++){
                if (bucketElementCount[k] !=0){
                    for (int j = 0; j <bucketElementCount[k] ; j++) {
                        arr[index++] = bucket[k][j];
                    }
                }
                bucketElementCount[k]=0;
            }
        }
    }
}
