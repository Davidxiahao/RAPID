package apk.download;

import java.util.Map;

import static apk.download.TopList.readAndroidZooCSV;

public class StatisticsDexDate {
    public static void main(String[] args) {
        Map<String, AndroidZooModel> libMap = readAndroidZooCSV();
        int dex1980 = 0;
        int dexbefore2018 = 0;
        int dex2018 = 0;
        int dex2019 = 0;
        int dex2020 = 0;
        int googlePlay = 0;
        for (AndroidZooModel line : libMap.values()){
            if (!line.markets.equals("play.google.com")) continue;
            googlePlay++;
            if (!line.dex_date.contains("-")){
                System.out.println(line);
                continue;
            }
            int year = Integer.parseInt(line.dex_date.split("-")[0]);
            if (year == 1980) dex1980++;
            else if (year < 2018) dexbefore2018++;
            else if (year == 2018) dex2018++;
            else if (year == 2019) dex2019++;
            else if (year == 2020) dex2020++;
        }
        System.out.println("Google Play Apps: " + googlePlay);
        System.out.println("Dex date is 1980: " + dex1980);
        System.out.println("Dex date before 2018: " + dexbefore2018);
        System.out.println("Dex date is 2018: " + dex2018);
        System.out.println("Dex date is 2019: " + dex2019);
        System.out.println("Dex date is 2020: " + dex2020);
    }
}
