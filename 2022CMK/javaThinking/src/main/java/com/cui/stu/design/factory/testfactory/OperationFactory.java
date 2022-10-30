package com.cui.stu.design.factory.testfactory;

/**
 * @Auther: csx
 * @Date: 2022/4/9 16:56
 * @Description:
 */
public interface OperationFactory {
//    public static Operation getOperation(String pre){
//        if ("+".equals(pre)){
//            return new addOperation();
//        }
//        return null;
//    }
     public Operation getOperation();
}
