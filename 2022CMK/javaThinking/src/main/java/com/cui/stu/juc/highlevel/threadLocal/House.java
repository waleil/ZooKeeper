package com.cui.stu.juc.highlevel.threadLocal;

/**
 * @Auther: csx
 * @Date: 2022/9/4 10:18
 * @Description:
 */
public class House {

    int saleCount = 0;

    public synchronized void saleHouse(){
        ++saleCount;
    }

//    ThreadLocal<Integer> saleVolume = new ThreadLocal<Integer>(){
//        @Override
//        protected Integer initialValue(){
//            return 0;
//        }
//    };
    ThreadLocal<Integer> saleVolume = ThreadLocal.withInitial(()->0);
    public void saleVolumeByThreadLocal(){
        saleVolume.set(1+saleVolume.get());
    }

}
