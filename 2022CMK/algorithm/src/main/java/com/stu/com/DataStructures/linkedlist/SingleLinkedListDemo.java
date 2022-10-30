package com.stu.com.DataStructures.linkedlist;

import java.util.Stack;

/**
 * @Auther: csx
 * @Date: 2022/4/14 21:57
 * @Description:
 */
public class SingleLinkedListDemo {
    public static void main(String[] args) {
        //进行测试
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");

        //创建要给链表
        SignleLinkList signleLinkList = new SignleLinkList();
//        signleLinkList.add(hero1);
//        signleLinkList.add(hero2);
//        signleLinkList.add(hero3);
//        signleLinkList.add(hero4);
        //按编号顺序加入
        signleLinkList.addByOrder(hero1);
        signleLinkList.addByOrder(hero4);
        signleLinkList.addByOrder(hero2);
        signleLinkList.addByOrder(hero3);
        signleLinkList.list();
        //测试修改
        HeroNode newHeroNode = new HeroNode(2, "小卢", "玉麒麟");
        signleLinkList.update(newHeroNode);


        signleLinkList.list();
        System.out.println("---------------");
        signleLinkList.del(1);
        signleLinkList.list();
        System.out.println("---------------");
        System.out.println(signleLinkList.getLength(signleLinkList.getHead()));

        HeroNode res = signleLinkList.findLastIndexNode(signleLinkList.getHead(), 1);
        System.out.println(res);
    }
}

//定义SignleLinkedList管理我们的英雄
class SignleLinkList{
    //先初始化一个头节点，头节点不要动,不存放具体的数据
    private HeroNode head = new HeroNode(0, "", "");



    //添加节点到单向链表:当不考虑编号顺序时，找到当前链表的最后的节点
    //将最后这个节点的next指向新的节点
    public void add(HeroNode heroNode){
        //因为head节点不能动，因此我们需要一个辅助遍历  temp
        HeroNode temp= head;
        while (true){
            if (temp.next==null){
                break;
            }
            temp = temp.next;
        }
        temp.next = heroNode;
    }

    //1.根据newHeroNode的no来修改即可
    public void update(HeroNode newHeroNode){
        //判断是否为空
        if (head.next == null){
            System.out.println("链表为空");
            return;
        }
        //找到需要修改的节点，根据no编号
        HeroNode temp = head.next;
        boolean flag = false;
        while (true){
            if (temp ==null){
                break;  //到了链表的最后，已经遍历结束了
            }
            if (temp.no == newHeroNode.no){
                flag = true;
                break;
            }
            temp = temp.next;
        }
        //根据flag判断是否找到要修改的节点
        if (flag){
            temp.name = newHeroNode.name;
            temp.nickname = newHeroNode.nickname;
        }else {
            System.out.printf("没有找到编号%d的节点，不能修改\n",newHeroNode.no);
        }
    }
    //第二种方式再添加英雄时，根据排名将英雄插入指定位置
    // （如果有这个排名，则添加失败，并给出提示）
    public void addByOrder(HeroNode heroNode){
        //因为头节点不能动，因此我们仍然通过一个辅助指针（变量）来帮助找到添加的位置
        //因为单链表，因为我们找的temp是位于添加位置的前一个节点，否则插入不了
        HeroNode temp = head;
        boolean flag = false;// 表示添加的编号不存在    默认为false
        while (true){
            if (temp.next ==null){
                break;
            }
            if (temp.next.no>heroNode.no){
                break;
            }else if (temp.next.no == heroNode.no){
                flag =true;
            }
            temp = temp.next; //向后移动一位
        }
        if (flag){
            System.out.printf("添加的英雄%的，已经存在",heroNode.no);
        }else {
            heroNode.next = temp.next;
            temp.next = heroNode;
        }

    }

    //删除节点
    // 1.head不能动，因此需要一个temp辅助节点找到待删除节点的前一个节点
    //2.说明我们再比较时，是temp.next.no和需要删除的节点no比较
    public void del(int no){
        HeroNode temp = head;
        boolean flag = false;
        while (true){
            if (temp.next ==null){
                break;
            }
            if (temp.next.no ==no){
                //找到待删除节点的前一个节点
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag){
            temp.next = temp.next.next;
        }else {
            System.out.println("为查询到");
        }
    }

    public static int getLength(HeroNode head){
        if (head.next==null){
            return 0;
        }
         int length = 0;
         HeroNode temp = head;
         while (temp.next != null){
             length ++;
             temp = temp.next;
         }
         return length;
    }

    public static HeroNode findLastIndexNode(HeroNode head,int index){
        if (head.next ==null){
            return null;  //链表为空
        }
        int size = getLength(head);
        if (index<=0 || index>size){
            return null;
        }
        HeroNode temp = head.next;
        for (int i = 0;i<size - index;i++){
            temp = temp.next;
        }
        return temp;
    }

    //单向链表翻转
    public static void reversetList(HeroNode head){
        //如果当前链表为空，或者只有一个节点，无需反转，直接返回
        if (head.next ==null || head.next.next == null){
            return;
        }

        //定义一个辅助的
        HeroNode cur = head.next;
        HeroNode next = null;
        HeroNode reverseHead = new HeroNode(0,"","");
        while (cur != null){
            next = cur.next;
            cur.next=reverseHead.next;
            reverseHead.next = cur;
            cur = next;
        }
        head.next = reverseHead.next;
    }

    //利用栈逆序打印
    public static void reversePrint(HeroNode head){
        if (head.next == null){
            return;
        }
        Stack<HeroNode> stack = new Stack<HeroNode>();
        HeroNode cur = head.next;
        while (cur!=null){
            stack.push(cur);
            cur = cur.next;
        }
        while (stack.size()>0){
            System.out.println(stack.pop());
        }
    }
    //显示链表【遍历】
    public void list(){
        if (head.next==null){
            System.out.println("链表为空");
            return;
        }
        HeroNode temp = head.next;
        while (true){
            if (temp==null) break;
            System.out.println(temp);
            //将temp向后移
            temp = temp.next;
        }

    }

    public HeroNode getHead() {
        return head;
    }
}
//定义一个HeroNode,每个HeroNOde对象是一个节点
class HeroNode{
    public int no;
    public String name;
    public String nickname;
    public HeroNode next;

    public HeroNode(int no,String name,String nickname){
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
