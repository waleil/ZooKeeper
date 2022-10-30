package com.huawei.RTTI;

/**
 * @Auther: csx
 * @Date: 2022/3/26 22:27
 * @Description:
 */
abstract class Shape {
    void draw() {
        System.out.println(this + ".draw（）");
    }

    public abstract String toStringO();
}

class Circle extends Shape {
    public String toStringO() {
        return "Circle";
    }
}

class Square extends Shape {
    public String toStringO() {
        return "Square";
    }
}

class Triangle extends Shape {
    public String toStringO() {
        return "Triangle";
    }
}
