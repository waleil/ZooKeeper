package com.stu.conf;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Auther: csx
 * @Date: 2022/2/11 21:53
 * @Description:
 */
 @Resource
public class WindowsCondition implements Condition {
    @Override  //是否注入到容器的核心方法
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        //1.获取IOC使用的BeanFactory对象
        ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();
        //2.获取类加载信息
        ClassLoader classLoader = context.getClassLoader();
        //3.获取环境信息，为了取出当前操作系统是windows还是linux
        Environment environment = context.getEnvironment();

        //4.获取bean定义信息的注册器
        BeanDefinitionRegistry registry = context.getRegistry();
        //5.获取当前系统的名称
        String osName = environment.getProperty("os.name");

        //6.判断是否包含windows规则
        if(osName.contains("windows")){
            return true;
        }
        return false;
    }
}
