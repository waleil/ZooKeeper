package com.stu.com.JVM.outofmemoryerror;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: csx
 * @Date: 2022/4/24 19:59
 * @Description:
 */
public class HeapOOM {
    static class OOMObject{

    }

    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<>();
        while (true){
            list.add(new OOMObject());
        }
    }
}
