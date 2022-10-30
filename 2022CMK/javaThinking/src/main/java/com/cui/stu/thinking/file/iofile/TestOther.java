package com.cui.stu.thinking.file.iofile;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.io.PrintWriter;

/**
 *打印流：只有输出流 没有输入流
 */
public class TestOther {
    public static void main(String[] args) throws FileNotFoundException {
        //PrintStream ps = System.out;
        PrintStream ps = new PrintStream("d:/ssl/abc/readme.txt");
        PrintWriter pw;
        //ps.println("hello");
        ps.println("hello.java");
    }
}
