import check.detection.ApkAnalyzer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import utils.CheckedAPIInvoke;

public class Main {
    static private Logger logger = LogManager.getLogger();
    public static void main(String[] args) {
        if (args.length < 2){
            System.err.println("Usage: java -cp RAPID.jar Main_Class <android_sdk_path> <apk_path>");
            System.exit(-1);
        }
        String androidJars = args[0];
        String apkPath = args[1];

        predicChecksInApk(androidJars, apkPath);
    }

    public static void predicChecksInApk(String androidJars, String apkPath){
        ApkAnalyzer apkAnalyzer = new ApkAnalyzer(androidJars, apkPath);
        long timeUsed = 0;
        try {
            timeUsed = apkAnalyzer.doAnalysis();
            logger.info("Time used: " + timeUsed);
        }catch (Exception e){
            e.printStackTrace();
        }
        if (timeUsed != 0){
            for (CheckedAPIInvoke invoke : apkAnalyzer.checkedAPIInvokeList){
                System.out.println("targetMethod: " + invoke.targetMethod.getSignature());
                System.out.println("methodJNIName: " + invoke.methodJNIName);
            }
        }
    }
}
