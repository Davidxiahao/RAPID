package apk.download;

public class AndroidRankModel {
    public String packageName;
    public String appName;
    public String category;
    public long installs;
    public long size;
    public float rating;
    public String price;
    public float growth30;
    public float growth60;

    public AndroidRankModel(String packageName, String appName, String category, long installs, long size, float rating,
                            String price, float growth30, float growth60){
        this.packageName = packageName;
        this.appName = appName;
        this.category = category;
        this.installs = installs;
        this.size = size;
        this.rating = rating;
        this.price = price;
        this.growth30 = growth30;
        this.growth60 = growth60;
    }

    @Override
    public String toString(){
        return "{" + packageName + "," +
                appName + "," +
                category + "," +
                installs + "," +
                size + "," +
                rating + "," +
                price + "," +
                growth30 + "," +
                growth60 + "}";
    }
}
