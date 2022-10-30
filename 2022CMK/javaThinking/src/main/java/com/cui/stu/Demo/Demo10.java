package com.cui.stu.Demo;

import java.util.Scanner;
import java.util.TreeSet;

/**
 * @Auther: csx
 * @Date: 2022/6/13 22:21
 * @Description:
 */
public class Demo10 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        TreeSet<String> res = new TreeSet<>();
        String[] sp = in.nextLine().split("");
        String str2 = in.nextLine();
        for (String s:sp){
            if (str2.contains(s)){
                res.add(s);
            }
        }
        for (String re:res){
            System.out.println(re);
        }
        in.close();
    }
}
