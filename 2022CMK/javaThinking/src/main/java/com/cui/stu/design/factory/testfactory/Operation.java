package com.cui.stu.design.factory.testfactory;

import lombok.Data;

/**
 * @Auther: csx
 * @Date: 2022/4/9 16:41
 * @Description:
 */
@Data
public abstract class Operation {
    private double num1;
    private double num2;
    public abstract double getResult();
}
