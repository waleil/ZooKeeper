package com.huawei.RTTI;

import java.util.Arrays;
import java.util.List;

/**
 * @Auther: csx
 * @Date: 2022/3/26 22:35
 * @Description:
 */
public class Shapes {
    public static void main(String[] args) {
    List<Shape> shapeList = Arrays.asList(new Circle() , new Square() , new Triangle());
        for(Shape shape : shapeList){
            shape.draw();}
}
}
