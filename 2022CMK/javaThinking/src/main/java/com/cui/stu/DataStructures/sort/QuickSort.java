package com.cui.stu.DataStructures.sort;

import java.util.Arrays;

/**
 * @Auther: csx
 * @Date: 2022/5/11 21:17
 * @Description:
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {-9,78,-567,0,23,70,900, 4561};
        quickSort(arr, 0, arr.length-1);
        System.out.println("arr=" + Arrays.toString(arr));
    }

    private static void quickSort(int[] arr, int left, int right) {
        int l = left;
        int r = right;
        int pivot = arr[(left+right)/2];
        int temp = 0;
        while (l<r){
            while (arr[l] < pivot){
                l +=1;
            }
            while (arr[r]>pivot){
                r -=1;
            }
            if (l>=r){
                break;
            }
            temp = arr[l];
            arr[l]= arr[r];
            arr[r] = temp;

            if (arr[l] == pivot){
                r--;
            }

            if (arr[r] == pivot){
                l++;
            }
        }
        if (l==r){
            l++;
            r--;
        }
        if (left<r){
            quickSort(arr, left, r);
        }
        if (right>l){
            quickSort(arr, l, right);
        }
    }
}
