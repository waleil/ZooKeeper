package com.huawei.command;

import com.huawei.bridge.Gift;
import com.huawei.bridge.MM;
import com.huawei.bridge.Ring;
import com.huawei.bridge.WildGift;

import javax.jws.Oneway;
import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: csx
 * @Date: 2022/3/18 21:16
 * @Description:
 */
public class Boy {
    private String name;
    private List<Command> list = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void pursue(MM mm){

    }
    public void doSomething(){

    }
    public void addCommand(Command c){
        this.list.add(c);
    }

    public void executeCommand() {
        list.forEach(command -> {
            command.execute();
        });
    }
}
