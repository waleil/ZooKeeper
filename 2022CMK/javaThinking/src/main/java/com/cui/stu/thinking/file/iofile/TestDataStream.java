package com.cui.stu.thinking.file.iofile;

import java.io.*;

/**数据流之基本类型
 * 数据流：解决将各种基本数据类型和引用数据类型方便的写入到文件中并方便的读取出来
 */
public class TestDataStream {
    public static void main(String[] args) {
        try {
            resd();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void resd() throws IOException {
        //创建一个输入流
        InputStream fos = new FileInputStream("d:/ssl/abc/readme.txt");
        DataInputStream dis = new DataInputStream(fos);
        //使用输入流读基本数据类型和字符串
        System.out.println(dis.readInt());
        System.out.println(dis.readDouble());
        System.out.println(dis.readChar());
        System.out.println(dis.readUTF());
        //关闭输入流
        dis.close();
    }
    public static void write() throws IOException {
        //创建一个输出流
        OutputStream fis = new FileOutputStream("d:/ssl/abc/readme.txt");  //节点流
        BufferedOutputStream bos = new BufferedOutputStream(fis); //处理流，提高速度
        DataOutputStream dos = new DataOutputStream(bos);

        //使用输出流写基本数据类型和字符
        dos.writeInt(10);
        dos.writeDouble(3.14);
        dos.writeChar('A');
        dos.writeUTF("北京尚学堂");

        dos.close();
    }
}
