package com.cui.stu.thinking.file.container.map;

import java.lang.reflect.InvocationTargetException;

/**
 * @Auther: csx
 * @Date: 2022/4/8 20:39
 * @Description:
 */
public class SpringDetector2 {
    public static void main(String[] args) throws NoSuchMethodException, SecurityException, InstantiationException,
            IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        SpringDetector.detectSpring(Groundhog2.class);
    }
}
