package com.huawei.State;

import com.ctc.wstx.shaded.msv_core.reader.relax.core.ModuleMergeState;
import com.huawei.command.Boy;
import com.huawei.command.Command;
import com.huawei.command.Hug;
import com.huawei.command.Shopping;

/**
 * @Auther: csx
 * @Date: 2022/3/18 21:17
 * @Description:
 */
public class MM {
    private String name;
    private MMState state = new MMHappyState();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void smile(){

    }
    public void cry(){

    }
    public void say(){

    }
}
