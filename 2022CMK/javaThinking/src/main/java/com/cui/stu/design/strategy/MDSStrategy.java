package com.cui.stu.design.strategy;

/**
 * @Auther: csx
 * @Date: 2022/4/9 22:14
 * @Description:
 */
public class MDSStrategy implements Stategy{
    @Override
    public void encrypt() {
        System.out.println("执行MDS加密");
    }
}
