package apk.download;

import utils.CommonUtil;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopList {
    public static void main(String[] args) {
        Map<String, AndroidRankModel> topMap = readAndroidRankCSV();
        Map<String, AndroidZooModel> libMap = readAndroidZooCSV();
        Map<String, String> downloaded = readApk100w();
        List<String> nList = new ArrayList<>();
        List<String> hList = new ArrayList<>();
        List<String> wList = new ArrayList<>();
        for (String packageName : topMap.keySet()){
            AndroidZooModel libApk = libMap.getOrDefault(packageName, null);
            if (libApk != null){
                if (downloaded.containsKey(libApk.md5)){
                    hList.add(packageName);
                }else {
                    wList.add(libApk.sha256);
                }
            }else {
                nList.add(packageName);
            }
        }
        StringBuilder builder = new StringBuilder();
        builder.append("nList").append("\n");
        for (String line : nList){
            builder.append(line).append("\n");
        }
        builder.append("hList").append("\n");
        for (String line : hList){
            builder.append(line).append("\n");
        }
        builder.append("wList").append("\n");
        for (String line : wList){
            builder.append(line).append("\n");
        }
        CommonUtil.writeToFile("waitdownload", builder.toString());
    }

    public static Map<String, AndroidRankModel> readAndroidRankCSV(){
        Map<String, AndroidRankModel> resultMap = new HashMap<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader("applist.csv"));
            String line;
            while ((line = reader.readLine()) != null){
                String[] info = line.split(",");
                if (info.length != 9) continue;
                resultMap.put(info[0], new AndroidRankModel(info[0], info[1], info[2], Long.parseLong(info[3]),
                        Long.parseLong(info[4]), Float.parseFloat(info[5]), info[6], Float.parseFloat(info[7]),
                        Float.parseFloat(info[8])));
            }
        }catch (FileNotFoundException e){
            System.out.println("没找到AndroidRank的csv");
        }catch (IOException e){
            System.out.println("读写AndroidRank的csv时出错");
        }
        return resultMap;
    }

    public static Map<String, AndroidZooModel> readAndroidZooCSV(){
        Map<String, AndroidZooModel> resultMap = new HashMap<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader("latest.csv"));
            String line;
            long lineNumber = 0;
            while ((line = reader.readLine()) != null){
                lineNumber++;
                if (lineNumber == 1) continue;
                String[] info = line.split(",");
                if (info.length != 11) continue;
                String packageName = info[5].replace("\"", "");
                //System.out.println(line);
                if (info[4].equals("")) info[4] = "-1";
                if (info[6].equals("")) info[6] = "-1";
                if (info[7].equals("")) info[7] = "-1";
                if (info[9].equals("")) info[9] = "-1";
                resultMap.put(packageName, new AndroidZooModel(info[0], info[1], info[2], info[3],
                        Long.parseLong(info[4]), packageName, Integer.parseInt(info[6]), Integer.parseInt(info[7]),
                        info[8], Long.parseLong(info[9]), info[10]));
            }
        }catch (FileNotFoundException e){
            System.out.println("没找到AndroidZoo的csv");
        }catch (IOException e){
            System.out.println("读写AndroidZoo的csv时出错");
        }
        return resultMap;
    }

    public static Map<String, String> readApk100w(){
        Map<String, String> resultMap = new HashMap<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader("apks_benign_hash_path_100w.csv"));
            String line;
            while ((line = reader.readLine()) != null){
                String[] info = line.split(",");
                if (info.length != 3) continue;
                resultMap.put(info[0], info[2]);
            }
        }catch (FileNotFoundException e){
            System.out.println("没找到100wAPK的csv");
        }catch (IOException e){
            System.out.println("读写100wAPK的csv时出错");
        }
        return resultMap;
    }
}
