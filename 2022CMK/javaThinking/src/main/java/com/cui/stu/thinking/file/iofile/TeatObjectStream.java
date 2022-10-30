package com.cui.stu.thinking.file.iofile;

import java.io.*;
import java.util.Date;

/**
 * @Auther: 数据流之对象流
 * @Date: 2022/4/3 18:15
 * @Description:
 */
public class TeatObjectStream {
    public static void main(String[] args) {
        try {
            //write();
            resd();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void resd() throws Exception {
        //创建一个输入流
        InputStream fos = new FileInputStream("d:/ssl/abc/readme.txt");
        ObjectInputStream ois = new ObjectInputStream(fos);
        //使用输入流读基本数据类型和字符串
        System.out.println(ois.readInt());
        System.out.println(ois.readDouble());
        System.out.println(ois.readChar());
        System.out.println(ois.readUTF());
        Date date = (Date) ois.readObject();
        System.out.println(date);
        //关闭输入流
        ois.close();
    }
    public static void write() throws IOException {
        //创建一个输出流
        OutputStream fis = new FileOutputStream("d:/ssl/abc/readme.txt");  //节点流
        BufferedOutputStream bos = new BufferedOutputStream(fis); //处理流，提高速度
        ObjectOutputStream oos = new ObjectOutputStream(bos);

        //使用输出流写基本数据类型和字符
        oos.writeInt(10);
        oos.writeDouble(3.14);
        oos.writeChar('A');
        oos.writeUTF("北京尚学堂");
        oos.writeObject(new Date());

        oos.close();
    }
}
