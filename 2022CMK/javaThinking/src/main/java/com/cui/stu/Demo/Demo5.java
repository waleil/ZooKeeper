package com.cui.stu.Demo;

import java.util.Scanner;

/**
 * @Auther: csx
 * @Date: 2022/6/12 17:08
 * @Description:
 */
public class Demo5 {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        System.out.println(jump(s.nextInt()));
    }

    public static int jump(int num){
        if(num<3){
            return 1;
        }
        return jump(num-1)+jump(num-3);
    }

}
