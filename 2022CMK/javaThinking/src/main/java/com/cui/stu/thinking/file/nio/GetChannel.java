package com.cui.stu.thinking.file.nio;

import com.sun.deploy.util.SyncFileAccess;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @Auther: csx
 * @Date: 2022/4/6 20:36
 * @Description:
 */
public class GetChannel {
    private static final int BSIZE = 1024;

    public static void main(String[] args) throws IOException {
        FileChannel fc = new FileOutputStream("D:\\ssl\\abc\\readme.txt").getChannel();
        fc.write(ByteBuffer.wrap("some text".getBytes()));
        fc.close();
        fc = new RandomAccessFile("D:\\ssl\\abc\\readme.txt", "rw").getChannel();
        fc.position(fc.size());
        fc.write(ByteBuffer.wrap("some more".getBytes()));
        fc.close();
        fc = new FileInputStream("D:\\ssl\\abc\\readme.txt").getChannel();
        ByteBuffer buff = ByteBuffer.allocate(BSIZE);
        fc.read(buff);
        buff.flip();
        while (buff.hasRemaining()){
            System.out.println((char)buff.get());
        }
    }
}
