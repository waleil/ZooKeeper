package com.cui.stu.thinking.file.container.map;

import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * @Auther: csx
 * @Date: 2022/4/8 18:59
 * @Description:
 */
public class sortedMap {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        SortedMap<String,String> map = null;
        map = new TreeMap<String,String>();
        map.put("D","xxxxxd");
        map.put("A", "xxxxaaa");
        map.put("B","xxxxxb");
        map.put("C", "xxxxxccc");
        System.out.print("第一个元素：" + map.firstKey());
        System.out.println("，对应的内容" + map.get(map.firstKey()));

        System.out.print("最后一个个元素：" + map.lastKey());
        System.out.println("，对应的内容" + map.get(map.lastKey()));

        System.out.println("返回小于指定内容的集合：");
        for(Map.Entry<String, String> me:map.headMap("B").entrySet() ){
            System.out.println("\t| - " + me.getKey() + "-->" + me.getValue());
        }


        System.out.println("返回大于指定内容的集合：");
        for(Map.Entry<String, String> me:map.tailMap("B").entrySet() ){
            System.out.println("\t| - " + me.getKey() + "-->" + me.getValue());
        }

        System.out.println("部分集合：");
        for(Map.Entry<String, String> me:map.subMap("A","C").entrySet() ){
            System.out.println("\t| - " + me.getKey() + "-->" + me.getValue());
        }

    }
}
