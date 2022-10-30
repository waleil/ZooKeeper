package com.stu.com.DataStructures.stack;

/**
 * @Auther: csx
 * @Date: 2022/4/19 21:46
 * @Description:
 */
public class Calculator {
    public static void main(String[] args) {
        //根据前面老师思路，完成表达式的运算
        String expression = "70+2*6-2";
        //创建两个栈
        CArrayStack numStack = new CArrayStack(10);
        CArrayStack operStack = new CArrayStack(10);
        //定义相关的变量
        int index = 0;//用于扫描
        int num1 = 0;
        int num2 = 0;
        int oper = 0;
        int res = 0;
        char ch = ' ';//将每次扫描得到char保存到ch
        String keepNum = "";//用于拼接多位数
        //开始while 循环的扫描expression
        while (true) {
            //依此的到expression的每一个字符
            ch = expression.substring(index, index + 1).charAt(0);
            //判断ch是什么，然后做相应处理
            if (operStack.isOper(ch)) {//如果是运算符
                //判断当前的符号栈是否为空
                if (!operStack.isEmpty()) {
                    //如果符号栈有操作符，就进行比较，如果当前的操作符的优先级小于或者等于栈中的操作符，就需要从数栈中pop出两个数，
                    //在从符号栈中pop出一个符号，进行运算，将得到的结果，入数栈，然后将当前的操作符入符号栈
                    if (operStack.priority(ch) <= operStack.priority(operStack.peek())) {
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        oper = operStack.pop();
                        res = numStack.cal(num1, num2, (char) oper);
                        //把运算结果入数栈
                        numStack.push(res);
                        operStack.push(ch);
                    } else {
                        //如果当前的操作符的优先级大于栈中的操作符，就直接入符号栈
                        operStack.push(ch);
                    }
                } else {
                    //如果为空栈，就直接入栈
                    operStack.push(ch);
                }
            } else {
                // numStack.push(ch - 48);
                //1.当处理多位数时，不能发现是一个数就立即入栈，因为他可能是多位数，
                //2.在处理数，需要向expression的表达式的index,后再看一位，如果是数就进行扫描，如果是符号才入栈

                //处理多位数
                keepNum += ch;
                //如果ch已经是expression的最后一位，就直接入栈
                if (index == expression.length() - 1) {
                    numStack.push(Integer.parseInt(keepNum));
                } else {
                    //判断下一个字符是不是数字，如果是数字，就继续扫描，如果是运算符，则入栈
                    //注意是看后一位，不是index++
                    if (operStack.isOper(expression.substring(index + 1, index + 2).charAt(0))) {
                        //如果后一位是运算符，则入栈
                        numStack.push(Integer.parseInt(keepNum));
                        keepNum = "";
                    }

                }
            }
            //让index+1，并判断是否扫描到最后
            index++;
            if (index >= expression.length()) {
                break;
            }
        }
        //当表达式扫描完毕，就顺序的从数栈和符号栈中pop出相应的数和符号，并运行
        while (true) {
            //如果符号栈为空，则计算到最后的结果，数栈中只有一个数字结果
            if (operStack.isEmpty()) {
                break;
            }
            num1 = numStack.pop();
            num2 = numStack.pop();
            oper = operStack.pop();
            res = numStack.cal(num1, num2, (char) oper);
            //把运算结果入数栈
            numStack.push(res);
        }
        System.out.printf("表达式%s = %d", expression, numStack.pop());
    }
}

//先创建一个栈，直接使用前面创建好的
class CArrayStack {
    private int masSize;  //栈的大小
    private int[] stack;   //数组，数组模拟栈，数据就放在该数组
    private int top = -1;

    public CArrayStack(int masSize) {
        this.masSize = masSize;
        stack = new int[this.masSize];
    }

    //返回栈顶的值，但是不真正的pop
    public int peek() {
        return stack[top];
    }

    //栈满
    public boolean isFull() {
        return top == masSize - 1;
    }

    //栈空
    public boolean isEmpty() {
        return top == -1;
    }

    //入栈
    public void push(int value) {
        if (isFull()) {
            System.out.println("栈满");
            return;
        }
        top++;
        stack[top] = value;
    }

    //出栈
    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("栈空");
        }
        int value = stack[top];
        top--;
        return value;
    }

    //遍历栈
    public void list() {
        if (isEmpty()) {
            System.out.println("没有数据");
            return;
        }
        for (int i = top; i >= 0; i--) {
            System.out.printf("stack[%d]=%d\n", i, stack[i]);
        }
    }

    //返回运算符的优先级，优先级是程序员来确定，优先级使用数字表示
    //数字越大优先级越高
    public int priority(int oper) {
        if (oper == '*' || oper == '/') {
            return 1;
        } else if (oper == '+' || oper == '-') {
            return 0;
        } else {
            return -1;
        }
    }

    //判断是不是一个运算符
    public boolean isOper(char val) {
        return val == '+' || val == '-' || val == '*' || val == '/';
    }

    //计算方法
    public int cal(int num1, int num2, char oper) {
        int res = 0;  //用于存放计算的结果
        switch (oper) {
            case '+':
                res = num1 + num2;
                break;
            case '-':
                res = num2 - num1;//注意顺序
                break;
            case '*':
                res = num1 * num2;
                break;
            case '/':
                res = num2 / num1;
                break;

            default:
                break;
        }
        return res;
    }
}