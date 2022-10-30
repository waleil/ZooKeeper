package com.cui.stu.design.factory.testfactory;

import com.cui.stu.design.factory.testfactory.Operation;

/**
 * @Auther: csx
 * @Date: 2022/4/9 16:43
 * @Description:
 */
public class addOperation extends Operation {
    @Override
    public double getResult() {
        return this.getNum1()+this.getNum2();
    }
}
