package com.huawei.command;

/**
 * @Auther: csx
 * @Date: 2022/3/18 21:48
 * @Description:
 */
public class Hug extends Command{
    @Override
    public void execute() {
        System.out.println("hug");
    }

    @Override
    public void undo() {
        System.out.println("open your arms");
    }
}
