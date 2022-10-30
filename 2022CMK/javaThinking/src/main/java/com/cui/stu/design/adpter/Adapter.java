package com.cui.stu.design.adpter;

/**
 * @Auther: csx
 * @Date: 2022/4/10 20:43
 * @Description:
 */
public class Adapter extends Current{
    public void user18V(){
        System.out.println("使用适配器");
        this.user220V();
    }
}
