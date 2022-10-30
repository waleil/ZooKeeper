package com.cui.stu.thinking.file.iofile;

import java.io.*;
import java.util.Scanner;

/**
 * @Auther: csx
 * @Date: 2022/4/3 20:26
 * InputStreamReader   InputStream --->Reader
 * OutputStreamWriter  OutputStream--->Writer
 */
public class TestOther2 {
    public static void main(String[] args) throws Exception {
        //创建输入流和输出流
        InputStream is = System.in;
        //BufferedReader br = new BufferedReader(new FileReader("d:/ssl/abc/readmeJDK.txt"));
        Reader reader = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(reader);

        Scanner input = new Scanner(System.in);
        //BufferedWriter bw = new BufferedWriter(new FileWriter("d:/ssl/abc/readmeJDK1.txt"));
        PrintWriter pw = new PrintWriter("d:/ssl/abc/readmeJDK1.txt");
        //使输入流和输出流复制文件
        String str = br.readLine();
        while(!str.equals("bye")){
            pw.println(str);
            str = br.readLine();
        }
        pw.close();
    }
}
