package com.cui.stu.thinking.file.iofile;

import java.io.*;

/**
 * @Auther: 节点流
 * @Date: 2022/4/3 16:00
 * @Description:
 */
public class TestCope2 {
    public static void main(String[] args) throws IOException {
        //1.创建输入流和输出流
        File file1 = new File("d:/ssl/abc/readme.txt");
        File file2 = new File("d:/ssl/abc/readme2.txt");
        Reader fis = new FileReader(file1);
        Writer fos = new FileWriter(file2);

        //2.使用输入流和输出流复制文件
        char[] cbuf = new char[1024];
        int len = fis.read(cbuf);
        while (len !=-1){
            fos.write(cbuf,0,len);
            len = fis.read(cbuf);
        }


        //3.完毕输入流和输出流
        fis.close();
        fos.close();
    }
}
