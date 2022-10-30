package com.cui.stu.thinking.file.dom4j;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

/**
 * @Auther: csx
 * @Date: 2022/3/30 20:50
 * @Description:
 */
public class xml {
    public static void main(String[] args) throws Exception {
        //xml 文件转换document
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();//1.先生产一个document工厂
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();//2.通过工厂生成documentBuilder
        Document document = documentBuilder.parse("user.xml");//3.通过documentBuilder生产document到挂数
        NodeList nodeList = document.getElementsByTagName("Brand");
        for (int i=0;i<nodeList.getLength();i++){
            Node item = nodeList.item(i);
            Element element = (Element) item;//强转为标签
            System.out.println(element.getAttribute("name"));
            NodeList childNodes = item.getChildNodes();
            for (int j=0;j<childNodes.getLength();j++){
                Node child = childNodes.item(j);
                if (child.getNodeType()==Node.ELEMENT_NODE) {
                    Element childElement = (Element) child;
                    System.out.println(childElement.getAttribute("name"));
                }
            }
        }
        //创建一个节点
        Element elementBrand=document.createElement("Brand");
        elementBrand.setAttribute("name", "小米");
        Element elementType = document.createElement("Type");
        elementType.setAttribute("name", "mi10");
        elementBrand.appendChild(elementType);

        Node phoneInfo = document.getElementsByTagName("PhoneInfo").item(0);
        phoneInfo.appendChild(elementBrand);

        //删除一个节点
        for (int i=0;i<nodeList.getLength();i++) {
            Node item = nodeList.item(i);
            Element element = (Element) item;//强转为标签
            if (element.getAttribute("name").equals("华为")){
                //先取父节点PhoneInfo.在删除自己
                element.getParentNode().removeChild(element);
            }
        }
        //修改
        for (int i=0;i<nodeList.getLength();i++) {
            Node item = nodeList.item(i);
            Element element = (Element) item;//强转为标签
            element.setAttribute("id", i+"");
        }
        //document 转换为xml文件
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        FileOutputStream fileOutputStream = new FileOutputStream("dom1.xml");
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);
        StreamResult streamResult = new StreamResult(outputStreamWriter);
        DOMSource source = new DOMSource(document);
        transformer.transform(source,streamResult);
    }
}
