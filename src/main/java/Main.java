import check.detection.ApkAnalyzer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import utils.CheckedAPIInvoke;
import utils.CommonUtil;
import utils.MySQLDbService;
import utils.TestModel;

import java.util.ArrayList;
import java.util.List;

public class Main {
    static private Logger logger = LogManager.getLogger();
    public static void main(String[] args) {
        if (args.length < 2){
            System.err.println("Usage: java -cp RAPID.jar Main_Class <android_sdk_path> <apk_path>");
            System.exit(-1);
        }
        String androidJars = args[0];
        String apkPath = args[1];
        MySQLDbService.getInstance().createTestTable();
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
            List<TestModel> resultList = new ArrayList<>();
            for (CheckedAPIInvoke invoke : apkAnalyzer.checkedAPIInvokeList){
                System.out.println("targetMethod: " + invoke.targetMethod.getSignature());
                System.out.println("methodJNIName: " + invoke.methodJNIName);
                String apkHash = apkAnalyzer.apkMetaInfo.getApkHash();
                String apiName = CommonUtil.getInvokeAPIName(invoke.invokeUnit);
                String apiInvokeStmtMethodFullName = invoke.targetMethod.getSignature();
                int apiInvokeStmtUnitOffset = CommonUtil.getUnitOffsetInMethod(invoke.targetMethod, invoke.invokeUnit);
                int checked = 1;
                int isSingleIf = 0;
                if (invoke.isSingleIf()) isSingleIf = 1;
                String checkedCondition = invoke.condition;
                String checkedStmtMethodFullName = invoke.targetMethod.getSignature();
                int checkStmtUnitOffset = CommonUtil.getUnitOffsetInMethod(invoke.targetMethod, invoke.ifCheckUnit);
                resultList.add(new TestModel(apkHash, apiName, apiInvokeStmtMethodFullName, apiInvokeStmtUnitOffset,
                        checked, isSingleIf, checkedCondition, checkedStmtMethodFullName, checkStmtUnitOffset));
            }
            MySQLDbService.getInstance().insertTestTable(resultList);
        }
    }
}
