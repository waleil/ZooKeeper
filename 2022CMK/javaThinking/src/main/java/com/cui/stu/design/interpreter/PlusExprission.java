package com.cui.stu.design.interpreter;

/**
 * @Auther: csx
 * @Date: 2022/4/10 21:32
 * @Description:
 */
public class PlusExprission extends Expression{
    @Override
    public void interprect(Context context) {
        System.out.println("自动递增");
        // 获的上下文环境
        String input = context.getInput();

        int intInput = Integer.parseInt(input);

        intInput++;
        //对上下文环境重新进行复制
        context.setInput(String.valueOf(intInput));
        context.setOutput(intInput);


    }
}
