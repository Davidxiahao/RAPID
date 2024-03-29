package check.detection;

import soot.*;
import soot.jimple.InvokeExpr;
import soot.jimple.infoflow.solver.cfg.IInfoflowCFG;
import soot.jimple.internal.*;
import soot.toolkits.graph.Block;
import soot.toolkits.graph.BriefBlockGraph;
import utils.CheckedAPIInvoke;
import utils.CommonUtil;
import utils.ParseExtendsClass;

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
    public Map<Unit, List<Unit>> inlineMap = new HashMap<>();

    public DataFlowAnalyze(ApkMetaInfo apkMetaInfo, IInfoflowCFG cfg, SootMethod method,
                           BriefBlockGraph briefBlockGraph){
        this.apkMetaInfo = apkMetaInfo;
        this.cfg = cfg;
        this.method = method;
        this.briefBlockGraph = briefBlockGraph;
        inputChangedBlock = new HashSet<>();
        doDataFlowAnalyze();
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
                        //inline
                        if (inlineMap.containsKey(unit)){
                            for (Unit inlineUnit : inlineMap.get(unit)){
                                FlowUnit flowUnit = unitMap.get(inlineUnit);
                                flowUnit.inFlow.addAll(up);
                                flowUnit.flowThrough();
                                up = flowUnit.outFlow;
                            }
                        }else {
                            FlowUnit flowUnit = unitMap.get(unit);
                            flowUnit.inFlow.addAll(up);
                            flowUnit.flowThrough();
                            up = flowUnit.outFlow;
                        }
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
            //inline
            for (SootMethod sootMethod : cfg.getCalleesOfCallAt(unit)){
                if (Scene.v().getApplicationClasses().contains(sootMethod.getDeclaringClass())){
                    for (Unit inlineUnit : sootMethod.getActiveBody().getUnits()){
                        FlowUnit inlineFlowUnit = new FlowUnit(inlineUnit, new FlowData(), new FlowData());
                        unitMap.put(inlineUnit, inlineFlowUnit);
                    }
                    inlineMap.put(unit, new ArrayList<>(sootMethod.getActiveBody().getUnits()));
                }
            }
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
        //for (Unit unit : method.getActiveBody().getUnits()){
        for (Unit unit : unitMap.keySet()){
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

        //for (Unit unit : method.getActiveBody().getUnits()){
        for (Unit unit : unitMap.keySet()){
            for (FlowUnit check : ifElseCondition){
                if (unitMap.containsKey(unit) && unitMap.get(unit).inFlow.conditionMap.containsKey(check)
                && unitMap.get(unit).inFlow.conditionMap.get(check).size() == 1){
                    ifElseUnits.add(unit);
                }
            }
        }

        //for (Unit unit : method.getActiveBody().getUnits()){
        for (Unit unit : unitMap.keySet()){
            for (FlowUnit check : ifCondition){
                if (unitMap.containsKey(unit) && unitMap.get(unit).inFlow.conditionMap.containsKey(check)
                && unitMap.get(unit).inFlow.conditionMap.get(check).size() == 1){
                    ifUnits.add(unit);
                }
            }
        }
    }

    public void doUnitConditionAnalyze(){
        //for (Unit unit : method.getActiveBody().getUnits()){
        for (Unit unit : unitMap.keySet()){
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
                    if (CommonUtil.methodLifeCycle.containsKey(methodJNIName)
                    && bestMatch(unitAvailable, CommonUtil.methodLifeCycle.get(methodJNIName).recommendVersion)){
                        List<Unit> elseBlockUnits = getElseBlockUnits(unit);
                        List<Unit> sameBlockUnits = getSameBlockUnits(unit);
                        boolean haveSameMethod = false;
                        for (Unit iUnit : elseBlockUnits){
                            for (ValueBox iValueBox : iUnit.getUseBoxes()){
                                if (iValueBox.getValue() instanceof InvokeExpr){
                                    String methodJNINameInElseBlock = CommonUtil.getJNIName(iValueBox.getValue());
                                    if (methodJNINameInElseBlock.equals(methodJNIName)) haveSameMethod = true;
                                }
                            }
                        }
                        if (haveSameMethod) continue;
                        result.add(new CheckedAPIInvoke(methodJNIName,
                                apkMetaInfo,
                                method,
                                unit,
                                getIfCheckUnit(unit),
                                unitMap.get(unit).conditions,
                                sameBlockUnits,
                                elseBlockUnits,
                                briefBlockGraph));
                    }
                }
            }
        }
        for (Unit unit : ifUnits){
            if (ifElseUnits.contains(unit)) continue;
            boolean[] unitAvailable = getUnitSDKVersion(unit);
            for (ValueBox valueBox : unit.getUseBoxes()){
                if (valueBox.getValue() instanceof InvokeExpr){
                    String methodJNIName = CommonUtil.getJNIName(valueBox.getValue());
                    if (CommonUtil.methodLifeCycle.containsKey(methodJNIName)
                    && bestMatch(unitAvailable, CommonUtil.methodLifeCycle.get(methodJNIName).recommendVersion)){
                        List<Unit> sameBlockUnits = getBlockUnits(unit);
                        List<Unit> elseBlockUnits = new ArrayList<>();
                        result.add(new CheckedAPIInvoke(methodJNIName,
                                apkMetaInfo,
                                method,
                                unit,
                                getIfCheckUnit(unit),
                                unitMap.get(unit).conditions,
                                sameBlockUnits,
                                elseBlockUnits,
                                briefBlockGraph));
                    }
                }
            }
        }
        return result;
    }

    private Set<Unit> getIfCheckUnit(Unit unit){
        Set<Unit> result = new HashSet<>();
        FlowUnit flowUnit = unitMap.get(unit);
        for (Map.Entry<FlowUnit, Set<Boolean>> entry : flowUnit.inFlow.conditionMap.entrySet()){
            if (entry.getValue().size() == 1){
                result.add(entry.getKey().myUnit);
            }
        }
        return result;
    }

    private List<Unit> getElseBlockUnits(Unit unit){
        List<Unit> result = new ArrayList<>();
        for (Unit iunit : ifElseUnits){
            boolean re = false;
            int count = 0;
            for (Map.Entry<FlowUnit, Set<Boolean>> entry : unitMap.get(unit).inFlow.conditionMap.entrySet()){
                if (re) continue;
                if (!unitMap.get(iunit).inFlow.conditionMap.containsKey(entry.getKey())
                || entry.getValue().size() != unitMap.get(iunit).inFlow.conditionMap.get(entry.getKey()).size()){
                    re = true;
                }else if ((entry.getValue().size() == 1) &&
                ((entry.getValue().contains(false) && !unitMap.get(iunit).inFlow.conditionMap.get(entry.getKey()).contains(false))
                || (entry.getValue().contains(true) && !unitMap.get(iunit).inFlow.conditionMap.get(entry.getKey()).contains(true)))){
                    count++;
                }
            }
            if (!re && count == 1){
                result.add(iunit);
            }
        }
        return result;
    }

    private List<Unit> getSameBlockUnits(Unit unit){
        List<Unit> result = new ArrayList<>();
        for (Unit iunit : ifElseUnits){
            boolean re = false;
            int count = 0;
            for (Map.Entry<FlowUnit, Set<Boolean>> entry : unitMap.get(unit).inFlow.conditionMap.entrySet()){
                if (re) continue;
                if (!unitMap.get(iunit).inFlow.conditionMap.containsKey(entry.getKey())
                || entry.getValue().size() != unitMap.get(iunit).inFlow.conditionMap.get(entry.getKey()).size()){
                    re = true;
                }else if ((entry.getValue().size() == 1)
                && ((entry.getValue().contains(false)
                        && !unitMap.get(iunit).inFlow.conditionMap.get(entry.getKey()).contains(false))
                    || (entry.getValue().contains(true)
                        && !unitMap.get(iunit).inFlow.conditionMap.get(entry.getKey()).contains(true)))){
                    count++;
                }
            }
            if (!re && count == 0){
                result.add(iunit);
            }
        }
        return result;
    }

    private List<Unit> getBlockUnits(Unit unit){
        List<Unit> result = new ArrayList<>();
        for (Unit iUnit : ifUnits){
            boolean re = false;
            int count = 0;
            for (Map.Entry<FlowUnit, Set<Boolean>> entry : unitMap.get(unit).inFlow.conditionMap.entrySet()){
                if (re) continue;
                if (!unitMap.get(iUnit).inFlow.conditionMap.containsKey(entry.getKey())
                || entry.getValue().size() != unitMap.get(iUnit).inFlow.conditionMap.get(entry.getKey()).size()){
                    re = true;
                }else if ((entry.getValue().size() == 1)
                && ((entry.getValue().contains(false)
                        && !unitMap.get(iUnit).inFlow.conditionMap.get(entry.getKey()).contains(false))
                || (entry.getValue().contains(true)
                        && !unitMap.get(iUnit).inFlow.conditionMap.get(entry.getKey()).contains(true)))){
                    count++;
                }
            }
            if (!re && count == 0){
                result.add(iUnit);
            }
        }
        return result;
    }

    private boolean bestMatch(boolean[] unitAvailable, boolean[] recommendVersion){
        for (int i = 1; i <= ParseExtendsClass.maxVersion; i++){
            if (unitAvailable[i]!=recommendVersion[i]){
                return false;
            }
        }
        return true;
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
