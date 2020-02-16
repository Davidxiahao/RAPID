package utils;

import soot.SootMethod;
import soot.Unit;
import soot.Value;
import soot.ValueBox;
import soot.jimple.InvokeExpr;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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

    public static String getJNIName(SootMethod method){
        String invokeSignature = method.getSignature();
        String findMethod = invokeSignature.split(": ")[0].replaceAll("<", "") + ":"
                + invokeSignature.split(" ")[2].split("\\(")[0];
        return findMethod + SootMethodForJavaH.getDesc(method);
    }

    public static String getInvokeAPIName(Unit invokeUnit){
        for (ValueBox valueBox : invokeUnit.getUseBoxes()){
            if (valueBox.getValue() instanceof InvokeExpr){
                return CommonUtil.getJNIName(valueBox.getValue());
            }
        }
        return null;
    }

    public static int getUnitOffsetInMethod(SootMethod method, Unit unit){
        int offset = 0;
        for (Unit u : method.getActiveBody().getUnits()){
            offset++;
            if (u.equals(unit))
                return offset;
        }
        return -1;
    }

    public static void writeToFile(String fileName, String content) {
        try {
            File file = new File(fileName);
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fWriter = new FileWriter(file.getAbsolutePath());
            BufferedWriter bWriter = new BufferedWriter(fWriter);
            bWriter.write(content);
            bWriter.close();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
