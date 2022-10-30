package com.cui.stu.design.factory.testfactory;

/**
 * @Auther: csx
 * @Date: 2022/4/9 17:07
 * @Description:
 */
public class addOperationFactory implements OperationFactory{
    @Override
    public Operation getOperation() {
        return new addOperation();
    }
}
