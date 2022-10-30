package com.cui.stu.thinking.file.iofile;

import java.io.*;

/**
 * @Auther: 处理流
 * @Date: 2022/4/3 16:10
 * @Description:
 */
public class TestCopy3 {
    public static void main(String[] args) throws IOException {
        //1.创建输入流和输出流
        File file1 = new File("d:/ssl/abc/readme.txt");
        File file2 = new File("d:/ssl/abc/readme2.txt");
        BufferedReader fis = new BufferedReader(new FileReader(file1));
        BufferedWriter fos = new BufferedWriter(new FileWriter(file2));
       // BufferedWriter fos = new BufferedWriter(new FileWriter(file2));

        //2.使用输入流和输出流复制文件

        String s;
        while ((s=fis.readLine())!=null){
            fos.write(s);
            fos.newLine();
        }


        //3.完毕输入流和输出流
        fis.close();
        fos.close();
    }
}
