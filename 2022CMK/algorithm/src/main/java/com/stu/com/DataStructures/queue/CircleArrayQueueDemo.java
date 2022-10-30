package com.stu.com.DataStructures.queue;

import java.util.Scanner;

/**
 * @Auther: csx
 * @Date: 2022/4/13 22:46
 * @Description:
 */
public class CircleArrayQueueDemo {
    public static void main(String[] args) {
        CircleArray arrayQueue = new CircleArray(4);
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

class CircleArray {
    private int maxSize;  //表示数组的最大容量
    private int front;  //指向对列的第一个元素，也就是说arr[front]  front=0
    private int rear; //指向对列的最后一个元素的后一个位置，因为希望空出一个位置作为约定，rear 初始值为0
    private int[] arr; //该数据用与存放数据，模拟对列

    public CircleArray(int arrMaxSize) {
        maxSize = arrMaxSize;
        arr = new int[maxSize];
    }

    //判断对列是否满
    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    //判断对列是否为空
    public boolean isEmpty() {
        return rear == front;
    }

    //添加数据到对列
    public void addQueue(int n) {
        //判断对列是否满
        if (isFull()) {
            System.out.println("对列满，不能加入数据");
            return;
        }
        arr[rear] = n;
        //将rear后移，这里必须考虑取模
        rear = (rear + 1) % maxSize;
    }

    //获取对列的数据，出队列
    public int getQueue() {
        //判断对列是否空
        if (isEmpty()) {
            //通过抛出异常
            throw new RuntimeException("对列空，不能取数据");
        }
        //这里需要分析出front是指向对列的第一个元素
        //1.先把front 对应的值保留到一个临时变量
        //2.将front后移
        //3.将临时报错的变量返回
        int value = arr[front];
        front = (front + 1) % maxSize;
        return value;
    }
    //显示对列的所有数据
    public void showQueue(){
        //遍历
        if (isEmpty()){
            System.out.println("对列为空");
            return;
        }
        for (int i=front;i<front+size();i++){
            System.out.printf("arr[%d]=%d\n",i%maxSize,arr[i%maxSize]);
        }
    }
    //求出当前对列有效数据的个数
    public int size(){
        return (rear+maxSize-front)%maxSize;
    }
    public int headQueue(){
        if (isEmpty()){
            System.out.println("对列为空");
        }
        return arr[front];
    }
}