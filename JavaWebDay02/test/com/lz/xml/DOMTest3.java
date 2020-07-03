package com.lz.xml;

import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

/**
 * @ClassName DOMTest3
 * @Description:
 * @Author: zzz
 **/
public class DOMTest3 {
    @Test
    public void testTransFrom() throws Exception {
        Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse("test\\com\\lz\\xml\\user3.xml");
        Element root = doc.getDocumentElement();
        NodeList linkmans = root.getElementsByTagName("linkman");
        System.out.println(linkmans.getLength());
        for (int i = 0; i <linkmans.getLength() ; i++) {
            root.removeChild(linkmans.item(0));
        }
        Element linkman = doc.createElement("linkman");
        Element name = doc.createElement("name");
        Element email = doc.createElement("email");
        Element address = doc.createElement("address");
        Element group = doc.createElement("group");
        name.setTextContent("zzz");
        email.setTextContent("zzz@qq.com");
        address.setTextContent("zzz街道");
        group.setTextContent("java");
        linkman.appendChild(name);
        linkman.appendChild(email);
        linkman.appendChild(address);
        linkman.appendChild(group);
        root.appendChild(linkman);
        //同步
        TransformerFactory.newInstance().newTransformer().transform(new DOMSource(doc),new StreamResult("test\\com\\lz\\xml\\user5.xml"));
    }
}
