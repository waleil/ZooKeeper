package org.example.service;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.core.type.AnnotationMetadata;

import java.util.Properties;

/**
 * @Auther: csx
 * @Date: 2021/12/22 22:16
 * @Description:
 */
public class CustomeImportSelector implements ImportSelector {

    //表达式  aspectj
    private  String expression;

   //默认构造函数，用于读取配置文件，给表达式赋值
    public CustomeImportSelector(){
        try {
            //1.获取properties对象
            Properties properties = PropertiesLoaderUtils.loadAllProperties("customerimport.properties");
            //2.给exception赋值
            expression = properties.getProperty("customc.importselector.expression");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * 实现获取要导入类的字节码
     * 需求
     *    导入的过滤规则TypeFilter的aspectj表达式的方式
     */
    @Override
    public String[] selectImports(AnnotationMetadata annotationMetadata) {
        return new String[0];
    }
}
