import check.detection.ApkAnalyzer;

public class Main {
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

    }
}
