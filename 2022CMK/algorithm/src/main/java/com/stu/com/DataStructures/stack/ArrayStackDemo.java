package com.stu.com.DataStructures.stack;

import java.util.Scanner;

/**
 * @Auther: csx
 * @Date: 2022/4/17 22:05
 * @Description:
 */
public class ArrayStackDemo {
    public static void main(String[] args) {
        ArrayStack arrayStack = new ArrayStack(4);
        String key = "";
        boolean loop = true;
        Scanner scanner = new Scanner(System.in);
        while (loop){
            System.out.println("show:表示显示栈");
            System.out.println("exit:退出程序");
            System.out.println("push:表示添加数据到栈");
            System.out.println("pop:表示从栈取出数据");
            System.out.println("请输入");
            key = scanner.next();
            switch (key){
                case "show":
                    arrayStack.list();
                    break;
                case "exit":
                    scanner.close();
                    loop= false;
                    break;
                case "push":
                    System.out.println("请输入一行数");
                    int value= scanner.nextInt();
                    arrayStack.push(value);
                    break;
                case "pop":
                    try {
                        int res = arrayStack.pop();
                        System.out.printf("出栈的数据是%d\n",res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                default:
                    break;
            }
        }
    }
}

class ArrayStack{
    private int masSize;  //栈的大小
    private int[] stack;   //数组，数组模拟栈，数据就放在该数组
    private int top = -1;

    public ArrayStack(int masSize) {
        this.masSize = masSize;
        stack = new int[this.masSize];
    }

    //栈满
    public boolean isFull(){
        return top == masSize-1;
    }
    //栈空
    public boolean isEmpty(){
        return top == -1;
    }
    //入栈
    public void push(int value){
        if (isFull()){
            System.out.println("栈满");
            return;
        }
        top++;
        stack[top] = value;
    }
    //出栈
    public int pop(){
        if (isEmpty()){
            throw  new RuntimeException("栈空");
        }
        int value = stack[top];
        top--;
        return value;
    }
    //遍历栈
    public void list(){
        if (isEmpty()){
            System.out.println("没有数据");
            return;
        }
        for (int i=top;i>=0;i--){
            System.out.printf("stack[%d]=%d\n", i,stack[i]);
        }
    }
}