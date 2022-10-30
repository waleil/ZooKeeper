package com.huawei.command;

/**
 * @Auther: csx
 * @Date: 2022/3/18 21:44
 * @Description:
 */
public abstract class Command {

    public abstract void execute();

    public abstract void undo();
}
