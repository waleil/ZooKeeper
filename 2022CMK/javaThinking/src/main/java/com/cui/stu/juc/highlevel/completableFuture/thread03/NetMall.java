package com.cui.stu.juc.highlevel.completableFuture.thread03;

import lombok.Getter;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

/**
 * @Auther: csx
 * @Date: 2022/8/30 22:25
 * @Description:
 */
public class NetMall {

    @Getter
    private String netMallName;

    public NetMall(String netMallName){
        this.netMallName = netMallName;
    }

    public double calcPrice(String productName){
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return ThreadLocalRandom.current().nextDouble()*2+productName.charAt(0);
    }
}
