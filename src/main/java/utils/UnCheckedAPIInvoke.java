package utils;

import check.detection.ApkMetaInfo;
import soot.SootMethod;
import soot.Unit;

public class UnCheckedAPIInvoke {
    public ApkMetaInfo apkMetaInfo;
    public SootMethod targetMethod;
    public Unit invokeUnit;

    public UnCheckedAPIInvoke(ApkMetaInfo apkMetaInfo, SootMethod targetMethod,
                              Unit invokeUnit){
        this.apkMetaInfo = apkMetaInfo;
        this.targetMethod = targetMethod;
        this.invokeUnit = invokeUnit;
    }
}
