package com.cui.stu.Demo;

import java.util.*;

/**
 * @Auther: csx
 * @Date: 2022/6/15 19:39
 * @Description:
 */
public class Demo17 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] sp = in.nextLine().split("");
        int k = Integer.parseInt(in.nextLine());
        Map<String,Integer> map = new HashMap<>();
        String tail = sp[0];
        int count = 1;
        map.put(tail, count);
        for (int i = 0; i < sp.length; i++) {
            if (tail.equals(sp[i])){
                count++;
            }else {
                tail = sp[i];
                count=1;
            }
            map.put(tail, map.containsKey(tail)?map.get(tail)>count?map.get(tail):count:count);
        }

        List<String>  list = new ArrayList<>();
        for (Map.Entry m : map.entrySet()){
            list.add(m.getKey()+"-"+m.getValue());
        }
        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {

                return (o2.split("-")[1].compareTo(o1.split("-")[1]));
            }
        });
        if (k>list.size()){
            System.out.println(-1);
        }else {
            System.out.println(list.get(k-1).split("-")[1]);
        }
        in.close();
    }
}
