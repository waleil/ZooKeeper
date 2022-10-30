package com.huawei.strategy;

/**
 * @Auther: csx
 * @Date: 2022/3/9 21:01
 * @Description:
 */
public class DataSource {
    public static void sot(Comparabl[] a){
        for (int i=a.length;i>0;i--){
            for (int j=0; j<i-1;j++){
                Comparabl o1 = a[j];
                Comparabl o2 = a[j+1];
                if (o1.compareto(o2)==1){
                    swap(a,j,j+1);
                }
            }
        }

    }

    private static void swap(Object[] a, int x, int y) {
        Object temp = a[x];
        a[x] = a[y];
        a[y] = temp;
    }


    public static void sot(int[] a) {
        for (int i=a.length;i>0;i--){
            for (int j=0; j<i-1;j++){
                if (a[j]>a[j+1]){
                    swap(a,j,j+1);
                }
            }
        }
    }

    private static void swap(int[] a, int x, int y) {
        int temp = a[x];
        a[x] = a[y];
        a[y] = temp;
    }

    public static void P(Object[] a) {
        for (int i=0;i<a.length;i++){
            System.out.print(a[i]+" ");
        }
    }
}
