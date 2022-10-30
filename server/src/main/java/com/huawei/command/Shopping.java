package com.huawei.command;

/**
 * @Auther: csx
 * @Date: 2022/3/18 21:47
 * @Description:
 */
public class Shopping extends Command{
    @Override
    public void execute() {
        System.out.println("zoo");
    }

    @Override
    public void undo() {
        System.out.println("undo zoo");
    }
}
