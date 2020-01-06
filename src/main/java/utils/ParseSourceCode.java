package utils;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
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
            document = builder.parse("src/main/resources/api-versions.xml");
        }catch (Exception e){
            e.printStackTrace();
        }

        if (document != null){
            NodeList classList = document.getElementsByTagName("class");
            for (int i = 0; i < classList.getLength(); i++){
                Node classNode = classList.item(i);
                NamedNodeMap classMap = classNode.getAttributes();
                String className = "";
                for (int j = 0; j < classMap.getLength(); j++){
                    Node node = classMap.item(j);
                    if ("name".equals(node.getNodeName())){
                        className = node.getNodeValue();
                    }
                }
                className = className.replaceAll("/", ".");
                LifeCycle classLifeCycle = ParseExtendsClass.getLifeCycle(classMap);

                NodeList childList = classNode.getChildNodes();
                for (int j = 0; j < childList.getLength(); j++){
                    Node childNode = childList.item(j);
                    if (childNode.getAttributes() == null){
                        continue;
                    }
                    if (!"method".equals(childNode.getNodeName())){
                        continue;
                    }
                    NamedNodeMap childMap = childNode.getAttributes();
                    LifeCycle methodLifeCycle = ParseExtendsClass.getLifeCycle(childMap);
                    methodLifeCycle.interSection(classLifeCycle);
                    String methodName = "";
                    for (int k = 0; k < childMap.getLength(); k++){
                        Node node = childMap.item(k);
                        if ("name".equals(node.getNodeName())){
                            methodName = node.getNodeValue();
                        }
                    }

                    result.put(className+":"+methodName, methodLifeCycle);
                }
            }
        }
        return result;
    }
}
