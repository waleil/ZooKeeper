package com.cui.stu.thinking.file;

import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Pattern;

/**
 * @Auther: csx
 * @Date: 2022/3/29 22:43
 * @Description:
 */
public class DirFilter implements FilenameFilter {
    private static Pattern pattern;

    public DirFilter(String regex){
        pattern=Pattern.compile(regex);
    }

    @Override
    public boolean accept(File dir, String name) {
        return  pattern.matcher(name).matches();
    }
}
