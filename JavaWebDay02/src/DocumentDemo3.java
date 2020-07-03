import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;

/**
 * @ClassName DocumentDemo3
 * @Description:
 * @Author: zzz
 **/
public class DocumentDemo3 {
    public static void main(String[] args) throws Exception {
        Document document= DocumentBuilderFactory.newInstance().newDocumentBuilder().parse("Resource\\info.xml");
        Element linkman = (Element) document.getDocumentElement().getElementsByTagName("linkman").item(2);
        System.out.println(linkman.getElementsByTagName("email").item(0).getTextContent());
    }

}
