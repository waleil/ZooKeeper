package com.cui.stu.thinking.file;

/**
 * @Auther: csx
 * @Date: 2022/3/30 8:00
 * @Description:
 */
public class Test {
    public static void main(String args[]) {
        String Str = new String("CreateJwt.java");

        System.out.print("返回值 :" );
        System.out.println(Str.matches("(.*)java"));

        System.out.print("返回值 :" );
        System.out.println(Str.matches("(.*)google(.*)"));

        System.out.print("返回值 :" );
        System.out.println(Str.matches("www(.*)"));
    }
}
