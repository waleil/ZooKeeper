package com.cui.stu.DataStructures.sparsearray;

/**
 * @Auther: csx
 * @Date: 2022/5/7 19:38
 * @Description:
 */
public class SparseArray {
    public static void main(String[] args) {
        int[][] arr = new int[6][7];
        arr[0][3]  = 22;
        arr[0][6]  = 15;
        arr[1][1]  = 11;
        arr[1][5]  = 17;
        arr[2][3]  = -6;
        arr[3][5]  = 39;
        arr[4][0]  = 91;
        arr[5][2]  = 28;
        for (int[] a : arr){
            for (int data:a){
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }
        int sum = 0;
        for (int i=0;i<arr.length;i++){
            for (int j=0;j<arr[0].length;j++){
                if (arr[i][j] != 0){
                    sum ++;
                }
            }
        }
        int[][] sp = new int[sum+1][3];
        sp[0][0]=arr.length;
        sp[0][1]=arr[0].length;
        sp[0][2]=sum;
        int n = 1;
        for (int i=0;i<arr.length;i++){
            for (int j=0;j<arr[0].length;j++){
                if (arr[i][j] != 0){
                    sp[n][0] =i;
                    sp[n][1] = j;
                    sp[n][2] = arr[i][j];
                    n++;
                }
            }
        }
        for (int[] a : sp){
            for (int data:a){
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }

        //将其恢复成二维数组
        int[][] chessArr = new int[sp[0][0]][sp[0][1]];
        for (int i =1;i<sp.length;i++){
            chessArr[sp[i][0]][sp[i][1]] = sp[i][2];
        }
        System.out.println("输出原始数组");
        for (int[] a : chessArr){
            for (int data:a){
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }
    }
}
