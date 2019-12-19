package check.detection;

import soot.SootMethod;
import soot.Unit;
import soot.Value;
import soot.ValueBox;
import soot.jimple.InvokeExpr;
import soot.jimple.infoflow.solver.cfg.IInfoflowCFG;
import soot.jimple.internal.*;
import soot.toolkits.graph.Block;
import soot.toolkits.graph.BriefBlockGraph;
import utils.CheckedAPIInvoke;
import utils.CommonUtil;

import java.util.*;

public class DataFlowAnalyze {
    public ApkMetaInfo apkMetaInfo;
    public IInfoflowCFG cfg;
    public BriefBlockGraph briefBlockGraph;
    public SootMethod method;
    public Map<Unit, FlowUnit> unitMap;
    public Set<Block> inputChangedBlock;
    public Set<Unit> ifElseUnits = new HashSet<>();
    public Set<Unit> ifUnits = new HashSet<>();

    public DataFlowAnalyze(ApkMetaInfo apkMetaInfo, IInfoflowCFG cfg, SootMethod method,
                           BriefBlockGraph briefBlockGraph){
        this.apkMetaInfo = apkMetaInfo;
        this.cfg = cfg;
        this.method = method;
        this.briefBlockGraph = briefBlockGraph;
        inputChangedBlock = new HashSet<>();

    }

    private void doDataFlowAnalyze(){
        unitInitialize();
        inputChangedBlock.addAll(briefBlockGraph.getBlocks());
        while (!inputChangedBlock.isEmpty()){
            Set<Block> newInputChangedBlock = new HashSet<>();
            for (Block block : briefBlockGraph.getBlocks()){
                if (inputChangedBlock.contains(block)){
                    merge(block);
                    FlowData up = unitMap.get(block.getHead()).inFlow;
                    for (Unit unit : block){
                        FlowUnit flowUnit = unitMap.get(unit);
                        flowUnit.inFlow.addAll(up);
                        flowUnit.flowThrough();
                        up = flowUnit.outFlow;
                    }
                    if (unitMap.get(block.getTail()).outFlowChanged){
                        newInputChangedBlock.addAll(block.getSuccs());
                    }
                }
            }
            inputChangedBlock = newInputChangedBlock;
        }
    }

    private void unitInitialize(){
        unitMap = new HashMap<>();
        for (Unit unit : method.getActiveBody().getUnits()){
            FlowUnit flowUnit = new FlowUnit(unit, new FlowData(), new FlowData());
            unitMap.put(unit, flowUnit);
        }
    }

    private void merge(Block block){
        FlowUnit firstUnit = unitMap.get(block.getHead());
        for (Block pred : block.getPreds()){
            Unit tailUnit = pred.getTail();
            firstUnit.inFlow.addAll(unitMap.get(tailUnit).outFlow);
            if (tailUnit instanceof JIfStmt && unitMap.get(tailUnit).isTainted){
                JIfStmt ifUnit = (JIfStmt) tailUnit;
                if (ifUnit.getTarget().equals(block.getHead())){
                    Set<Boolean> temp = new HashSet<>();
                    temp.add(true);
                    firstUnit.inFlow.conditionMap.put(unitMap.get(tailUnit), temp);
                }else {
                    Set<Boolean> temp = new HashSet<>();
                    temp.add(false);
                    firstUnit.inFlow.conditionMap.put(unitMap.get(tailUnit), temp);
                }
                FlowUnit unit = unitMap.get(tailUnit);
                firstUnit.inFlow.conditionTag.put(ifUnit.getCondition(), unit.taintedTag);
            }
        }
    }

    public void getIfElseSituation(){
        Map<FlowUnit, Set<Boolean>> conditionMap = new HashMap<>();
        for (Unit unit : method.getActiveBody().getUnits()){
            if (unitMap.get(unit) != null && unitMap.get(unit).haveCondition()){
                for (Map.Entry<FlowUnit, Set<Boolean>> entry : unitMap.get(unit).inFlow.conditionMap.entrySet()){
                    if (entry.getValue().size() == 1){
                        if (unit instanceof JReturnVoidStmt){
                            continue;
                        }
                        Set<Boolean> value = conditionMap.getOrDefault(entry.getKey(), new HashSet<>());
                        value.addAll(entry.getValue());
                        conditionMap.put(entry.getKey(), value);
                    }
                }
            }
        }

        Set<FlowUnit> ifElseCondition = new HashSet<>();
        Set<FlowUnit> ifCondition = new HashSet<>();
        for (Map.Entry<FlowUnit, Set<Boolean>> entry : conditionMap.entrySet()){
            JIfStmt ifUnit = (JIfStmt) entry.getKey().myUnit;
            if (entry.getValue().size()==1){
                ifCondition.add(entry.getKey());
            }else {
                ifElseCondition.add(entry.getKey());
            }
        }

        for (Unit unit : method.getActiveBody().getUnits()){
            for (FlowUnit check : ifElseCondition){
                if (unitMap.containsKey(unit) && unitMap.get(unit).inFlow.conditionMap.containsKey(check)
                && unitMap.get(unit).inFlow.conditionMap.get(check).size() == 1){
                    ifElseUnits.add(unit);
                }
            }
        }

        for (Unit unit : method.getActiveBody().getUnits()){
            for (FlowUnit check : ifCondition){
                if (unitMap.containsKey(unit) && unitMap.get(unit).inFlow.conditionMap.containsKey(check)
                && unitMap.get(unit).inFlow.conditionMap.get(check).size() == 1){
                    ifUnits.add(unit);
                }
            }
        }
    }

