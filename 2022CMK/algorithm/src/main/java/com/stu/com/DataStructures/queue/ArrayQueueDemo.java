package com.stu.com.DataStructures.queue;

import java.util.Scanner;

/**
 * @Auther: csx
 * @Date: 2022/4/13 20:47
 * @Description:
 */
public class ArrayQueueDemo {
    public static void main(String[] args) {
        ArrayQueue arrayQueue = new ArrayQueue(3);
        char key = ' ';//接受用户输入
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        while (loop){
            System.out.println("s(show):显示对列");
            System.out.println("e(exit):退出程序");
            System.out.println("a(add):添加数据到对列");
            System.out.println("g(get):从对列取出数据");
            System.out.println("h(head):查看对列头的数据");
            key = scanner.next().charAt(0);  //接受一个字符
            switch (key){
                case 's':
                    arrayQueue.showQueue();
                    break;
                case 'a':
                    System.out.println("请输入一个数");
                    int value = scanner.nextInt();
                    arrayQueue.addQueue(value);
                    break;
                case 'g':
                    try {
                        int res = arrayQueue.getQueue();
                        System.out.printf("取出的数据是%d\n",res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        int res = arrayQueue.headQueue();
                        System.out.printf("取出的数据是%d\n",res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;

            }
        }
        System.out.println("程序退出");

    }
}
//使用数组模拟对列-编写一个ArrayQueue类
class ArrayQueue{
    private int maxSize;  //表示数组的最大容量
    private int front;  //对列头
    private int rear; //对列尾
    private int[] arr; //该数据用与存放数据，模拟对列

    //创建对列的构造器
    public ArrayQueue(int arrMaxSize){
        maxSize = arrMaxSize;
        arr = new int[maxSize];
        front = -1;  //指向对列头部，分析出front是指向对列头的前一个位置
        rear = -1;  //指向对列尾部，指向对列尾的数据（即就是对列最后一个数据）
    }

    //判断对列是否满
    public boolean isFull(){
        return rear == maxSize-1;
    }

    //判断对列是否为空
    public boolean isEmpty(){
        return rear == front;
    }
    //添加数据到对列
    public void addQueue(int n){
        //判断对列是否满
        if (isFull()){
            System.out.println("对列满，不能加入数据");
            return;
        }
        rear++;
        arr[rear] = n;
    }
    //获取对列的数据，出队列
    public int getQueue(){
        //判断对列是否空
        if (isEmpty()){
            //通过抛出异常
            throw  new RuntimeException("对列空，不能取数据");
        }
        front++;
        return arr[front];
    }
    //显示对列的所有数据
    public void showQueue(){
        //遍历
        if (isEmpty()){
            System.out.println("对列为空");
            return;
        }
        for (int i=0;i<arr.length;i++){
            System.out.printf("arr[%d]=%d\n",i,arr[i]);
        }
    }
    public int headQueue(){
        if (isEmpty()){
            System.out.println("对列为空");
        }
        return arr[front+1];
    }
}