package com.stu.com.algorithm;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;
import org.xml.sax.SAXException;


import java.io.File;


/**
 * @Auther: csx
 * @Date: 2022/4/25 21:51
 * @Description:
 */
public class xmlread {
    public static  void main(String[] args) throws Exception {
        File file = new File("d://pom.xml");
        SAXReader reader = new SAXReader();
        reader.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);
        Document document = reader.read(file);
    }




}
