package com.cui.stu.thinking.file.iofile;

import java.io.File;
import java.io.IOException;

/**
 * File:获取文件和文件夹的属性
 * 对文件夹进行删除和新建
 * File不嫩对文件的内容进行操作，内容操作必须通过流
 */
public class TestFile2 {
    public static void main(String[] args) throws IOException {
        File file = new File("d:/ssl/abc/readme.txt");
        if (file.exists()){
            file.delete();
        }else {
            //获取上级文件夹
            File dir = file.getParentFile();
            if (!dir.exists()){
                dir.mkdirs();
            }
            file.createNewFile();
        }
    }
}
