package check.detection;

import soot.SootMethod;
import soot.Unit;
import soot.jimple.infoflow.solver.cfg.IInfoflowCFG;
import soot.toolkits.graph.Block;
import soot.toolkits.graph.BriefBlockGraph;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

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

    }

    private void unitInitialize(){

    }
}
