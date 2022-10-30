package com.cui.stu.thinking.file.iofile;

import java.io.*;

/**
 * @Auther: csx
 * @Date: 2022/4/3 20:41
 * @Description:
 */
public class TestOther3 {
    public static void main(String[] args) throws FileNotFoundException {
        ByteArrayInputStream bais;  //数据源是一个字节数组
        ByteArrayOutputStream baos;  // 目的地是一个字节数组
        CharArrayReader bar;   // 节点流
        CharArrayWriter baw;   // 节点流
        byte[] buf = new byte[1024];
        DataInputStream dis = new DataInputStream(new BufferedInputStream(new ByteArrayInputStream(buf)));
        DataInputStream dis2 = new DataInputStream(new BufferedInputStream(new FileInputStream("d:/ssl/abc/readmeJDK1.txt")));

        //节点流的父类：InputStream
        //处理流的父类：FilterInputStream extends InputStream
    }
}
