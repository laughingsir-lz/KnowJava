package com.lz.xml;

import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;


/**
 * @ClassName UserInfoTest
 * @Description: usernfo读取测试类
 * @Author: zzz
 **/
public class UserInfoTest {

    //1 获取文件file
    File file = new File("test\\com\\lz\\xml\\userInfo.xml");

    /**
     * info.xml读取测试
     * @throws Exception
     */
    @Test
    public void testGetInfo() throws Exception {
        //得到xml的dom对象
        Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(file);
        //获取根节点 根元素
        Element root = doc.getDocumentElement();
        System.out.println(root);
        //getTextContent() 会得到当前标签后的包括子标签内的文本
       // System.out.println(root.getTextContent());
        //getElementsByTagName("user") 返回当前指定标签的的所有节点 生成NodeList
        NodeList userList = root.getElementsByTagName("user");
        //返回节点集合的长度
        System.out.println(userList.getLength());
        //item(1) 返回指定索引位的节点
        System.out.println(userList.item(1).getTextContent());
        //返回节点名称
        System.out.println(userList.item(1).getNodeName());
        //返回父节点
        System.out.println(userList.item(1).getParentNode());
        //System.out.println(userList.item(1).getUserData("user"));
        System.out.println(userList.item(1).getNodeValue());
        //这些都是Node 类型的对象
        Node node = userList.item(1);
        //强转为标签/元素类型  按照标签处理
        Element item = (Element) userList.item(1);
        System.out.println(item.getAttribute("id"));
        System.out.println(item.getAttribute("color"));
        Element name = (Element) item.getElementsByTagName("name").item(0);
        Element age = (Element) item.getElementsByTagName("age").item(0);
        System.out.println(name.getTextContent());
        System.out.println(age.getTextContent());
    }

}
