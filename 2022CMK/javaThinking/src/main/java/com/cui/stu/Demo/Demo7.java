package com.cui.stu.Demo;

import java.util.*;

/**
 * @Auther: csx
 * @Date: 2022/6/12 22:28
 * @Description:
 */
public class Demo7 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] sp = in.nextLine().split("\\s+");
        final int h = Integer.parseInt(sp[0]);
        String[] split = in.nextLine().split("\\s+");
        List<Integer> list = new ArrayList<>();
        for (String s : split) {
            list.add(Integer.parseInt(s));
        }
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                int d1 = h - o1;
                int d2 = h - o2;
                if ((d1 > 0 ? d1 : -d1) == (d2 > 0 ? d2 : -d2)) {
                    return o1 - o2;
                } else {
                    return (d1 > 0 ? d1 : -d1) - (d2 > 0 ? d2 : -d2);
                }

            }
        });
        StringBuilder builder = new StringBuilder();
        for (Integer integer:list) {
            builder.append(integer).append(" ");
        }
        System.out.println(builder.toString().trim());
        in.close();
    }
}
