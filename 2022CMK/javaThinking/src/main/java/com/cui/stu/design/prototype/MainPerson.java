package com.cui.stu.design.prototype;

/**
 * @Auther: csx
 * @Date: 2022/4/9 17:25
 * @Description:
 */
public class MainPerson {
    public static void main(String[] args) {
        person p = new person();
        p.setAge(30);
        p.setName("li");
        p.setSex("男");

        person p1 = p.clone();
        System.out.println(p1);

        p.setName("zhang");
        System.out.println(p1.getName());
        System.out.println(p);
    }
}
