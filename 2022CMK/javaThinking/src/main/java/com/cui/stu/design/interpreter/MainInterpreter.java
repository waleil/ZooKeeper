package com.cui.stu.design.interpreter;

/**
 * @Auther: csx
 * @Date: 2022/4/10 21:28
 * @Description:
 */
public class MainInterpreter {
    public static void main(String[] args) {
        String num = "10";
        Context context = new Context(num);

        Expression expression = new PlusExprission();
        expression.interprect(context);
        System.out.println(context.getOutput());
    }
}
