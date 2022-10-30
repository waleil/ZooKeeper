package com.cui.stu.thinking.file.dom4j;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.util.List;

/**
 * @Auther: csx
 * @Date: 2022/3/30 22:09
 * @Description:
 */
public class userxml {
    public static void main(String[] args) throws Exception {
        //创建解析器对象
        SAXReader saxReader = new SAXReader();
        //使用解析器对象读取xml文档生产document
        Document document = saxReader.read(userxml.class.getClassLoader().getResource("user.xml"));
        //根据Document对象获取xml的元素（标签）信息
        Element rootElement = document.getRootElement();
        System.out.println("获取根节点的名字"+rootElement.getName());

        System.out.println("---获取根标签的子标签列表");
        List<Element> elements = rootElement.elements();
        for (Element element:elements){
            System.out.println("users标签子标签名称"+element.getName());
            System.out.println("users标签子标签id属性值"+element.attributeValue("id"));
            System.out.println("users标签子标签country属性值"+element.attributeValue("country"));
            System.out.println("-----获取user的子标签列表");
            List<Element> userSubElementList = element.elements();
            for (Element userSubElement:userSubElementList){
                System.out.println("user标签下的子标签名字"+userSubElement.getName());
                System.out.println("user标签下的子标签的文本"+userSubElement.getText());
                //System.out.println("user标签下的子标签的属性值"+userSubElement.attributeValue("name"));
            }

        }
    }
}
