package com.stu.design.signleton;

/**
 * @Auther: csx
 * @Date: 2022/3/20 12:36
 * @Description:
 */
public class mgr05 {
    private static mgr05 INSTANCE;

    private mgr05(){}

    public static  mgr05  getInstance(){
        if (INSTANCE == null){
            synchronized (mgr05.class) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            INSTANCE = new mgr05();
        }
        return INSTANCE;
    }

    public static void main(String[] args) {
        for (int i = 0 ;i<1000;i++){
            new Thread(()->{
                System.out.println(mgr05.getInstance().hashCode());
            }).start();
        }
    }
}
