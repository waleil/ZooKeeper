package com.cui.stu.design.composite1;

import java.util.List;

/**
 * @Auther: csx
 * @Date: 2022/4/10 19:21
 * @Description:
 */
public class File implements IFile{
    private String name;

    public File(String name){
        this.name= name;
    }
    @Override
    public void display() {
        System.out.println(name);
    }

    @Override
    public boolean add(IFile file) {
        return false;
    }

    @Override
    public boolean remove(IFile file) {
        return false;
    }

    @Override
    public List<IFile> getChild() {
        return null;
    }
}
