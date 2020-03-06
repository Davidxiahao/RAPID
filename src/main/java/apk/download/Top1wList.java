package apk.download;

import utils.CommonUtil;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static apk.download.TopList.*;

public class Top1wList {
    public static void main(String[] args) {
        Map<String, AndroidRankModel> topMap = readAndroidRankCSV();
        Map<String, List<AndroidZooModel>> libMap = readAndroidZooCSV();
        Map<String, String> downloaded = readApk100w();
        List<String> top1wList = readTop1w();
        List<String> hList = new ArrayList<>();
        List<String> wList = new ArrayList<>();
        List<String> nList = new ArrayList<>();
        StringBuilder builder = new StringBuilder();
        int apkCount = 0;
        int appCount = 0;
        for (String packageName : top1wList){
            if (topMap.containsKey(packageName)) continue;
            List<AndroidZooModel> libApk = libMap.getOrDefault(packageName, null);
            if (libApk != null){
                boolean has = false;
                for (AndroidZooModel model : libApk){
                    if (!model.dex_date.contains("-")) continue;
                    int year = Integer.parseInt(model.dex_date.split("-")[0]);
                    if (year < 2018) continue;
                    apkCount++;
                    has = true;
                    System.out.println(model.pkg_name+" "+model.dex_date+" "+model.vercode);
                    builder.append(model.pkg_name).append(" ").append(model.dex_date).append(" ").append(model.vercode).
                            append("\n");
                }
                if (has) appCount++;
                if (downloaded.containsKey(libApk.get(0).md5)){
                    hList.add(packageName);
                }else {
                    wList.add(libApk.get(0).sha256);
                }
            }else {
                nList.add(packageName);
            }
        }
        builder.append("appCount").append(" ").append(appCount).append("\n");
        builder.append("apkCount").append(" ").append(apkCount).append("\n");
//        builder.append("nList").append("\n");
//        for (String line : nList){
//            builder.append(line).append("\n");
//        }
//        builder.append("hList").append("\n");
//        for (String line : hList){
//            builder.append(line).append("\n");
//        }
//        builder.append("wList").append("\n");
//        for (String line : wList){
//            builder.append(line).append("\n");
//        }
        CommonUtil.writeToFile("waitdownload2", builder.toString());
    }

    public static List<String> readTop1w(){
        List<String> resultList = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader("PackageName"));
            String line;
            while ((line = reader.readLine()) != null){
                resultList.add(line);
            }
        }catch (FileNotFoundException e){
            System.out.println("没找到PackageName");
        }catch (IOException e){
            System.out.println("读写PackageName时出错");
        }
        return resultList;
    }
}
