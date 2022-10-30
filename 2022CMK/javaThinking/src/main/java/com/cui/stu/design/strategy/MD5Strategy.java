package com.cui.stu.design.strategy;

/**
 * @Auther: csx
 * @Date: 2022/4/9 22:12
 * @Description:
 */
public class MD5Strategy implements Stategy{
    @Override
    public void encrypt() {
        System.out.println("执行MD5加密");
    }
}
