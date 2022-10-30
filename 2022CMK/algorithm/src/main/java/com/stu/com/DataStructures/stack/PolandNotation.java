package com.stu.com.DataStructures.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Auther: csx
 * @Date: 2022/4/23 11:01
 * @Description:
 */
public class PolandNotation {
    public static void main(String[] args) {
        //完成数字表达式转换为后缀表达式功能
        //说明：1.1+（（2+3）*4）-5  =》转成 1 2 3 + 4 * + 5 -
        //2. 因为直接对str进行操作，不方便，因此先将表达式存放到list中 即1+（（2+3）*4）-5 =》ArrayList[1,+,（,（,2,+,3,）,*,4,）,-,5,]
        //3.转换成后缀表达式
        String expression = "1+((2+3)*4)-5";
        List<String> list1 = toInfixExpressionList(expression);
        System.out.println(list1);
        List<String> list2 = parseDuffixExpression(list1);
        System.out.println(list2);


        //先定义给逆波兰表达式
        //（3+4）*5-6  => 3 4 + 5 * 6 -
        //说明为了方便，逆波兰表达式的数字和字符串使用空格隔开
       // String  suffixExpression = "3 4 + 5 * 6 -";
        //思路：1.先将"3 4 + 5 * 6 -" => 放到ArrayList中
        //2.将ArrayList传递给一个方法，遍历ArrayList配合栈完成计算
       // List<String> list = getListString(suffixExpression);
        //System.out.println(list);
        int res = calculate(list2);
        System.out.println(res);
    }

    //方法：将中缀表达式转移成对应的List
    public static List<String> toInfixExpressionList(String s){
        //定义一个List,存放中缀表达式，对应的内容
        List<String> ls = new ArrayList<>();
        int i =0; //这时是一个指针，用于遍历中缀表达式字符串
        String str; // 对多位数拼接
        char c; // 每遍历一个字符，就放到list中
        do {
            //如果c是一个非数字，我们需要加入一个ls
            if ((c=s.charAt(i))<48 || (c=s.charAt(i)) > 57){
                ls.add(""+c);
                i++;
            }else {  //  如果是一个数，需要考虑多位数
                str = "";
                while (i<s.length() && (c=s.charAt(i))>=48 && (c=s.charAt(i)) <=57){
                    str +=c;
                    i++;
                }
                ls.add(str);
            }
        }while (i<s.length());
        return ls;
    }
    //即ArrayList[1,+,（,（,2,+,3,）,*,4,）,-,5] => ArrayList[1,2,3,+,4,*,+,5,-]
    //方法：将得到的中缀表达式对应的List =>后缀表达式对应的List
    public static List<String> parseDuffixExpression(List<String> ls){
         //定义两个栈
        Stack<String> s1 = new Stack<>();
        //说明：因为存储栈，再整个转换过程中，没有pop操作，而且后面我们还需要逆序输出
        //因此这里用List<String>替换
        List<String> s2 = new ArrayList<>();
        //遍历
        for (String item : ls){
              //如果是一个数字加入说
            if (item.matches("\\d+")){
                s2.add(item);
            }else if (item.equals("(")){
                s1.push(item);
            }else if (item.equals(")")){
                while (!s1.peek().equals("(")){
                    s2.add(s1.pop());
                }
                s1.pop();   //将（弹出s1栈，消除小括号
            }else {
                //当item的优先级小于s1栈顶运算符，将s1栈顶的运算符弹出并加入s2中，再次转到（4.1）与s1中新的栈顶运算符相比较
                //问题：缺少一个比较优先级
                while (s1.size() !=0 && Operation.getValue(s1.peek())>=Operation.getValue(item)){
                    s2.add(s1.pop());
                }
                s1.push(item);
            }
        }
        //将s1中剩余的运算符依此弹出并加入s2
        while (s1.size() != 0){
            s2.add(s1.pop());
        }
        return s2;  //因为是存入list,因此按顺序输出就是对应的后缀表达式对应的List
    }
    public static List<String> getListString(String suffixExpression){
        String[] split = suffixExpression.split(" ");
        List<String> list = new ArrayList<>();
        for (String ele : split){
            list.add(ele);
        }
        return list;
    }
    public static int calculate(List<String> ls){
        Stack<String> stack = new Stack<>();
        for (String item : ls){
            if (item.matches("\\d+")) {
                //入栈
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
        //最后留在stack中的数据是运算结果
        return Integer.parseInt(stack.pop());
    }
}
//编写一个类 Operation 可以返回一个运算符，对应的优先级
class Operation{
    private static int ADD = 1;
    private static int SUB = 1;
    private static int MUL = 2;
    private static int DIV = 2;

    //写一个方法，返回对应的优先级数字
    public static int getValue(String operation){
        int result = 0;
        switch (operation){
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