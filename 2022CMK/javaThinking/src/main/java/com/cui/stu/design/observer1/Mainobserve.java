package com.cui.stu.design.observer1;

/**
 * @Auther: csx
 * @Date: 2022/4/10 9:45
 * @Description:
 */
public class Mainobserve {
    public static void main(String[] args) {
        OPerson p = new OPerson();
        p.addObserver(new MyObserver());
        p.setName("li");
    }
}
