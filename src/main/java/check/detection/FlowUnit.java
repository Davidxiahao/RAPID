package check.detection;

import soot.Unit;
import soot.ValueBox;
import soot.jimple.internal.JimpleLocal;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class FlowUnit {
    public Unit myUnit;
    public FlowData inFlow;
    public FlowData outFlow;
    public boolean outFlowChanged;
    public boolean isTainted;
    public Set<String> taintedTag;
    public String conditions;
    public int ifElseSituation;

    public FlowUnit(Unit myUnit, FlowData inFlow, FlowData outFlow){
        this.myUnit = myUnit;
        this.inFlow = inFlow;
        this.outFlow = outFlow;
        this.isTainted = false;
        this.outFlowChanged = false;
        this.taintedTag = new HashSet<>();
        this.conditions = null;
        this.ifElseSituation = 0;
    }

    public void flowThrough(){
        FlowData originalOutFlow = new FlowData();
        originalOutFlow.addAll(outFlow);

        outFlowChanged = false;
        taintedTag = new HashSet<>();
        outFlow.taintSet.addAll(inFlow.taintSet);
        outFlow.taintTag.putAll(inFlow.taintTag);

        for (ValueBox valueBox : myUnit.getUseBoxes()){
            if ("<android.os.Build$VERSION: int SDK_INT>".equals(valueBox.getValue().toString())){
                isTainted = true;
                outFlow.taintSet.addAll(myUnit.getDefBoxes().stream().map(v->v.getValue().toString())
                        .collect(Collectors.toList()));
                Set<String> tagSet = new HashSet<>();
                tagSet.add(valueBox.getValue().toString());
                taintedTag.add(valueBox.getValue().toString());
                for (ValueBox valueBox2 : myUnit.getDefBoxes()){
                    Set<String> temp = new HashSet<>(tagSet);
                    outFlow.taintTag.put(valueBox2.getValue().toString(), temp);
                }
            }else if (inFlow.taintSet.contains(valueBox.getValue().toString())){
                isTainted = true;
                outFlow.taintSet.addAll(myUnit.getDefBoxes().stream().map(v->v.getValue().toString())
                        .collect(Collectors.toList()));
                if (outFlow.taintTag.get(valueBox.getValue().toString())!=null){
                    taintedTag.addAll(outFlow.taintTag.get(valueBox.getValue().toString()));
                }
                for (ValueBox valueBox2 : myUnit.getDefBoxes()){
                    Set<String> temp = new HashSet<>();
                    if (outFlow.taintTag.get(valueBox.getValue().toString())!=null){
                        temp.addAll(outFlow.taintTag.get(valueBox.getValue().toString()));
                    }
                    outFlow.taintTag.put(valueBox2.getValue().toString(), temp);
                }
            }
        }
        if (!isTainted){
            outFlow.taintSet.removeAll(myUnit.getDefBoxes().stream().map(v->v.getValue().toString())
                    .collect(Collectors.toList()));

            for (ValueBox valueBox : myUnit.getDefBoxes()){
                outFlow.taintTag.remove(valueBox.getValue().toString());
            }
        }
        outFlow.conditionMap = inFlow.conditionMap;
        outFlow.conditionTag.putAll(inFlow.conditionTag);
        outFlow.localVar.putAll(inFlow.localVar);
        for (ValueBox valueBox : myUnit.getDefBoxes()){
            if (valueBox.getValue() instanceof JimpleLocal){
                outFlow.localVar.put(valueBox.getValue(), this);
            }
        }
        if (!originalOutFlow.equals(outFlow)){
            outFlowChanged = true;
        }
    }

    public boolean haveCondition(){
        for (Map.Entry<FlowUnit, Set<Boolean>> entry : inFlow.conditionMap.entrySet()){
            if (entry.getValue().size()==1){
                return true;
            }
        }
        return false;
    }
}
