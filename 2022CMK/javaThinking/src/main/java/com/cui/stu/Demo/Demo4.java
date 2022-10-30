package com.cui.stu.Demo;

import java.util.Scanner;

/**
 * @Auther: csx
 * @Date: 2022/6/12 16:50
 * @Description:
 */
public class Demo4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String tag = in.nextLine();
        String data = in.nextLine();
        String[] split = data.split("\\s+");

        for (int i = 0 ;i<split.length;){
            int length = Integer.parseInt(split[i+2]+split[i+2],16);
            if (tag.equals(split[i])){
                StringBuilder builder = new StringBuilder();
                for (int j = i+3; j < i+3+length; j++) {
                    builder.append(split[i]).append(" ");
                }
                System.out.println(builder.toString());
                break;
            }else {
                i=length+3;
            }
        }
        in.close();
    }
}
