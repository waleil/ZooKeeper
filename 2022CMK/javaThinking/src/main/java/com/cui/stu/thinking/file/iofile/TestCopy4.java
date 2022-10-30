package com.cui.stu.thinking.file.iofile;

import java.io.*;

/**
 * @Auther: 处理流
 * @Date: 2022/4/3 16:54
 *使用缓冲流可以提高读写的速度
 * 关闭高层流即可，关闭层流也是关闭底层流
 */
public class TestCopy4 {
    public static void main(String[] args) throws IOException {
        //1.创建输入流和输出流
        File file1 = new File("d:/ssl/abc/readme.txt");
        File file2 = new File("d:/ssl/abc/readme2.txt");
        InputStream fis = new FileInputStream(file1);
        OutputStream fos = new FileOutputStream(file2);
        BufferedInputStream bis = new BufferedInputStream(fis);
        BufferedOutputStream bos = new BufferedOutputStream(fos);

        //2.使用输入流和输出流完成文件复制
        byte[] buf = new byte[1024];//定义一个中转站,是一个字节数组
        //先读内容到一个字节数组
        int len = bis.read(buf);//读文件的内容放到字节数组中，返回读取的字节数
        while ((len = bis.read(buf)) !=-1) { //是否读到结尾
            // fos.write(buf);//写一个字节
            bos.write(buf,0,len );
        }

        //3.完毕输入流和输出流
        bis.close();
        bos.close();
    }
}
