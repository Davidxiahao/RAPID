package check.detection;

import soot.Scene;
import soot.SootMethod;
import soot.Unit;
import soot.ValueBox;
import soot.jimple.InvokeExpr;
import soot.jimple.infoflow.android.SetupApplication;
import soot.jimple.infoflow.config.IInfoflowConfig;
import soot.jimple.infoflow.solver.cfg.IInfoflowCFG;
import soot.jimple.infoflow.solver.cfg.InfoflowCFG;
import soot.toolkits.graph.BriefBlockGraph;
import utils.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class ApkAnalyzer {
    private String apkFile;
    private String androidPath;
    public ApkMetaInfo apkMetaInfo;
    public List<CheckedAPIInvoke> checkedAPIInvokeList = new ArrayList<>();
    public List<UnCheckedAPIInvoke> unCheckedAPIInvokeList = new ArrayList<>();

    public ApkAnalyzer(String androidPath, String apkFile){
        this.androidPath = androidPath;
        this.apkFile = apkFile;
        apkMetaInfo = new ApkMetaInfo(apkFile);
    }

    public long doAnalysis(){
        long start = System.currentTimeMillis();

        runWithFlowDroid(this.androidPath, this.apkFile);

        return (System.currentTimeMillis()-start)/1000;
    }

    public void runWithFlowDroid(String androidPath, String apkFile){
        SetupApplication application = new SetupApplication(androidPath, apkFile);
        IInfoflowConfig iInfoflowConfig = new ConfigForAndroidMultipleDex();
        application.setSootConfig(iInfoflowConfig);
        application.constructCallgraph();
        InfoflowCFG ifcg = new InfoflowCFG();
        SootMethod dummyMain = application.getDummyMainMethod();
        traverse(ifcg, dummyMain, new HashSet<>());
    }

    public void traverse(IInfoflowCFG cfg, SootMethod method, HashSet<String> visited){
        if (!Scene.v().getApplicationClasses().contains(method.getDeclaringClass())) return;
        //todo Exclude third-party packages for Android itself
        String methodName = CommonUtil.getJNIName(method);
        if (CommonUtil.methodLifeCycle.containsKey(methodName)) return;
        if (method.hasActiveBody() && !visited.contains(method.getSignature())){
            visited.add(method.getSignature());

            BriefBlockGraph briefBlockGraph = new BriefBlockGraph(method.getActiveBody());
            DataFlowAnalyze dataFlowAnalyze = new DataFlowAnalyze(apkMetaInfo, cfg, method, briefBlockGraph);

            checkedAPIInvokeList.addAll(dataFlowAnalyze.findPattern());

            for (Unit unit : method.getActiveBody().getUnits()){
                for (ValueBox valueBox : unit.getUseBoxes()){
                    if (valueBox.getValue() instanceof InvokeExpr){
                        String methodJNIName = CommonUtil.getJNIName(valueBox.getValue());
                        if (CommonUtil.methodLifeCycle.containsKey(methodJNIName)){
                            boolean[] available = dataFlowAnalyze.getUnitSDKVersion(unit);
                            String notAvailableVersion = check(CommonUtil.methodLifeCycle.get(methodJNIName),
                                    available);
                            if (!notAvailableVersion.equals("")){
                                unCheckedAPIInvokeList.add(new UnCheckedAPIInvoke(apkMetaInfo,
                                        method,
                                        unit));
                            }
                        }
                    }
                }
            }

            for (Unit unit : method.getActiveBody().getUnits()){
                for (SootMethod calleeMethod : cfg.getCalleesOfCallAt(unit)){
                    traverse(cfg, calleeMethod, visited);
                }
            }
        }
    }

    private String check(LifeCycle lifeCycle, boolean[] available){
        StringBuilder output = new StringBuilder();
        boolean notAvailable = false;
        for (int i = apkMetaInfo.getMinSdkVersion(); i <= ParseExtendsClass.maxVersion; i++){
            if (!lifeCycle.recommendVersion[i] && available[i]){
                output.append(i).append(" ");
                notAvailable = true;
            }
        }

        if (notAvailable){
            output = new StringBuilder("[" + output + "]");
        }

        return output.toString();
    }
}
