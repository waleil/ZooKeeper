package com.cui.stu.design.flyweight;

/**
 * @Auther: csx
 * @Date: 2022/4/10 10:21
 * @Description:
 */
public class MyCharacter {
    private char mychar;
    public MyCharacter(char mychar){
        this.mychar = mychar;
    }

    public void display(){
        System.out.println(mychar);
    }
}
