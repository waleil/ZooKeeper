package com.cui.stu.design.factory.testfactory;

import java.util.Scanner;

/**
 * @Auther: csx
 * @Date: 2022/4/9 11:45
 * @Description:
 */
public class MainFactory {
    public static void main(String[] args) {
        System.out.println("---计算机程序---");
        System.out.println("输入第一个操作数");
        Scanner scanner = new Scanner(System.in);
        String strNum1 = scanner.nextLine();

        System.out.println("输入运算符");
        String oper = scanner.nextLine();
        System.out.println("输入第二个操作数");
        String strNum2 = scanner.nextLine();
        double result = 0;
        double num1 = Double.parseDouble(strNum1);
        double num2 = Double.parseDouble(strNum2);
        addOperationFactory af = new addOperationFactory();
        Operation operation = af.getOperation();
        operation.setNum1(num1);
        operation.setNum2(num2);
        result = operation.getResult();
//        else if ("-".equals(oper)){
//
//        }else if ("*".e2quals(oper)){
//
//        }else if ("/".equals(oper)){
//
//        }

        System.out.println(strNum1+oper+strNum2+"="+result);

    }
}
