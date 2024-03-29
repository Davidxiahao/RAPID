package utils;

public class LifeCycle {
    public boolean[] availableVersion;
    public boolean[] recommendVersion;
    public int maxVersion;

    public LifeCycle(int maxVersion){
        this.maxVersion = maxVersion;
        availableVersion = new boolean[maxVersion + 1];
        recommendVersion = new boolean[maxVersion + 1];
        for (int i = 1; i <= maxVersion; i++){
            availableVersion[i] = false;
            recommendVersion[i] = false;
        }
    }

    public void interSection(LifeCycle bLifeCycle){
        for (int i = 1; i <= maxVersion; i++){
            if (!bLifeCycle.availableVersion[i]){
                availableVersion[i] = false;
            }
            if (!bLifeCycle.recommendVersion[i]){
                recommendVersion[i] = false;
            }
        }
    }
}
