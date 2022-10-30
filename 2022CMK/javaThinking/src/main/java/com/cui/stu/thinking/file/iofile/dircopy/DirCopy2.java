package com.cui.stu.thinking.file.iofile.dircopy;

import java.io.*;

/**
 * @Auther: csx
 * @Date: 2022/4/3 21:59
 * @Description:
 */
public class DirCopy2 {
    public static void main(String[] args) throws IOException {
        copyDir("d:/ssl/abc", "d:/ssl/aaa");
    }

    public static void copyDir(String sourceDir,String desDir) throws IOException {
        //源文件夹必须存在
        File dir1 = new File(sourceDir);
        if (!dir1.exists()){
            System.err.println("源文件夹不存在"+sourceDir);
            return;
        }

        //目的文件夹要创建
        File dir2 = new File(desDir);
        if (!dir2.exists()){
            dir2.mkdirs();
        }
        //获取元文件夹下所有的文件和子文件夹
        File[] files = dir1.listFiles();
        for (File file : files){
            //如果是文件就复制
            if (file.isFile()){
                copyFile(sourceDir+"/"+file.getName(), desDir+"/"+file.getName());
            }
            if (file.isDirectory()){
                copyDir(sourceDir+"/"+file.getName(),desDir+"/"+file.getName());
            }
        }

    }

    public static void copyFile(String sourceFile,String destFile) throws IOException {
        File file1 = new File(sourceFile);
        File file2 = new File(destFile);
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file1));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file2));
        byte[] buf = new byte[1024];
        int len;
        while ((len=bis.read(buf))!=-1){
            bos.write(buf, 0, len);
        }
        bis.close();
        bos.close();
    }
}
