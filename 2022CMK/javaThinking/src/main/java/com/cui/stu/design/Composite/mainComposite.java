package com.cui.stu.design.Composite;

/**
 * @Auther: csx
 * @Date: 2022/3/27 21:51
 * @Description:
 */
public class mainComposite {
    public static void main(String[] args) {
        BranchNode root = new BranchNode("root");
        BranchNode chapter1 = new BranchNode("chapter1");
        BranchNode chapter2 = new BranchNode("Chapter2");
        Node c11 = new leafNode("c11");
        Node c12 = new leafNode("c12");
        BranchNode b21 = new BranchNode("section21");
        Node c211 = new leafNode("c211");
        Node c212 = new leafNode("c212");

        root.add(chapter1);
        root.add(chapter2);
        chapter1.add(c11);
        chapter2.add(c12);
        chapter2.add(b21);
        b21.add(c211);
        b21.add(c212);
        tree(root,0);
    }

    private static void tree(Node root,int depth) {
        for (int i=0;i<depth;i++){
            System.out.print("--");
        }
        root.dislplay();
        if (root instanceof BranchNode){
            for (Node n:((BranchNode) root).nodes){
                tree(n,depth+1);
            }
        }
    }
}
