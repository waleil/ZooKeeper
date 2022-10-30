package com.cui.stu.DataStructures.linkedlist;

/**
 * @Auther: csx
 * @Date: 2022/5/7 21:23
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
class CircleSingleLinkedList{
    private Boy first = null;

    public void addBoy(int nums){
        if (nums<1){
            System.out.println("nums值不正确");
            return;
        }
        Boy curBoy =null;
        for (int i=1;i<=nums;i++){
            Boy boy = new Boy(i);
            if (i==1){
                first = boy;
                first.setNext(first);
                curBoy = first;
            }else {
                curBoy.setNext(boy);
                boy.setNext(first);
                curBoy = boy;
            }
        }
    }
    public void showBoy(){
        if (first ==null){
            System.out.println("没有任何小孩");
            return;
        }
        Boy curBoy = first;
        while (true){
            System.out.printf("小孩的编号%d \n", curBoy.getNo());
            if (curBoy.getNext() == first){
                break;
            }
            curBoy = curBoy.getNext();
        }

    }
    public void countBoy(int startNO,int countNum,int nums){
        if (first == null || startNO<1 || startNO>nums){
            System.out.println("参数输入有误，请重新输入");
            return;
        }
        Boy helper = first;
        while (true){
            if (helper.getNext() == first){
                break;
            }
            helper = helper.getNext();
        }
        //移动k-1次找到第一个计数的位置//因为循环时从0开始计数，因此是移动k-1
        for (int j= 0;j<startNO-1;j++){
            first = first.getNext();
            helper = helper.getNext();
        }
        //当小孩报数时，让first和helper指针同时的移动m-1次后出圈，循环操作，直到圈中只有一个节点
        while (true){
            if (helper == first){
                break;
            }
            //移动countNum-1圈，同上计数是从0开始
            for (int i=0;i<countNum-1;i++){
                first = first.getNext();
                helper = helper.getNext();
            }
            //此时first指向的节点，就是要出圈的小孩节点
            System.out.printf("小孩%d出圈\n",first.getNo());
            first=first.getNext();
            helper.setNext(first);
        }
        System.out.printf("最后留在圈中的小孩编号%d \n",helper.getNo());
    }
}
class Boy{
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

