package com.cui.stu.thinking.file.container.map;

import java.util.Random;

/**
 * @Auther: csx
 * @Date: 2022/4/8 19:53
 * @Description:
 */
public class prediction {
    private static Random r = new Random();
    private boolean shadow = r.nextDouble() > 0.5;

    public String toString() {
        if (shadow) {
            return "Six more weeks of Winter!";
        } else {
            return "Early Spring!";
        }
    }
}
