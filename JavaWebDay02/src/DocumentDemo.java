import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;

/**
 * @ClassName DocumentDemo
 * @Description:
 * @Author: zzz
 **/
public class DocumentDemo {
    public static void main(String[] args) throws Exception {
        //创建xml文件
        File file = new File("Resource\\info.xml");
        //获取工厂对象
        DocumentBuilderFactory factory =DocumentBuilderFactory.newInstance();
        //DocumentBuilder 创建实例
        DocumentBuilder builder = factory.newDocumentBuilder();
        //解析xml 生成dom树
        Document doc = builder.parse(file);
        System.out.println(doc);
        //根元素
        Element root = doc.getDocumentElement();
        //
        Node linkmanE1 =  root.getElementsByTagName("linkman").item(2);
        System.out.println( linkmanE1.getAttributes().item(0));
    }
}
