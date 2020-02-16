package apk.download;

public class AndroidZooModel {
    public String sha256;
    public String sha1;
    public String md5;
    public String dex_date;
    public long apk_size;
    public String pkg_name;
    public int vercode;
    public int vt_detection;
    public String vt_scan_date;
    public long dex_size;
    public String markets;

    public AndroidZooModel(String sha256, String sha1, String md5, String dex_date, long apk_size, String pkg_name,
                           int vercode, int vt_detection, String vt_scan_date, long dex_size, String markets){
        this.sha256 = sha256;
        this.sha1 = sha1;
        this.md5 = md5;
        this.dex_date = dex_date;
        this.apk_size = apk_size;
        this.pkg_name = pkg_name;
        this.vercode = vercode;
        this.vt_detection = vt_detection;
        this.vt_scan_date = vt_scan_date;
        this.dex_size = dex_size;
        this.markets = markets;
    }

    @Override
    public String toString(){
        return "{" + sha256 + "," +
                sha1 + "," +
                md5 + "," +
                dex_date + "," +
                apk_size + "," +
                pkg_name + "," +
                vercode + "," +
                vt_detection + "," +
                vt_scan_date + "," +
                dex_size + "," +
                markets + "}";
    }
}
