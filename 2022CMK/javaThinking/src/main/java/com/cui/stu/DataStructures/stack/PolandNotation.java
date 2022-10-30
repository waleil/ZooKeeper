package com.cui.stu.DataStructures.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Auther: csx
 * @Date: 2022/5/8 19:07
 * @Description:
 */
public class PolandNotation {
    public static void main(String[] args) {
        String expression = "10+((2+3)*4)-5";
        List<String> list1 = toInfixExpressionList(expression);
        System.out.println(list1);
        List<String> list2 = parseDuffixExpression(list1);
        System.out.println(list2);

        int res = calculate(list2);
        System.out.println(res);

    }

    private static int calculate(List<String> ls) {
        Stack<String> stack = new Stack<>();
        for (String item :ls){
            if (item.matches("\\d+")){
                stack.push(item);
            }else {
                int num1 = Integer.parseInt(stack.pop());
                int num2 = Integer.parseInt(stack.pop());
                int res = 0;
                if (item.equals("+")){
                    res = num1 + num2;
                }else if (item.equals("-")){
                    res = num2 - num1;
                }else if (item.equals("*")){
                    res = num1*num2;
                }else if (item.equals("/")){
                    res = num2/num1;
                }else {
                    throw new RuntimeException("运算符有误");
                }
                stack.push(""+res);
            }

        }
        return Integer.parseInt(stack.pop());
    }

    private static List<String> parseDuffixExpression(List<String> ls) {
        Stack<String> s1 = new Stack<>();
        List<String> s2 = new ArrayList<>();
        for (String item:ls){
            if (item.matches("\\d+")){
                s2.add(item);
            }else if (item.equals("(")){
                s1.push(item);
            }else if (item.equals(")")){
                while (!s1.peek().equals("(")){
                    s2.add(s1.pop());
                }
                s1.pop();
            }else {
                while (s1.size()!=0 && Operation.getValue(s1.peek())>=Operation.getValue(item)){
                    s2.add(s1.pop());
                }
                s1.push(item);
            }
        }
        while (s1.size()!=0){
            s2.add(s1.pop());
        }
        return s2;
    }

    private static List<String> toInfixExpressionList(String expression) {
        List<String> ls = new ArrayList<>();
        int i = 0;
        String str;
        char c;
        do {
            if ((c = expression.charAt(i)) < 48 || (c = expression.charAt(0)) > 57) {
                 ls.add(""+c);
                 i++;
            }else {
                str = "";
                while (i<expression.length() && (c=expression.charAt(i))>=48 && (c=expression.charAt(i)) <=57){
                    str +=c;
                    i++;
                }
                ls.add(str);
            }
        } while (i < expression.length());
        return ls;
    }
}

class Operation {
    private static int ADD = 1;
    private static int SUB = 1;
    private static int MUL = 2;
    private static int DIV = 2;

    public static int getValue(String operation) {
        int result = 0;
        switch (operation) {
            case "+":
                result = ADD;
                break;
            case "-":
                result = SUB;
                break;
            case "*":
                result = MUL;
                break;
            case "/":
                result = DIV;
                break;
            default:
                System.out.println("不存在此运算符");
                break;
        }
        return result;
    }
}
