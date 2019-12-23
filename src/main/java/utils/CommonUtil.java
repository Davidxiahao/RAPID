package utils;

import soot.Value;
import soot.jimple.InvokeExpr;

import java.util.Map;

public class CommonUtil {
    public static Map<String, LifeCycle> methodLifeCycle = ParseSourceCode.getMethodLifeCycle();
    public static String getJNIName(Value value){
        InvokeExpr invokeExpr = (InvokeExpr) value;
        String invokeSignature = invokeExpr.getMethod().getSignature();
        String findMethod = invokeSignature.split(": ")[0].replaceAll("<", "") + ":"
                + invokeSignature.split(" ")[2].split("\\(")[0];
        return findMethod + SootMethodForJavaH.getDesc(invokeExpr.getMethod());
    }
}
