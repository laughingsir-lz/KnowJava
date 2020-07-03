package com.lz.xml;

import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;


/**
 * @ClassName DOMTest2
 * @Description: 测试类
 * @Author: zzz
 **/
public class DOMTest2 {
    @Test
    public void testTransForm() throws Exception {
        Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse("test\\com\\lz\\xml\\user.xml");
        Element root = doc.getDocumentElement();
        Element linkman = doc.createElement("linkman");
        Element name = doc.createElement("name");
        Element email = doc.createElement("email");
        Element address = doc.createElement("address");
        Element group = doc.createElement("group");
        name.setTextContent("xxx");
        email.setTextContent("xxx@qq.com");
        address.setTextContent("xxx街道");
        group.setTextContent("java");
        linkman.appendChild(name);
        linkman.appendChild(email);
        linkman.appendChild(address);
        linkman.appendChild(group);
        root.appendChild(linkman);
        //同步
        TransformerFactory.newInstance().newTransformer().transform(new DOMSource(doc),new StreamResult("test\\com\\lz\\xml\\user3.xml"));

    }
}
