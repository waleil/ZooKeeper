package com.cui.stu.Demo;

import java.util.Scanner;

/**
 * @Auther: csx
 * @Date: 2022/6/12 12:22
 * @Description:
 */
public class Demo3 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = Integer.parseInt(s.nextLine());
        int sum = 0;
        for (int i = 0; i < n; i++) {
            String[] arr = s.nextLine().split("\\s+");
            for (int j = 0; j < arr.length; j++) {
                sum += Integer.parseInt(arr[j]);
            }
        }
        System.out.println(sum);
        s.close();
    }
}