    public void doUnitConditionAnalyze(){
        for (Unit unit : method.getActiveBody().getUnits()){
            if (unitMap.get(unit) != null && unitMap.get(unit).haveCondition()){
                String conditions = "";
                for (Map.Entry<FlowUnit, Set<Boolean>> entry : unitMap.get(unit).inFlow.conditionMap.entrySet()){
                    if (entry.getValue().size() == 1){
                        JIfStmt ifUnit = (JIfStmt) entry.getKey().myUnit;
                        Value condition = ifUnit.getCondition();
                        if (entry.getValue().contains(false)){
                            String out = null;
                            if (condition instanceof JEqExpr){
                                out = entry.getKey().printLocalsInUnit(condition)
                                        .replace(" == ", " != ");
                            }else if (condition instanceof JGeExpr){
                                out = entry.getKey().printLocalsInUnit(condition)
                                        .replace(" >= ", " < ");
                            }else if (condition instanceof JGtExpr){
                                out = entry.getKey().printLocalsInUnit(condition)
                                        .replace(" > ", " <= ");
                            }else if (condition instanceof JLeExpr){
                                out = entry.getKey().printLocalsInUnit(condition)
                                        .replace(" <= ", " > ");
                            }else if (condition instanceof JLtExpr){
                                out = entry.getKey().printLocalsInUnit(condition)
                                        .replace(" < ", " >= ");
                            }else if (condition instanceof JNeExpr){
                                out = entry.getKey().printLocalsInUnit(condition)
                                        .replace(" != ", " == ");
                            }
                            if (out != null){
                                conditions = conditions + "{ " + out + " }";
                            }
                        }else {
                            conditions = conditions + "{ " + entry.getKey().printLocalsInUnit(condition) + " }";
                        }
                    }
                }
                unitMap.get(unit).conditions = conditions;
            }
        }
    }

    public List<CheckedAPIInvoke> findPattern(){
        List<CheckedAPIInvoke> result = new ArrayList<>();
        getIfElseSituation();
        doUnitConditionAnalyze();

        for (Unit unit : ifElseUnits){
            boolean[] unitAvailable = getUnitSDKVersion(unit);
            for (ValueBox valueBox : unit.getUseBoxes()){
                if (valueBox.getValue() instanceof InvokeExpr){
                    String methodJNIName = CommonUtil.getJNIName(valueBox.getValue());
                    
                }
            }
        }
        return null;
    }

    public boolean[] getUnitSDKVersion(Unit unit){
        boolean[] result = new boolean[29];
        for (int i = 1; i <= 28; i++){
            result[i] = true;
        }
        try {
            if (unitMap.containsKey(unit) && unitMap.get(unit).haveCondition()){
                String conditions = unitMap.get(unit).conditions;
                if (conditions == null){
                    return result;
                }
                for (String string : conditions.split("}")){
                    if (!string.contains("<android.os.Build$VERSION: int SDK_INT>")) {
                        break;
                    }
                    int index = string.indexOf("virtualinvoke  staticinvoke <java.lang.Integer: java.lang.Integer " +
                            "valueOf(int)>( <android.os.Build$VERSION: int SDK_INT>).<java.lang.Integer: int " +
                            "intValue()>()");
                    String s1 = null;
                    String s2 = null;
                    if (index == -1) {
                        s1 = string.substring(0, string.indexOf("<android.os.Build$VERSION: int SDK_INT>"));
                        s2 = string.substring(string.indexOf("<android.os.Build$VERSION: int SDK_INT>") + 40,
                                string.length());
                    }else {
                        s1 = string.substring(0, index);
                        s2 = string.substring(index + 160, string.length());
                    }

                    String[] sArray;
                    if (s1.length() < s2.length()) {
                        sArray = s2.split(" ");
                        int value = Integer.parseInt(sArray[1]);
                        if (sArray[0].equals(">")) {
                            for(int i=1; i<=value; i++) {
                                result[i] = false;
                            }
                        }
                        if (sArray[0].equals(">=")) {
                            for(int i=1; i<value; i++) {
                                result[i] = false;
                            }
                        }
                        if (sArray[0].equals("==")) {
                            for(int i=1; i<=28; i++) {
                                if (i!=value) {
                                    result[i] = false;
                                }
                            }
                        }
                        if (sArray[0].equals("!=")) {
                            result[value] = false;
                        }
                        if (sArray[0].equals("<")) {
                            for(int i=value; i<=28; i++) {
                                result[i] = false;
                            }
                        }
                        if (sArray[0].equals("<=")) {
                            for(int i=value+1; i<=28; i++) {
                                result[i] = false;
                            }
                        }
                    }else {
                        sArray = s1.split(" ");
                        int value = Integer.parseInt(sArray[1]);
                        if (sArray[2].equals("<")) {
                            for(int i=1; i<=value; i++) {
                                result[i] = false;
                            }
                        }
                        if (sArray[2].equals("<=")) {
                            for(int i=1; i<value; i++) {
                                result[i] = false;
                            }
                        }
                        if (sArray[2].equals("==")) {
                            for(int i=1; i<=28; i++) {
                                if (i!=value) {
                                    result[i] = false;
                                }
                            }
                        }
                        if (sArray[2].equals("!=")) {
                            result[value] = false;
                        }
                        if (sArray[2].equals(">")) {
                            for(int i=value; i<=28; i++) {
                                result[i] = false;
                            }
                        }
                        if (sArray[2].equals(">=")) {
                            for(int i=value+1; i<=28; i++) {
                                result[i] = false;
                            }
                        }
                    }
                }
                String out = "";
                for (int i = 1; i <= 28; i++){
                    out = out + i + ":" + result[i] + " ";
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            for (int i = 1; i <= 28; i++){
                result[i] = false;
            }
        }

        return result;
    }
}
