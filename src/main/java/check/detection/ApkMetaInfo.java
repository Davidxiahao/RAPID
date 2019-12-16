package check.detection;

import org.apache.commons.codec.digest.DigestUtils;
import org.xmlpull.v1.XmlPullParserException;
import soot.jimple.infoflow.android.manifest.ProcessManifest;

import java.io.FileInputStream;
import java.io.IOException;

public class ApkMetaInfo {
    private String apkHash;
    private String packageName;
    private String appName;
    private String apkPath;
    private int minSdkVersion;
    private int targetSdkVersion;

    public ApkMetaInfo(String apkPath){
        this.apkPath = apkPath;

        //use apache common codec to get apk md5
        try {
            this.apkHash = DigestUtils.md5Hex(new FileInputStream(apkPath));
        } catch (IOException e) {
            e.printStackTrace();
        }

        //use infoflow android to get apk manifest information
        ProcessManifest processManifest = null;
        try {
            processManifest = new ProcessManifest(apkPath);
        } catch (IOException | XmlPullParserException e) {
            e.printStackTrace();
        }

        if (processManifest != null){
            this.packageName = processManifest.getPackageName();
            this.appName = processManifest.getApplicationName();
            this.minSdkVersion = processManifest.getMinSdkVersion();
            this.targetSdkVersion = processManifest.targetSdkVersion();
        }
    }

    public String getApkPath() {return apkPath;}
    public String getApkHash() {return apkHash;}
    public String getAppName() {return appName;}
    public String getPackageName() {return packageName;}
    public int getMinSdkVersion() {return minSdkVersion;}
    public int getTargetSdkVersion() {return targetSdkVersion;}
}
