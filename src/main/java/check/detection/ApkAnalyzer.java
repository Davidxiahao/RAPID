package check.detection;

import soot.SootMethod;
import soot.jimple.infoflow.android.SetupApplication;
import soot.jimple.infoflow.config.IInfoflowConfig;
import soot.jimple.infoflow.solver.cfg.IInfoflowCFG;
import soot.jimple.infoflow.solver.cfg.InfoflowCFG;

import java.util.HashSet;

public class ApkAnalyzer {
    private String apkFile;
    private String androidPath;
    public ApkMetaInfo apkMetaInfo;

    public ApkAnalyzer(String androidPath, String apkFile){
        this.androidPath = androidPath;
        this.apkFile = apkFile;
        apkMetaInfo = new ApkMetaInfo(apkFile);
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

    }
}
