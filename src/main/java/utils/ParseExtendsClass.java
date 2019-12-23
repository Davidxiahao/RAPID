package utils;

import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

public class ParseExtendsClass {
    public static int maxVersion = 28;
    public static LifeCycle getLifeCycle(NamedNodeMap namedNodeMap){
        LifeCycle newLifeCycle = new LifeCycle(maxVersion);

        boolean hasSince = false;
        for (int i = 0; i < namedNodeMap.getLength(); i++){
            Node node = namedNodeMap.item(i);
            if ("since".equals(node.getNodeName())){
                hasSince = true;
                int sinceVersion = Integer.parseInt(node.getNodeValue());
                for (int k = sinceVersion; k <= maxVersion; k++){
                    newLifeCycle.availableVersion[k] = true;
                    newLifeCycle.recommendVersion[k] = true;
                }
            }
        }
        if (!hasSince){
            for (int i = 1; i <= maxVersion; i++){
                newLifeCycle.availableVersion[i] = true;
                newLifeCycle.recommendVersion[i] = true;
            }
        }

        for (int i = 0; i < namedNodeMap.getLength(); i++){
            Node node = namedNodeMap.item(i);
            if ("deprecated".equals(node.getNodeName())){
                int deprecatedVersion = Integer.parseInt(node.getNodeValue());
                for (int k = deprecatedVersion; k <= maxVersion; k++){
                    newLifeCycle.recommendVersion[k] = false;
                }
            }
        }

        for (int i = 0; i < namedNodeMap.getLength(); i++){
            Node node = namedNodeMap.item(i);
            if ("removed".equals(node.getNodeName())){
                int removedVersion = Integer.parseInt(node.getNodeValue());
                for (int k = removedVersion; k <= maxVersion; k++){
                    newLifeCycle.availableVersion[k] = false;
                    newLifeCycle.recommendVersion[k] = false;
                }
            }
        }

        return newLifeCycle;
    }
}
