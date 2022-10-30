package com.cui.stu.thinking.file.container.map;

import java.util.LinkedHashMap;

/**
 * @Auther: csx
 * @Date: 2022/4/8 19:09
 * @Description:
 */
public class LinkedHashMapDemo {
    public static void main(String[] args) {
//        LinkedHashMap<String,Integer> map = new LinkedHashMap<String,Integer>();
//        //保存数据
//        map.put("one", 1);
//        map.put("two", 2);
//        map.put("three", 3);
//        map.put("one", 8);      // key重复，数据覆盖
//        map.put(null, 0);       // key为null
//        map.put("zero", null);  // value为null
//        map.put("z", 9);  // value为null
//        map.put("o", 5);  // value为null
//        map.put("ro", 7);  // value为null
//
//        System.out.println(map);
//
//        System.out.println("===============================");
//
//        System.out.println(map.get("one"));     // key存在
//        System.out.println(map.get(null));      // key存在
//        System.out.println(map.get("zero"));    // key存在
//        System.out.println(map.get("ten"));     // key不存在，此时value返回null
//        System.out.println("===============================");

        /**
         *  小技巧：puf()方法发生覆盖前都可以返回原始的内容，
         *  这样就可以依据其返回结果来判断所设置的key是否存在。
         */
//        System.out.println(map.put("keyIsExist", 333));
//        System.out.println(map.put("keyIsExist", 666));

        LinkedHashMap<Integer,String> map = new LinkedHashMap<Integer,String>(16,0.75f,true);
        map.put(0,"A0");
        map.put(1,"B0");
        map.put(2,"C0");
        map.put(3,"D0");
        map.put(4,"E0");
        map.put(5,"F0");
        map.put(6,"G0");
        map.put(7,"H0");
        map.put(8,"I0");

        System.out.println(map);
        for (int i=0;i<6;i++){
            map.get(i);
        }
        System.out.println(map);
        map.get(0);
        System.out.println(map);

    }
}
