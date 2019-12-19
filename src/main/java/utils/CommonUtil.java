package utils;

import soot.Value;
import soot.jimple.InvokeExpr;

public class CommonUtil {
    public static String getJNIName(Value value){
        InvokeExpr invokeExpr = (InvokeExpr) value;
        String invokeSignature = invokeExpr.getMethod().getSignature();
        String findMethod = invokeSignature.split(": ")[0].replaceAll("<", "") + ":"
                + invokeSignature.split(" ")[2].split("\\(")[0];
        return findMethod + SootMethodForJavaH.getDesc(invokeExpr.getMethod());
    }
}
