package com.stu.com.DataStructures.linkedlist;

/**
 * @Auther: csx
 * @Date: 2022/4/17 15:04
 * @Description:
 */
public class Josepfu {
    public static void main(String[] args) {
        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        circleSingleLinkedList.addBoy(5);
        circleSingleLinkedList.showBoy();
        circleSingleLinkedList.countBoy(1, 2, 5);
    }
}

//创建一个环形的单向列表
class CircleSingleLinkedList {
    //创建一个first节点，当前没有编号
    private Boy first = null;

    //添加小孩节点，    构建成一个环形的链表
    public void addBoy(int nums) {
        if (nums < 1) {
            System.out.println("nums值不正确");
            return;
        }
        Boy curBoy = null;//辅助指针，帮助构建环形链表
        for (int i = 1; i <= nums; i++) {
            Boy boy = new Boy(i);
            if (i == 1) {
                first = boy;
                first.setNext(first);
                curBoy = first;
            } else {
                curBoy.setNext(boy);
                boy.setNext(first);
                curBoy = boy;
            }
        }
    }

    //遍历当前的环形链表
    public void showBoy() {
        if (first == null) {
            System.out.println("没有任何小孩·");
        }
        Boy curBoy = first;
        while (true) {
            System.out.printf("小孩的编号%d \n", curBoy.getNo());
            if (curBoy.getNext() == first) {
                break;
            }
            curBoy = curBoy.getNext();
        }
    }

    //根据用户的输入，计算出小孩出圈的顺序
    public void countBoy(int startNO, int countNum, int nums) {
        if (first == null || startNO < 1 || startNO > nums) {
            System.out.println("参数输入有误，请重新输入");
            return;
        }
        //创建要给辅助指针，帮助完成小孩出圈
        Boy helper = first;
        //辅助指针helper,事先应该指向环形链表的最后这个节点
        while (true){
            if (helper.getNext() == first){
                break;
            }
            helper = helper.getNext();
        }
        //小孩报数前，先让first和helper移动k-1次
        for (int j = 0;j<startNO-1;j++){
            first = first.getNext();
            helper = helper.getNext();
        }
        //当小孩报数时，让first和helper指针同时的移动m-1次后出圈，循环操作，直到圈中只有一个节点
        while (true){
            if (helper == first){//说明圈中只有一个节点
                break;
            }
            //移动countNum -1出圈
            for (int j =0;j<countNum-1;j++){
                first = first.getNext();
                helper= helper.getNext();
            }
            //此时first指向的节点，就是要出圈的小孩节点
            System.out.printf("小孩%d出圈\n",first.getNo());
            //将first指向的小孩出圈
            first = first.getNext();
            helper.setNext(first);
        }
        System.out.printf("最后留在圈中的小孩编号%d \n",helper.getNo());
    }
}

//创建一个Boy类，表示一个节点
class Boy {
    private int no;
    private Boy next;

    public Boy(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }
}