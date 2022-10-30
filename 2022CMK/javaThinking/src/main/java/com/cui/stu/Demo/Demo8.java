package com.cui.stu.Demo;

import java.util.Scanner;

/**
 * @Auther: csx
 * @Date: 2022/6/13 21:45
 * @Description:
 */
public class Demo8 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] sp = in.nextLine().split("\\s+");
        int n = Integer.parseInt(in.nextLine());
        int end = Integer.parseInt(in.nextLine());
        int m = 0;
        if (end>sp.length){
            m = sp.length-1;
        }else {
            m=end;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = sp.length-1; i >=n ; i--) {
           sb.append(sp[i]).append(" ");
        }
        System.out.println(sb.toString().trim());
    }
}
