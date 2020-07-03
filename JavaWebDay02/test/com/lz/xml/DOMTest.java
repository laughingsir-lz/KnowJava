package com.lz.xml;

import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

/**
 * @ClassName DOMTest
 * @Description: dom树对象读取测试类
 * @Author: zzz
 **/
public class DOMTest {
    /**
     * 读取Document对象测试
     * @throws Exception
     */
    @Test
    public void testGetDocument() throws Exception {
        //1 获取文件file
        File file = new File("test\\com\\lz\\xml\\user.xml");
        //2 获取DocumentBuilderFactory对象
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        //3 获取DocumentBuilder对象
        DocumentBuilder builder = factory.newDocumentBuilder();
        //获取Document对象
        Document document = builder.parse(file);
        //打印出null 对象的确存在，但是它的toString()方法输出null
        System.out.println(document);
    }
    /**
     * 读取XMl中具体name标签的内容
     * @throws Exception
     */
    @Test
    public void testGetName() throws Exception {
        //1 获取文档对象
        //1 获取文件file
        File file = new File("test\\com\\lz\\xml\\user.xml");
        //2 获取DocumentBuilderFactory对象
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        //3 获取DocumentBuilder对象
        DocumentBuilder builder = factory.newDocumentBuilder();
        //获取Document对象
        Document document = builder.parse(file);
        //2 获取根标签 （根元素）
        Element root = document.getDocumentElement();
        //3 获取第二个linkman子元素
        //NodeList nodeList = root.getElementsByTagName("linkman");
        //Element linkmanE1 = (Element)nodeList.item(1);
        Element linkmanE1 = (Element) root.getElementsByTagName("linkman").item(1);
        System.out.println(linkmanE1.getAttribute("id"));
        //4 获取name子元素
        Element name = (Element) linkmanE1.getElementsByTagName("name").item(0);
        //5 获取name文本内容
        System.out.println(name.getTextContent());
    }

    /**
     * 测试插入一个元素
     * @throws Exception
     */
    @Test
    public void testCreateLinkman() throws Exception {
        //获取dom对象
        Document parse = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse("test\\com\\lz\\xml\\user.xml");
        //获取根元素
        Element root = parse.getDocumentElement();
        //创建元素
        Element linkman = parse.createElement("linkman");
        Element name = parse.createElement("name");
        Element email = parse.createElement("email");
        Element address = parse.createElement("address");
        Element group = parse.createElement("group");
        //为元素添加文本
        name.setTextContent("小王子");
        name.setAttribute("id","4");
        name.setAttribute("color","black");
        email.setTextContent("xiaowangzi@qq.com");
        address.setTextContent("xxx街道");
        group.setTextContent("java");
        //将节点添加到linkman下
        linkman.appendChild(name);
        linkman.appendChild(email);
        linkman.appendChild(address);
        linkman.appendChild(group);
        //添加到根节点下
        root.appendChild(linkman);
        //同步操作  把内存中dom树对象写入磁盘
        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.transform(new DOMSource(parse),new StreamResult("test\\com\\lz\\xml\\user2.xml"));
    }
}
