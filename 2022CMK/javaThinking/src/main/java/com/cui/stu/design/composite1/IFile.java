package com.cui.stu.design.composite1;

import java.util.List;

/**
 * @Auther: csx
 * @Date: 2022/4/10 19:18
 * @Description:
 */
public interface IFile {
    //显示文件或者文件夹的名称
    public void display();

    public boolean add(IFile file);

    public boolean remove(IFile file);

    public List<IFile> getChild();
}
