package com.cui.stu.DataStructures.linkedlist;

/**
 * @Auther: csx
 * @Date: 2022/5/7 20:29
 * @Description:
 */
public class DoubleLinkedListDemo {

}

class DoubleLinkList {
    private DHeroNode head = new DHeroNode(0, "", "");

    public void add(DHeroNode heroNode) {
        DHeroNode temp = head;
        while (true) {
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        temp.next = heroNode;
        heroNode.pre = temp;
    }

    public void update(DHeroNode newHeroNode) {
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        DHeroNode temp = head.next;
        boolean flag = false;
        while (true) {
            if (temp == null) {
                break;//遍历到左后
            }
            if (temp.no == newHeroNode.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.name = newHeroNode.name;
            temp.nickname = newHeroNode.nickname;
        } else {
            System.out.printf("没有找到编号%d的节点，不能修改\n", newHeroNode.no);
        }
    }
    public void addByOrder(DHeroNode heroNode){
        DHeroNode temp = head;
        boolean flag = false;
        while (true){
            if (temp.next ==null){
                break;
            }
            if (temp.next.no>heroNode.next.no){
                break;
            }else if (temp.next.no == heroNode.no){
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag){
            System.out.printf("添加的英雄%d，已经存在\n ", heroNode.no);
        }else {
            heroNode.next = temp.next;
            if (temp.next!=null) {
                temp.next.pre = heroNode;
            }
            temp.next = heroNode;
            heroNode.pre = temp;
        }
    }
    public void del(int no){
        if (head.next==null){
            System.out.println("链表为空");
            return;
        }
        DHeroNode temp = head.next;
        boolean flag =false;
        while (true){
            if (temp == null){
                break;
            }
            if (temp.no ==no){
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.pre.next = temp.next;
            if (temp.next != null) {
                temp.next.pre = temp.pre;
            }

        } else {
            System.out.println("为查询到");
        }
    }
    public static int getLength(DHeroNode head){
        if (head.next == null){
            return 0;
        }
        int length = 0;
        DHeroNode temp = head;
        while (temp.next !=null){
            length++;
            temp = temp.next;
        }
        return length;
    }
}

class DHeroNode {
    public int no;
    public String name;
    public String nickname;
    public DHeroNode next;
    public DHeroNode pre;

    public DHeroNode(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "DHeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}