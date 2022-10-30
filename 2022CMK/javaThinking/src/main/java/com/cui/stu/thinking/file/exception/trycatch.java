package com.cui.stu.thinking.file.exception;

/**
 * @Auther: csx
 * @Date: 2022/4/4 21:28
 * @Description:
 */
public class trycatch {
    public static void main(String[] args) {
      int n = val1();
      System.out.println(n);
    }
    public static int val4() {
        int num = 5;
        try {
            num = num / 5;
            return num;
        } catch (Exception e) {
            num = 10;
        } finally {
            num = 15;
        }
        return num;
    }
    public static int val3() {
        int num = 5;
        try {
            num = num / 5;
            return num;
        } catch (Exception e) {
            num = 10;
        } finally {
            num = 15;
        }
        return num;
    }
    public static int val1() {
        int num = 5;
        try {
            num = num / 0;
        } catch (Exception e) {
            num = 10;
            return num;
        } finally {
            num = 15;
        }
        return num;
    }
    public static int val2() {
        int num = 5;
        try {
            num = num / 0;
        } catch (Exception e) {
            num = 10;
            return num;
        } finally {
            num = 15;
        }
        return num;
    }
}
