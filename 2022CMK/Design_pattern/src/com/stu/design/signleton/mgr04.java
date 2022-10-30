package com.stu.design.signleton;

/**
 * @Auther: csx
 * @Date: 2022/3/20 12:31
 * @Description:
 */
public class mgr04 {
    private static mgr04 INSTANCE;

    private mgr04(){}

    public static synchronized mgr04  getInstance(){
        if (INSTANCE == null){
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            INSTANCE = new mgr04();
        }
        return INSTANCE;
    }

    public static void main(String[] args) {
        for (int i = 0 ;i<100;i++){
            new Thread(()->{
                System.out.println(mgr04.getInstance().hashCode());
            }).start();
        }
    }
}
