package com.stu.design.signleton;

/**
 * @Auther: csx
 * @Date: 2022/3/20 16:57
 * @Description:
 */
public enum mgr08 {
    INSTANCE;
    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            new Thread(() -> {
                System.out.println(mgr08.INSTANCE.hashCode());
            }).start();
        }
    }
}
