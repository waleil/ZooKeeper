package com.stu.design.signleton;

/**
 * @Auther: csx
 * @Date: 2022/3/20 10:36
 * @Description:
 */
public class mgr03 {
    private static mgr03 INSTANCE;

    private mgr03(){}

    public static mgr03 getInstance(){
        if (INSTANCE == null){
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            INSTANCE = new mgr03();
        }
        return INSTANCE;
    }

    public static void main(String[] args) {
        for (int i = 0 ;i<100;i++){
            new Thread(()->{
                System.out.println(mgr03.getInstance().hashCode());
            }).start();
        }
    }
}
