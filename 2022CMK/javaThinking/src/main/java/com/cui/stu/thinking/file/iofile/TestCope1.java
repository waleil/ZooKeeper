package com.cui.stu.thinking.file.iofile;

import java.io.*;

/**
 * @Auther: 节点流
 * @Date: 2022/4/3 15:20
 * @Description:
 */
public class TestCope1 {
    public static void main(String[] args) throws IOException {
        //1.创建输入流和输出流
        File file1 = new File("d:/ssl/abc/readme.txt");
        File file2 = new File("d:/ssl/abc/readme2.txt");
        InputStream fis = new FileInputStream(file1);
        OutputStream fos = new FileOutputStream(file2);

        //2.使用输入流和输出流完成文件复制
        byte[] buf = new byte[1024];//定义一个中转站,是一个字节数组
        //先读内容到一个字节数组
        int len = fis.read(buf);//读文件的内容放到字节数组中，返回读取的字节数
        while (len !=-1) { //是否读到结尾
           // fos.write(buf);//写一个字节
            fos.write(buf,0,len );
            len = fis.read(buf);
        }

        //3.完毕输入流和输出流
        fis.close();
        fos.close();

    }

}
