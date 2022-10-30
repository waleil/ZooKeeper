package com.stu.com.DataStructures.sparsearray;

/**
 * @Auther: csx
 * @Date: 2022/4/12 22:54
 * @Description:
 */
public class SparseArray {
    public static void main(String[] args) {
        //创建一个二维数组
        int[][] chessArr1 = new int[11][11];
        chessArr1[1][2] = 1;
        chessArr1[2][3] = 2;
        System.out.println("输出原始数组");
        for (int[] arr : chessArr1){
            for (int data:arr){
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }

        //遍历二维数组获取非0总数
        int sum=0;
        for (int i=0;i<chessArr1.length;i++){
            for (int j=0;j<chessArr1.length;j++){
                if (chessArr1[i][j]!=0){
                    sum++;
                }
            }
        }
        System.out.println(sum);

        //创建稀疏数组
        int sparseArr[][] = new int[sum+1][3];
        sparseArr[0][0]=11;
        sparseArr[0][1]=11;
        sparseArr[0][2]=sum;
        //遍历数组
        int count =0;
        for (int i=0;i<chessArr1.length;i++){
            for (int j=0;j<chessArr1.length;j++){
                if (chessArr1[i][j]!=0){
                    count++;
                    sparseArr[count][0]=i;
                    sparseArr[count][1]=j;
                    sparseArr[count][2]=chessArr1[i][j];
                }
            }
        }
        System.out.println("得到稀疏数组为。。。。。");
        for (int i=0;i<sparseArr.length;i++){
            System.out.printf("%d\t%d\t%d\t\n",sparseArr[i][0],sparseArr[i][1],sparseArr[i][2]);
        }
        System.out.println();
        //将稀疏数组恢复为二维数组
        int chessArr2[][] = new int[sparseArr[0][0]][sparseArr[0][1]];
        for (int i=1;i<sparseArr.length;i++){
            chessArr2[sparseArr[i][0]][sparseArr[i][1]]=sparseArr[i][2];
        }
        System.out.println("输出原始数组");
        for (int[] arr : chessArr2){
            for (int data:arr){
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }
    }

}
