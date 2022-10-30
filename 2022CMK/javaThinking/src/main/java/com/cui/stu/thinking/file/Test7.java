package com.cui.stu.thinking.file;

import java.io.*;
import java.util.LinkedList;
import java.util.ListIterator;

/**
 * @Auther: csx
 * @Date: 2022/4/1 22:16
 * @Description:
 */
public class Test7 {
    public static void main(String[] args) throws Exception {
        File f = new File("D:\\CMK\\2022CMK\\javaThinking\\src\\main\\java\\com\\cui\\stu\\thinking\\file\\Test7.java");
               //String filename = f.getName();
        BufferedReader br  = new BufferedReader(new FileReader(f));
        String s;
        LinkedList<String> ll = new LinkedList<String>();
        while((s=br.readLine())!=null) {
            ll.add(s);
        }
        br.close();//切记 用完之后需打开
        //倒着排序
        for(ListIterator<String> it =
            ll.listIterator(ll.size()); it.hasPrevious();)
            System.out.println(it.previous());
    }
}
