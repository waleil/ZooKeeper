package com.stu.design.signleton;

/**
 * @Auther: csx
 * @Date: 2022/3/20 12:44
 * @Description:
 */
public class mgr07 {
    private static mgr07 INSTANCE;

    private mgr07() {
    }

    private static class mgr07Hello{
        private final static mgr07 INSTANCE = new mgr07();
    }
    public static mgr07 getInstance() {

        return mgr07Hello.INSTANCE;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            new Thread(() -> {
                System.out.println(mgr07.getInstance().hashCode());
            }).start();
        }
    }
}
