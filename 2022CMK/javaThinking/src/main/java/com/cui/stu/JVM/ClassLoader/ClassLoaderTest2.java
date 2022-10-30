package com.cui.stu.JVM.ClassLoader;

/**
 * @Auther: csx
 * @Date: 2022/6/9 22:04
 * @Description:
 */
public class ClassLoaderTest2 {
    public static void main(String[] args) throws ClassNotFoundException {
        ClassLoader classLoader = Class.forName("java.lang.String").getClassLoader();
        System.out.println(classLoader);
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        System.out.println(contextClassLoader);

        ClassLoader parent = ClassLoader.getSystemClassLoader().getParent();
        System.out.println(parent);
    }
}
