package com.cui.stu.design.composite1;

import jdk.nashorn.internal.ir.IfNode;

import java.util.List;

/**
 * @Auther: csx
 * @Date: 2022/4/10 19:28
 * @Description:
 */
public class Maincomposite1 {
    public static void main(String[] args) {
        Folder root = new Folder("C:");
        Folder bei = new Folder("beifeng");
        File file = new File("bei.txt");
        root.add(bei);
        root.add(file);
        displayTree(root);
    }

    private static void displayTree(IFile root) {
        root.display();
        List<IFile> children = root.getChild();
        for (IFile file:children){
            if (file instanceof File){
                file.display();
            }else {
                displayTree(file);
            }
        }
    }
}
