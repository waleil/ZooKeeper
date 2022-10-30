package com.stu.com.DataStructures.linkedlist;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import org.w3c.dom.ls.LSOutput;

import java.util.Stack;

/**
 * @Auther: csx
 * @Date: 2022/4/17 10:39
 * @Description:
 */
public class DoubleLinkedListDemo {
    public static void main(String[] args) {
        System.out.println("双向链表测试");
        DHeroNode hero1 = new DHeroNode(1, "宋江", "及时雨");
        DHeroNode hero2 = new DHeroNode(2, "卢俊义", "玉麒麟");
        DHeroNode hero3 = new DHeroNode(3, "吴用", "智多星");
        DHeroNode hero4 = new DHeroNode(4, "林冲", "豹子头");

        //创建要给链表
        DoubleLinkList doubleLinkList = new DoubleLinkList();
//        doubleLinkList.add(hero1);
//        doubleLinkList.add(hero2);
//        doubleLinkList.add(hero3);
//        doubleLinkList.add(hero4);
        doubleLinkList.addByOrder(hero1);
        doubleLinkList.addByOrder(hero2);
        doubleLinkList.addByOrder(hero4);
        doubleLinkList.addByOrder(hero3);
        doubleLinkList.addByOrder(hero4);
        doubleLinkList.list();
        System.out.println("-------------");

        //修改
        DHeroNode newheroNOde = new DHeroNode(4, "公孙胜", "入云龙");
        doubleLinkList.update(newheroNOde);
        System.out.println("修改后的链表情况");
        doubleLinkList.list();
        System.out.println("-------------");
        doubleLinkList.del(4);
        doubleLinkList.list();
    }
}

//定义SignleLinkedList管理我们的英雄
class DoubleLinkList {
    //先初始化一个头节点，头节点不要动,不存放具体的数据
    private DHeroNode head = new DHeroNode(0, "", "");


    //添加节点到单向链表:当不考虑编号顺序时，找到当前链表的最后的节点
    //将最后这个节点的next指向新的节点
    public void add(DHeroNode heroNode) {
        //因为head节点不能动，因此我们需要一个辅助遍历  temp
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

    //1.根据newHeroNode的no来修改即可
    public void update(DHeroNode newHeroNode) {
        //判断是否为空
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        //找到需要修改的节点，根据no编号
        DHeroNode temp = head.next;
        boolean flag = false;
        while (true) {
            if (temp == null) {
                break;  //到了链表的最后，已经遍历结束了
            }
            if (temp.no == newHeroNode.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        //根据flag判断是否找到要修改的节点
        if (flag) {
            temp.name = newHeroNode.name;
            temp.nickname = newHeroNode.nickname;
        } else {
            System.out.printf("没有找到编号%d的节点，不能修改\n", newHeroNode.no);
        }
    }

    //第二种方式再添加英雄时，根据排名将英雄插入指定位置
    // （如果有这个排名，则添加失败，并给出提示）
    public void addByOrder(DHeroNode heroNode) {
        //因为头节点不能动，因此我们仍然通过一个辅助指针（变量）来帮助找到添加的位置
        //因为单链表，因为我们找的temp是位于添加位置的前一个节点，否则插入不了
        DHeroNode temp = head;
        boolean flag = false;// 表示添加的编号不存在    默认为false
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.no > heroNode.no) {
                break;
            } else if (temp.next.no == heroNode.no) {
                flag = true;
            }
            temp = temp.next; //向后移动一位
        }
        if (flag) {
            System.out.printf("添加的英雄%d，已经存在\n ", heroNode.no);
        } else {
            heroNode.next = temp.next;
            if (temp.next !=null) {
                temp.next.pre=heroNode;
            }
            temp.next = heroNode;
            heroNode.pre = temp;
        }

    }

    //删除节点
    //2.说明我们再比较时，是temp.next.no和需要删除的节点no比较
    public void del(int no) {
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        DHeroNode temp = head.next;
        boolean flag = false;
        while (true) {
            if (temp == null) {
                break;
            }
            if (temp.no == no) {
                //找到待删除节点的前一个节点
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

    public static int getLength(HeroNode head) {
        if (head.next == null) {
            return 0;
        }
        int length = 0;
        HeroNode temp = head;
        while (temp.next != null) {
            length++;
            temp = temp.next;
        }
        return length;
    }

    public static HeroNode findLastIndexNode(HeroNode head, int index) {
        if (head.next == null) {
            return null;  //链表为空
        }
        int size = getLength(head);
        if (index <= 0 || index > size) {
            return null;
        }
        HeroNode temp = head.next;
        for (int i = 0; i < size - index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    //单向链表翻转
    public static void reversetList(HeroNode head) {
        //如果当前链表为空，或者只有一个节点，无需反转，直接返回
        if (head.next == null || head.next.next == null) {
            return;
        }

        //定义一个辅助的
        HeroNode cur = head.next;
        HeroNode next = null;
        HeroNode reverseHead = new HeroNode(0, "", "");
        while (cur != null) {
            next = cur.next;
            cur.next = reverseHead.next;
            reverseHead.next = cur;
            cur = next;
        }
        head.next = reverseHead.next;
    }

    //利用栈逆序打印
    public static void reversePrint(HeroNode head) {
        if (head.next == null) {
            return;
        }
        Stack<HeroNode> stack = new Stack<HeroNode>();
        HeroNode cur = head.next;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        while (stack.size() > 0) {
            System.out.println(stack.pop());
        }
    }

    //显示链表【遍历】
    public void list() {
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        DHeroNode temp = head.next;
        while (true) {
            if (temp == null) break;
            System.out.println(temp);
            //将temp向后移
            temp = temp.next;
        }

    }

    public DHeroNode getHead() {
        return head;
    }
}

//定义一个HeroNode,每个HeroNOde对象是一个节点
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
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}
