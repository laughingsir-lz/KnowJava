import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;

/**
 * @ClassName DocumentDemo2
 * @Description: xml读取练习 获取指定address
 * @Author: zzz
 **/
public class DocumentDemo2 {
    public static void main(String[] args) throws Exception {
        //获取文件
        File file = new File("Resource\\info.xml");
        //获取doc对象
        Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(file);
        //获取根节点
        Element root = doc.getDocumentElement();
        //获取索引为2的linkman 标签
        Element linkman = (Element) root.getElementsByTagName("linkman").item(2);
        //获取指定address标签
        Element address = (Element) linkman.getElementsByTagName("address").item(0);
        //获取指定标签的文本内容
        System.out.println(address.getTextContent());
    }
}
