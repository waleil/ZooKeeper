package com.cui.stu.Demo;

import java.util.Scanner;
import java.util.TreeSet;

/**
 * @Auther: csx
 * @Date: 2022/6/13 22:11
 * @Description:
 */
public class Demo9 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] sp = in.nextLine().split("\\s+");
        int r = Integer.parseInt(in.nextLine());
        int[] M = new int[sp.length];
        for (int i = 0; i < sp.length; i++) {
            M[i] = Integer.parseInt(sp[i]);
        }
        TreeSet<Integer> treeSet=new TreeSet<>();
        for (int i = 0; i < M.length; i++) {
            for (int j = i+1; j <M.length ; j++) {
                for (int k = j+1; k < M.length; k++) {
                    int sum = M[i]+M[j]+M[k];
                    if (sum<=r){
                        treeSet.add(sum);
                    }
                }
            }

        }
        if (treeSet.size()==0){
            System.out.println(-1);
        }else {
            System.out.println(treeSet.last());
        }
        in.close();
    }
}
