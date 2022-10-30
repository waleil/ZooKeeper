package com.cui.stu.design.prototype;

import lombok.Data;

/**
 * @Auther: csx
 * @Date: 2022/4/9 17:23
 * @Description:
 */
@Data
public class person implements Cloneable{
    private String name;

    private int age;

    private  String sex;

    public person clone(){
        try {
            return (person) super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }
}
