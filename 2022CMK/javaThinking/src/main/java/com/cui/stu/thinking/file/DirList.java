package com.cui.stu.thinking.file;

import java.io.File;
import java.util.Arrays;

/**
 * @Auther: csx
 * @Date: 2022/3/29 22:43
 * @Description:
 */
public class DirList {
    public static void main(String[] args){
        File path=new File("D:\\CMK\\client\\src\\main\\java\\com\\huawei\\controller");
        String[] list ;
        if(args.length==0){
            list=path.list();
        }else{
            list=path.list(new DirFilter(args[0]));
        }
        Arrays.sort(list,String.CASE_INSENSITIVE_ORDER);
        for(String dirItem:list){
            System.out.println(dirItem);
        }
    }
}
