package com.cui.stu.thinking.file.container.map;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: csx
 * @Date: 2022/4/8 19:54
 * @Description:
 */
public class SpringDetector {
    public static <T extends Groundhog, prediction> void detectSpring(Class<T> type)
            throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException,
            IllegalArgumentException, InvocationTargetException {
        Constructor<T> ghog = type.getConstructor(int.class);
        Map<Groundhog, prediction> map = new HashMap<Groundhog, prediction>();
        for (int i = 0; i < 10; i++) {
            map.put(ghog.newInstance(i), (prediction) new com.cui.stu.thinking.file.container.map.prediction());
        }
        System.out.println("map = " + map);
        Groundhog gh = ghog.newInstance(3);
        System.out.println("Looking up prediction for " + gh);
        if (map.containsKey(gh)) {
            System.out.println(map.get(gh));
        } else {
            System.out.println("Key not found: " + gh);
        }
    }

    public static void main(String[] args) throws NoSuchMethodException, SecurityException, InstantiationException,
            IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        detectSpring(Groundhog.class);
    }

}
