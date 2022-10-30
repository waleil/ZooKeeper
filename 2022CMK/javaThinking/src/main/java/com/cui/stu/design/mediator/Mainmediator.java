package com.cui.stu.design.mediator;

/**
 * @Auther: csx
 * @Date: 2022/4/10 21:45
 * @Description:
 */
public class Mainmediator {
    public static void main(String[] args) {
         Mediator mediator = new Mediator();
         PersonM zhangsan = new Man("张三", 7, mediator);
         PersonM xiaofang = new Women("小芳", 7, mediator);

         zhangsan.getPartner(xiaofang);
    }
}
