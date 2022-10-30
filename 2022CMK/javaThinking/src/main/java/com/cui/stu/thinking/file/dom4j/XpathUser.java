package com.cui.stu.thinking.file.dom4j;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

/**
 * @Auther: csx
 * @Date: 2022/3/30 22:44
 * @Description:
 */
public class XpathUser {
    public static void main(String[] args) throws DocumentException {
        //创建解析器对象
        SAXReader saxReader = new SAXReader();
        //使用解析器对象读取xml文档生产document
        Document document = saxReader.read(XpathUser.class.getClassLoader().getResource("user.xml"));
        //第一个用户的密码
        Element element = (Element)document.selectSingleNode("/users/user/password");
        System.out.println(element.getText());
    }
}
