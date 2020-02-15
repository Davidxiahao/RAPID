package apk.download;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class TopList {
    public static void main(String[] args) {
        Map<String, AndroidRankModel> test = readAndroidRankCSV();
        for (Map.Entry<String, AndroidRankModel> entry : test.entrySet()){
            System.out.println(entry.getKey());
            System.out.println("=====>");
            System.out.println(entry.getValue().toString());
            System.out.println();
        }
    }

    public static Map<String, AndroidRankModel> readAndroidRankCSV(){
        Map<String, AndroidRankModel> resultMap = new HashMap<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader("/Users/xiahao/Downloads/applist.csv"));
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
}
