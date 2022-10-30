package com.cui.stu.JVM.ClassLoader;

import java.io.FileNotFoundException;

/**
 * @Auther: csx
 * @Date: 2022/6/8 22:48
 * @Description:
 */
public class CustomClassLoader extends ClassLoader{
    protected Class<?> findClass(String name) throws ClassNotFoundException{
        try {
            byte[] result = getClassFromCustomPath(name);
            if (result ==null){
                throw new FileNotFoundException();
            }else {
                return defineClass(name,result,0,result.length);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        throw  new ClassNotFoundException(name);
    }

    private byte[] getClassFromCustomPath(String name) {
        return null;
    }

    public static void main(String[] args) {
        CustomClassLoader customClassLoader = new CustomClassLoader();
        try {
            Class<?> clazz = Class.forName("One",true,customClassLoader);
            Object obj = clazz.newInstance();
            System.out.println(obj.getClass().getClassLoader());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }
}
