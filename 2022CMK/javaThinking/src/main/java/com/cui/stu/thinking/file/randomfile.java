package com.cui.stu.thinking.file;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.RandomAccess;

/**
 * @Auther: csx
 * @Date: 2022/4/6 20:04
 * @Description:
 */
public class randomfile {
    static String file = "rtest.dat";

    public static void main(String[] args) throws IOException {
        RandomAccessFile rf = new RandomAccessFile(file, "rw");
        for (int i = 0; i < 7; i++) {
            rf.writeDouble(i * 1.414);
        }
        rf.writeUTF("the end of the file");
        rf.close();
        display();
        rf = new RandomAccessFile(file, "rw");
        rf.seek(5 * 8);
        rf.writeDouble(47.001);
        rf.close();
        display();

    }

    static void display() throws IOException {
        RandomAccessFile rf = new RandomAccessFile(file, "r");
        for (int i = 0; i < 7; i++) {
            System.out.println("value" + i + rf.readDouble());
        }
        System.out.println(rf.readUTF());
        rf.close();

    }
}
