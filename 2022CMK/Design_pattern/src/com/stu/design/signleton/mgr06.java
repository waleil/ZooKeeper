package com.stu.design.signleton;

/**
 * @Auther: csx
 * @Date: 2022/3/20 12:41
 * @Description:
 */
public class mgr06 {
    private static volatile mgr06 INSTANCE;

    private mgr06() {
    }

    public static mgr06 getInstance() {
        if (INSTANCE == null) {
            synchronized (mgr05.class) {
                if (INSTANCE == null) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                INSTANCE = new mgr06();
            }
        }
        return INSTANCE;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            new Thread(() -> {
                System.out.println(mgr06.getInstance().hashCode());
            }).start();
        }
    }
}
