package com.cui.stu.juc.highlevel.completableFuture.thread03;

import com.sun.java.swing.plaf.windows.WindowsInternalFrameTitlePane;
import jdk.nashorn.internal.ir.CallNode;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * @Auther: csx
 * @Date: 2022/8/30 21:45
 * @Description:
 */
public class CompletableFutureMallDemo {
    static List<NetMall> list = Arrays.asList(
            new NetMall("jd"),
            new NetMall("dangdang"),
            new NetMall("taobao")
    );
    public static List<String> getPrice(List<NetMall> list,String productName){
        return list.stream().map(netMall ->
                String.format(productName + "in %s price is %.2f",
                        netMall.getNetMallName(),
                        netMall.calcPrice(productName)))
                .collect(Collectors.toList());
    }
    public static List<String> getPriceByCompletableFutrue(List<NetMall> list,String productName){
        return list.stream().map(netMall ->
                CompletableFuture.supplyAsync(() ->
                        String.format(productName + "in %s price is %.2f",
                                netMall.getNetMallName(),
                                netMall.calcPrice(productName))))
                .collect(Collectors.toList())
                .stream().map(s -> s.join())
                .collect(Collectors.toList());

    }
    public static void main(String[] args) {
//        CompletableFuture<String> completableFuture2 = CompletableFuture.supplyAsync(() -> {
//
//            return "hello supplyAsync";
//        });
//        System.out.println(completableFuture2.join());

        List<String> list1 = getPrice(list, "mysql");
        list1.stream().forEach(System.out::println);
    }
}
