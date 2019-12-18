package check.detection;

import soot.SootMethod;
import soot.Unit;
import soot.jimple.infoflow.solver.cfg.IInfoflowCFG;
import soot.jimple.internal.JIfStmt;
import soot.jimple.internal.JReturnVoidStmt;
import soot.toolkits.graph.Block;
import soot.toolkits.graph.BriefBlockGraph;
import utils.CheckedAPIInvoke;

import java.util.*;

public class DataFlowAnalyze {
    public ApkMetaInfo apkMetaInfo;
    public IInfoflowCFG cfg;
    public BriefBlockGraph briefBlockGraph;
    public SootMethod method;
    public Map<Unit, FlowUnit> unitMap;
    public Set<Block> inputChangedBlock;

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
    }

    public List<CheckedAPIInvoke> findPattern(){
        List<CheckedAPIInvoke> result = new ArrayList<>();
        return null;
    }
}
