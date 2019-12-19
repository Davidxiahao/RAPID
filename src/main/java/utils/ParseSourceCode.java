package utils;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.util.HashMap;
import java.util.Map;

public class ParseSourceCode {
    public static Map<String, LifeCycle> getMethodLifeCycle(){
        Map<String, LifeCycle> result = new HashMap<>();

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = null;
        Document document = null;
        try {
            builder = factory.newDocumentBuilder();
            document = builder.parse("resources/api-version.xml");
        }catch (Exception e){
            e.printStackTrace();
        }

        if (document != null){
            NodeList classList = document.getElementsByTagName("class");

        }
        return null;
    }
}
