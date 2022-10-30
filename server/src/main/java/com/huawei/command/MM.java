package com.huawei.command;

/**
 * @Auther: csx
 * @Date: 2022/3/18 21:17
 * @Description:
 */
public class MM {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void order(Boy b){
        Command c1= new Shopping();
        b.addCommand(c1);
        Command c2= new Hug();
        b.addCommand(c2);
        b.executeCommand();
    }
}
