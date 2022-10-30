package com.cui.stu.design.strategy;

/**
 * @Auther: csx
 * @Date: 2022/4/9 22:11
 * @Description:
 */
public class MainStategy {
    public static void main(String[] args) {
//        Stategy stra = new MD5Strategy();
//        stra.encrypt();
        Context context = new Context(new MDSStrategy());
        context.encrypt();
    }
}
