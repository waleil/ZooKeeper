package com.cui.stu.Demo;

import java.util.Scanner;

/**
 * @Auther: csx
 * @Date: 2022/6/11 21:58
 * @Description:
 */
public class demo1 {
    //        如果三个正整数A B C ,A²+B²=C²则为勾股数
    // 如果ABC之间两两互质，即A与B A与C B与C均互质没有公约数，
    // 则称其为勾股数元组。
//        请求出给定n m 范围内所有的勾股数元组
//        输入描述
//          起始范围 1<n<10000    n<m<10000
//        输出目描述
//           abc 保证a<b<c输出格式  a b c
//           多组勾股数元组 按照a升序b升序 c升序的排序方式输出。
//           给定范围内，找不到勾股数元组时，输出  Na

    // 案例
    //  输入
    //   1
    //   20
    //  输出
    //   3 4 5

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int count = 0;
        try {
            int n = s.nextInt();
            int m = s.nextInt();
            for (int i = n; i < m; i++) {
                for (int j = n + 1; j < m; j++) {
                    for (int k = n + 2; k < m; k++) {
                        if (i < j && j < k
                                && k * k == i * i + j * j
                                && huzhi(i, j) == 1
                                && huzhi(j, k) == 1
                                && huzhi(i, k) == 1) {
                            System.out.println(i + " " + j + " " + k);
                            count++;
                        }
                    }
                }
            }

        } finally {
            if (count == 0) {
                System.out.println("Na");
            }
            s.close();
        }
    }

    private static int huzhi(int a, int b) {
        if (a == 0 || b == 0) {
            return 1;
        }
        if (a % b == 0) {
            return b;
        } else {
            return huzhi(b, a % b);
        }
    }
}
