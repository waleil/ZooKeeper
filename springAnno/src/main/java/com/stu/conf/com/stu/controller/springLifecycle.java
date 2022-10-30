package com.stu.conf.com.stu.controller;

import com.stu.conf.JdbcConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Auther: csx
 * @Date: 2022/2/18 20:25
 * @Description:
 */
public class springLifecycle {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(JdbcConfig.class);
        ac.close();
    }
}
