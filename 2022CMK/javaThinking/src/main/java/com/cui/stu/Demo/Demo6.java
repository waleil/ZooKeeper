package com.cui.stu.Demo;

import java.util.Scanner;

/**
 * @Auther: csx
 * @Date: 2022/6/12 21:53
 * @Description:
 */
public class Demo6 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine().trim());
        int len = Integer.parseInt(in.nextLine().trim());
        String[] sp = in.nextLine().split("\\s+");

        int[] arr = new int[sp.length];
        for (int i = 0; i < sp.length; i++) {
            arr[i] = Integer.parseInt(sp[i]);
        }
        int time =0;
        int more = 0;
        for (int i = 0; i < len; i++) {
            if (arr[i]+more>n){
                more = i+more-n;
            }else {
                more=0;
            }
            time++;
        }
        while (more>0){
            more -=n;
            time++;
        }
        System.out.println(time);
        in.close();
    }
}
