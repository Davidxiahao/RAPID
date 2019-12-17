package check.detection;

import soot.Value;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FlowData {
    public Map<FlowUnit, Set<Boolean>> conditionMap;
    public Map<Value, Set<String>> conditionTag;
    public Map<Value, FlowUnit> localVar;
    public Set<String> taintSet;
    public Map<String, Set<String>> taintTag;

    public FlowData(){
        conditionMap = new HashMap<>();
        conditionTag = new HashMap<>();
        localVar = new HashMap<>();
        taintSet = new HashSet<>();
        taintTag = new HashMap<>();
    }

    public void addAll(FlowData flowData){
        //the key of conditionMap is the FlowUnit of one SDK_INT check condition, the value true means this unit in the
        //true branch of the condition, false means this unit in the false branch of the condition. Both true and false
        //means no matter what the conditions, this unit will be run.
        for (Map.Entry<FlowUnit, Set<Boolean>> entry : flowData.conditionMap.entrySet()){
            if (!conditionMap.containsKey(entry.getKey())){
                conditionMap.put(entry.getKey(), new HashSet<>(entry.getValue()));
            }else {
                conditionMap.get(entry.getKey()).addAll(entry.getValue());
            }
        }
        //condition tag contains the condition expression, like SDK_INT > 19
        for (Map.Entry<Value, Set<String>> entry : flowData.conditionTag.entrySet()){
            if (!conditionTag.containsKey(entry.getKey())){
                conditionTag.put(entry.getKey(), new HashSet<>(entry.getValue()));
            }
        }
    }
}
