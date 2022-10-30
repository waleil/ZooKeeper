package com.cui.stu.design.Composite;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: csx
 * @Date: 2022/3/27 21:44
 * @Description:
 */
public abstract class Node {
    abstract public void dislplay();
}

class leafNode extends Node{

    String name;
    public leafNode(String name){this.name = name;}

    @Override
    public void dislplay() {
        System.out.println(name);
    }
}

class BranchNode extends Node{
    List<Node> nodes;

    String name;

    public BranchNode(String name){
        this.name = name;
        this.nodes = new ArrayList<Node>();
    }

    @Override
    public void dislplay() {
        System.out.println(name);
    }

    public void add(Node n){
        nodes.add(n);
    }

}