package utils;

public class TestModel {
    public int id;
    public String apkHash;
    public String apiName;
    public String apiInvokeStmtMethodFullName;
    public int apiInvokeStmtUnitOffset;
    public int checked;
    public int isSingleIf;
    public String checkedCondition;
    public String checkStmtMethodFullName;
    public int checkStmtUnitOffset;

    public TestModel(String apkHash, String apiName, String apiInvokeStmtMethodFullName,
                     int apiInvokeStmtUnitOffset, int checked, int isSingleIf,
                     String checkedCondition, String checkStmtMethodFullName, int checkStmtUnitOffset){
        this.apkHash = apkHash;
        this.apiName = apiName;
        this.apiInvokeStmtMethodFullName = apiInvokeStmtMethodFullName;
        this.apiInvokeStmtUnitOffset = apiInvokeStmtUnitOffset;
        this.checked = checked;
        this.isSingleIf = isSingleIf;
        this.checkedCondition = checkedCondition;
        this.checkStmtMethodFullName = checkStmtMethodFullName;
        this.checkStmtUnitOffset = checkStmtUnitOffset;
    }
}
