package com.cui.stu.juc.highlevel.completableFuture.thread03;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/*获得结果和触发计算
 */
public class CompletableFutureAPIDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "abc";
        });
        //System.out.println(completableFuture.get());
        //System.out.println(completableFuture.get(2l,TimeUnit.SECONDS));
        //System.out.println(completableFuture.join());
        //没有计算完成，给指定的“XXX”,计算完成，则返回计算完成后的结果。
        //System.out.println(completableFuture.getNow("XXX"));
        System.out.println(completableFuture.complete("completeValue")+"\t"+completableFuture.join());
    }
}
